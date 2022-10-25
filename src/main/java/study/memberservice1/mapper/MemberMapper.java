package study.memberservice1.mapper;

import study.memberservice1.domain.dto.MemberSearchDto;
import study.memberservice1.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import study.memberservice1.paging.PageInfo;

import java.util.List;

@Mapper
public interface MemberMapper {
    /**
     * 등록 
     * @param memberVO
     */
    void insertMember(MemberVO memberVO);

    /**
     * 아이디로 단건 조회
     * @return
     */
    MemberVO findOneMemberByMemberId(Long memberId);

    /**
     * 조건으로 목록 조회
     * @return
     */
    List<MemberVO> findMembersByCondition(MemberSearchDto memberSearchDto);

    /**
     * 목록 조회
     * @return
     */
    List<MemberVO> findAllMember(MemberSearchDto memberSearchDto);

    /**
     * 전체 카운트
     * @return
     */
    int findAllMemberCount(MemberSearchDto memberSearchDto);
    /**
     * 수정
     */
    void updateMember(MemberVO memberVO);

    /**
     * 삭제
     * @param memberId
     */
    void deleteMember(Long memberId);
}
