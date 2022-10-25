package study.memberservice1.domain.vo;

import study.memberservice1.domain.dto.MemberDto;
import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberVO {

    private Long memberId;
    private String email;
    private String memberName;
    private String password;

    /**
     * dto를 vo로 변환
     * @param memberDto
     * @return
     */
    public static MemberVO toVO(MemberDto memberDto) {
        MemberVO memberVO = new MemberVO();
        memberVO.setEmail(memberDto.getEmail());
        memberVO.setMemberName(memberDto.getMemberName());
        memberVO.setPassword(memberDto.getPassword());
        return memberVO;
    }

    /**
     * 객체 생성 메서드
     * @param email
     * @param memberName
     * @param password
     * @return
     */
    public static MemberVO createMember(String email, String memberName, String password) {
        MemberVO memberVO = new MemberVO();
        memberVO.setEmail(email);
        memberVO.setMemberName(memberName);
        memberVO.setPassword(password);
        return memberVO;
    }

    /**
     * 수정 메서드
     * @param email
     * @param memberName
     * @param password
     */
    public void updatemember(String email, String memberName, String password) {
        this.email = email;
        this.memberName = memberName;
        this.password = password;
    }
}
