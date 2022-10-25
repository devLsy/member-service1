package study.memberservice1.domain.dto;

import study.memberservice1.domain.vo.MemberVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class MemberDto {
    private Long memberId;
    private String email;
    private String memberName;
    private String password;

    /**
     * vo를 dto로 변환
     * @param memberVO
     * @return
     */
    public static MemberDto toDto(MemberVO memberVO) {
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(memberVO.getMemberId());
        memberDto.setEmail(memberVO.getEmail());
        memberDto.setMemberName(memberVO.getMemberName());
        memberDto.setPassword(memberVO.getPassword());
        return memberDto;
    }
}
