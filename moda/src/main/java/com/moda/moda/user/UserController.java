package com.moda.moda.user;

import com.moda.moda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "html/moda/user/login";
    }

    @PostMapping("/user/login")
    public String login(Model model, HttpServletRequest req, HttpServletResponse res, @ModelAttribute UserVO pvo){
        HttpSession session = req.getSession();
        String returnPage = "";

        UserVO sessionVO = userService.userLogin(pvo);

        if (null == sessionVO) {
            session.setAttribute("message", "아이디 / 비밀번호를 입력해 주세요.");
//            model.addAttribute("message", "아이디/비밀번호를 입력해 주세요."); // redirect로 요청해서 model로 값을 넘길 수 없다.
            returnPage = "redirect:/login";
        } else if (pvo.getUserId().equals(sessionVO.getUserId()) && pvo.getUserPass().equals(sessionVO.getUserPass())) {
            session.setAttribute("loginInfo", sessionVO);
            returnPage = "redirect:/main";
        } else {
            session.setAttribute("message", "아이디 / 비밀번호를 확인해 주세요.");
            returnPage = "redirect:/login";
        }

        System.out.println("loginInfo : " + session.getAttribute("loginInfo"));
        System.out.println("returnPage : "+ returnPage + " , sessionVO : " + sessionVO);

        return returnPage;
    }

    // 로그아웃
    @GetMapping("/user/userLogout")
    public String userLogout(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        session.invalidate();

        return "redirect:/main";
    }

    @GetMapping("/join")
    public String join() { return "html/moda/user/join"; }

    @GetMapping("/edit")
    public String edit() {
        return "html/moda/user/edit";
    }

    @GetMapping("/user/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/user/save")
    public String save(HttpServletRequest req, HttpServletResponse res, @ModelAttribute UserVO pvo, Model model){
        System.out.println("가입정보 = " + pvo);
        userService.insertUser(pvo);
        model.addAttribute("message", "회원가입을 환영합니다!");

        return "html/moda/main/main";
    }

    @GetMapping("/users")
    public String selectUserList(Model model, UserVO pvo) {
        List<UserVO> userList = userService.selectUserList(pvo); // UserService를 통해 selectUserList 메서드 호출
        model.addAttribute("userList", userList); // "userList"라는 이름으로 모델에 데이터 추가

        return "html/moda/user/list";
    }
}
