package com.moda.moda.member;

import com.moda.cmm.MessageDto;
import com.moda.moda.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    MemberService memberService;

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/moda/join.do")
    public String joinForm(){
        return "html/moda/member/join";
    }

    /**
     * 회원가입 진행
     * @param memberVO
     * @return
     */
    @PostMapping("/moda/join")
    public String join(@ModelAttribute MemberVO memberVO, Model model){
        int idChk = memberService.checkDuplicate(memberVO.getUId());

        if(idChk != 0){
            MessageDto message = new MessageDto("회원가입 실패", "/moda/join.do", RequestMethod.GET, null);
            return showMessageAndRedirect(message, model);
        }else{
            memberService.joinMember(memberVO);
            MessageDto message = new MessageDto("회원가입 성공", "/moda/login.do", RequestMethod.GET, null);
            return showMessageAndRedirect(message, model);
        }
    }

    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/moda/login.do")
    public String loginForm(){
        return "html/moda/member/login";
    }


    /**
     * 로그인 진행
     * @param memberVO
     * @return
     */
    @PostMapping("/moda/login")
    public String login(@ModelAttribute MemberVO memberVO, Model model, HttpSession session){
        int loginChk = memberService.loginMember(memberVO);

        if(loginChk > 0){
            MemberVO loginInfo = memberService.findByMember(memberVO.getUId());
            session.setAttribute("uId", loginInfo.getUId());
            session.setAttribute("uAdmin", loginInfo.getUAdmin());
            return "redirect:/main";
        }else{
            MessageDto message = new MessageDto("아이디 또는 비밀번호가 틀렸습니다.", "/moda/login.do", RequestMethod.GET, null);
            return showMessageAndRedirect(message, model);
        }
    }

    /**
     * 로그아웃
     * @return
     */
    @GetMapping("/moda/logout")
    public String userLogout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();

        return "redirect:/main";
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }
}