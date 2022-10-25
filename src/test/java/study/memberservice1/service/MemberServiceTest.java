package study.memberservice1.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.memberservice1.domain.vo.MemberVO;
import study.memberservice1.mapper.MemberMapper;

@SpringBootTest
@Slf4j
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberMapper memberMapper;
    
    @Test
    public void 회원등록() throws Exception {

        for (int i = 0; i < 100; i++) {
            memberService.save(MemberVO.createMember(i + "@naver.com", i + "terran", i + "@djknc@0QDn"));
        }
    }
}
