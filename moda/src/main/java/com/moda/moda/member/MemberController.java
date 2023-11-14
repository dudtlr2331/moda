package com.moda.moda.member;

import com.moda.moda.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //로그인 페이지
    @GetMapping("/moda/login.do")
    public String openLogin(){
        return "html/moda/member/login";
    }

    // 회원가입 페이지
    @PostMapping("/members")
    @ResponseBody
    public String saveMember(@RequestBody final MemberSearch params) {
        return memberService.saveMember(params);
    }

    // 회원 상세정보 조회
    @GetMapping("/members/{uId}")
    @ResponseBody
    public MemberDto findMemberById(@PathVariable final String uId) {
        return memberService.findMemberById(uId);
    }

    // 회원 정보 수정
    @PatchMapping("/members/{uId}")
    @ResponseBody
    public String updateMember(@PathVariable final String uId, @RequestBody final MemberSearch params) {
        return memberService.updateMember(params);
    }

    // 회원 정보 삭제 (회원 탈퇴)
    @DeleteMapping("/members/{uId}")
    @ResponseBody
    public String deleteMemberById(final String uId) {
        return memberService.deleteMemberById(uId);
    }

    // 회원 수 카운팅 (ID 중복 체크)
    @GetMapping("/member-check")
    @ResponseBody
    public int countMemberByLoginId(@RequestParam final String uId) {
        return memberService.chkMemberById(uId);
    }
}
