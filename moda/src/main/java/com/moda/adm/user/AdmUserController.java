package com.moda.adm.user;

import com.moda.adm.search.SearchDto;
import com.moda.adm.user.service.AdmUserService;
import com.moda.cmm.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdmUserController {
    private final AdmUserService admUserService;


    @GetMapping("/adm/userList")
    public String openUserList(@ModelAttribute("params") final SearchDto params, Model model) {
        List<AdmUserDto> users = admUserService.findAllUser(params);
        model.addAttribute("users", users);
        return "html/adm/user/userlist";
    }
    // 유저 상세 페이지
    @GetMapping("/adm/userView")
    public String openUserView(@RequestParam final String id, Model model) {
        AdmUserSearch user = admUserService.findUserById(id);
        model.addAttribute("user", user);
        return "html/adm/user/userview";
    }

    // 기존 게시글 수정
    @PostMapping("/adm/userUpdate")
    public String updateUser(final AdmUserSearch params, Model model) {
        admUserService.updateUser(params);
        MessageDto message = new MessageDto("유저정보 수정이 완료되었습니다.", "/adm/userList", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 게시글 삭제
    @PostMapping("/adm/userDelete")
    public String deleteUser(@RequestParam final String id, Model model) {
        admUserService.deleteUser(id);
        MessageDto message = new MessageDto("유저정보 삭제가 완료되었습니다.", "/adm/userList", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }

    @GetMapping("/adm/userWrite")
    public String openUserWrite(@RequestParam(value = "id", required = false) final String id, Model model) {
        if (id != null) {
            AdmUserSearch user = admUserService.findUserById(id);
            model.addAttribute("user", user);
        }
        return "html/adm/user/userwrite";
    }
}