package com.moda.adm.event;

import com.moda.adm.event.service.EventService;
import com.moda.adm.paging.PagingResponse;
import com.moda.adm.search.SearchDto;
import com.moda.cmm.*;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    // 신규 게시글 생성
    @PostMapping("/adm/event/save.do")
    public String savePost(final EventSearch params, Model model) {
        Long id = eventService.saveEvent(params);
        List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
        fileService.saveFiles(id, "event", files);

        // 파일 경로 가져오기
        String filePath = files.stream()
                .findFirst() // 파일이 여러 개일 경우 첫 번째 파일의 경로를 가져옴
                .map(FileRequest::getFilePath)
                .orElse(""); ///images/part/bag/backpack/backpack_01.jpg

        // File.separator를 기준으로 경로를 나누기
        String[] pathSegments = filePath.split(Pattern.quote("images" + File.separator));

        // 변수에 저장
        String[] imgPathSegments = pathSegments[1].split(Pattern.quote(File.separator));
        String imgPath = "/images/" + imgPathSegments[0];  // 수정
        String imgNm = "/" + imgPathSegments[1];      // 수정

        params.setImgPath(imgPath);
        params.setImgNm(imgNm);

        // 파일 경로 저장
        eventService.addImagePath(params);

        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/adm/event/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 작성 페이지
    @GetMapping("/adm/event/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            EventDto post = eventService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "html/adm/event/write";
    }

    // 게시글 리스트 페이지
    @GetMapping("/adm/event/list.do")
    public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
        PagingResponse<EventDto> response = eventService.findAllEvent(params);
        model.addAttribute("response", response);
        return "html/adm/event/list";
    }

    // 게시글 상세 페이지
    @GetMapping("/adm/event/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        EventDto post = eventService.findPostById(id);
        model.addAttribute("post", post);
        return "html/adm/event/view";
    }

    // 기존 게시글 수정
    @PostMapping("/adm/event/update.do")
    public String updatePost(final EventSearch params, final SearchDto queryParams, Model model) {

        // 1. 게시글 정보 수정
        eventService.updateEvent(params);

        // 2. 파일 업로드 (to disk)
        List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());

        // 3. 파일 정보 저장 (to database)
        fileService.saveFiles(params.getId(), "event", uploadFiles);

        // 4. 삭제할 파일 정보 조회 (from database)
        List<FileResponse> deleteFiles = fileService.findAllFileByIds(params.getRemoveFileIds());

        // 5. 파일 삭제 (from disk)
        fileUtils.deleteFiles(deleteFiles);

        // 6. 파일 삭제 (from database)
        fileService.deleteAllFileByIds(params.getRemoveFileIds());

        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/adm/event/list.do", RequestMethod.GET, queryParamsToMap(queryParams));
        return showMessageAndRedirect(message, model);
    }
    private Map<String, Object> queryParamsToMap(final SearchDto queryParams) {
        Map<String, Object> data = new HashMap<>();
        data.put("page", queryParams.getPage());
        data.put("recordSize", queryParams.getRecordSize());
        data.put("pageSize", queryParams.getPageSize());
        data.put("keyword", queryParams.getKeyword());
        data.put("searchType", queryParams.getSearchType());
        return data;
    }
    // 게시글 삭제
    @PostMapping("/adm/event/delete.do")
    public String deletePost(@RequestParam final Long id, final SearchDto queryParams, Model model) {
        eventService.deleteEvent(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/adm/event/list.do", RequestMethod.GET, queryParamsToMap(queryParams));
        return showMessageAndRedirect(message, model);
    }

    @RequestMapping(value = "/adm/event/admEventListAjax.do")
    @ResponseBody
    public Map<String, Object> admEventListAjax() {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, String>> jArry = new ArrayList<>();

        List<EventDto> list = eventService.admEventListAjax();

        for (EventDto event : list) {
            Map<String, String> obj = new HashMap<>();
            obj.put("imgNm", event.getImgNm());
            obj.put("imgPath", event.getImgPath());
            jArry.add(obj);
        }

        data.put("result", "success");
        data.put("data", jArry);

        return data;
    }


    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }
}
