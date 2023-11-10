package com.moda.adm.event;

import com.moda.adm.event.service.EventService;
import com.moda.cmm.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        fileService.saveFiles(id, files);
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
    public String openPostList(Model model) {
        List<EventDto> posts = eventService.findAllEvent();
        model.addAttribute("posts", posts);
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
    public String updatePost(final EventSearch params, Model model) {

        // 1. 게시글 정보 수정
        eventService.updateEvent(params);

        // 2. 파일 업로드 (to disk)
        List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());

        // 3. 파일 정보 저장 (to database)
        fileService.saveFiles(params.getId(), uploadFiles);

        // 4. 삭제할 파일 정보 조회 (from database)
        List<FileResponse> deleteFiles = fileService.findAllFileByIds(params.getRemoveFileIds());

        // 5. 파일 삭제 (from disk)
        fileUtils.deleteFiles(deleteFiles);

        // 6. 파일 삭제 (from database)
        fileService.deleteAllFileByIds(params.getRemoveFileIds());

        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/adm/event/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/adm/event/delete.do")
    public String deletePost(@RequestParam final Long id, Model model) {
        eventService.deleteEvent(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/adm/event/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }
}
