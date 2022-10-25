package study.memberservice1.service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import study.memberservice1.domain.dto.MemberDto;
import study.memberservice1.domain.dto.MemberSearchDto;
import study.memberservice1.domain.vo.MemberVO;
import study.memberservice1.mapper.MemberMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberMapper memberMapper;

    @Test
    @Commit
    public void 회원등록() throws Exception {
        //givin
//        MemberVO member = MemberVO.createMember("delTest@naver.com", "delTest", "4444");
//        memberService.save(member);
        //when
//        MemberVO one = memberService.findOne(11L);
        //then
        for (int i = 0; i < 50; i++) {
            MemberVO member = MemberVO.createMember(i + "@naver.com", i + "name", i + "ejda123@");
            memberService.save(member);
        }
    }

    @Test
    public void 회원단건조회() throws Exception {
        //givin
//        MemberVO member = memberService.findOne(24L);
//        when

//        then
//        assertThat(member.getMemberName()).isEqualTo("odin");
    }

    @Test
    public void 회원목록조회() throws Exception {
        //givin
        List<MemberDto> result = memberService.findAll();
        //when

        //then
        System.out.println("result = " + result.toString());
    }

    @Test
    public void 회원삭제() throws Exception {
        //givin
        memberService.remove(26L);
        //when

        //then
//        assertThat(memberService.findOne(11L).getMemberId()).isEqualTo(11L);
    }

    @Test
    public void 회원수정() throws Exception {
        //givin
//        MemberVO findMember = memberService.findOne(12L);
//        findMember.updatemember("update_ironMan@naver.com", "update_ironMan", "4321");
//        when
//        memberService.updateMember(findMember);
//        System.out.println("findMember = " + findMember.toString());
        //then
    }

    @Test
    public void 회원조건검색() throws Exception {
        //givin
//        MemberDto memberDto = new MemberDto();
//        memberDto.setMemberName("ironMan");
//        memberDto.setEmail("ironMan@naver.com");
        //when
        MemberSearchDto memberSearchDto = new MemberSearchDto();
        List<MemberDto> findMember = memberService.findMembersByCondition(memberSearchDto);
        System.out.println("findMember = " + findMember.toString());
        //then
        assertThat(findMember.get(0).getMemberId()).isEqualTo(21L);
    }
}
