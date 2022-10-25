package study.memberservice1.controller;

import study.memberservice1.domain.dto.MemberDto;
import study.memberservice1.domain.dto.MemberSearchDto;
import study.memberservice1.domain.dto.SearchDto;
import study.memberservice1.domain.vo.MemberVO;
import study.memberservice1.paging.PaginationResponse;
import study.memberservice1.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입 폼
     *
     * @param model
     * @return
     */
    @GetMapping("/member/new")
    public String memberForm(Model model) {
        model.addAttribute("memberForm", new MemberDto());
        return "member/createMemberForm";
    }

    /**
     * 회원가입
     *
     * @param memberDto
     * @return
     */
    @PostMapping("member/new")
    public String join(MemberDto memberDto) {
        memberService.save(memberDto);
        return "redirect:/";
    }

    /**
     * 회원 목록
     * @param model
     * @return
     */
    @GetMapping("/members")
    public String findAllMembers(@ModelAttribute("searchDt") final SearchDto searchDto, Model model) {
        PaginationResponse<MemberVO> response = memberService.findMembersByCondition(searchDto);
        model.addAttribute("response", response);
        return "/member/memberList";
    }

    /**
     * 회원수정 폼
     * @param memberId
     * @param model
     * @return
     */
    @GetMapping("/member/{memberId}/edit")
    public String modifyMemberForm(@PathVariable Long memberId, Model model) {
        MemberDto member = memberService.findOne(memberId);
        model.addAttribute("memberForm", member);
        return "member/updateMemberForm";
    }

    /**
     * 회원수정
     * @return
     */
    @PostMapping("/member/{memberId}/edit")
    public String modifyMember(@PathVariable Long memberId, MemberDto memberDto) {
        memberService.updateMember(memberId, memberDto);
        return "redirect:/members";
    }

    /**
     * 회원삭제
     * @param memberId
     * @return
     */
    @DeleteMapping("/member/{memberId}/del")
    public String removeMember(@PathVariable Long memberId) {
        memberService.remove(memberId);
        return "redirect:/";
    }
}
