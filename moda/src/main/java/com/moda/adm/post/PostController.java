package com.moda.adm.post;

import com.moda.adm.post.service.PostService;
import com.moda.cmm.MessageDto;
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
public class PostController {
    private final PostService postService;

    // 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "id", required = false) final Long id, Model model) {
        if (id != null) {
            PostDto post = postService.findPostById(id);
            model.addAttribute("post", post);
        }
        return "html/write";
    }

    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(final PostSearch params, Model model) {
        postService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(Model model) {
        List<PostDto> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "html/list";
    }

    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        PostDto post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "html/view";
    }

    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostSearch params, Model model) {
        postService.updatePost(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id, Model model) {
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }
}