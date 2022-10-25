package study.memberservice1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.memberservice1.domain.dto.MemberDto;
import study.memberservice1.domain.dto.MemberSearchDto;
import study.memberservice1.domain.dto.SearchDto;
import study.memberservice1.domain.vo.MemberVO;
import study.memberservice1.mapper.MemberMapper;
import study.memberservice1.paging.Pagination;
import study.memberservice1.paging.PaginationResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static study.memberservice1.domain.dto.MemberDto.toDto;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberMapper memberMapper;

    /**
     * 등록
     * @param memberDto
     */
    @Transactional
    public void save(MemberDto memberDto) {
        MemberVO memberVO = MemberVO.toVO(memberDto);
        memberMapper.insertMember(memberVO);
    }

    /**
     * 등록 
     * @param memberVO
     */
    public void save(MemberVO memberVO) {
        memberMapper.insertMember(memberVO);
    }

    /**
     * 아이디로 단건 조회
     * @param memberId
     * @return
     */
    public MemberDto findOne(Long memberId) {
        MemberVO findOne = memberMapper.findOneMemberByMemberId(memberId);
        return MemberDto.toDto(findOne);
    }

    /**
     * 목록 조회(페이징)
     * @param searchDto
     * @return
     */
    public PaginationResponse<MemberVO> findMembersByCondition(SearchDto searchDto) {
        int count = memberMapper.findAllMemberCount(searchDto);
        // 페이지네이션 계산
        Pagination pagination = new Pagination(count, searchDto);
        searchDto.setPagination(pagination);
        List<MemberVO> members = memberMapper.findMembersByCondition(searchDto);
        return new PaginationResponse<>(members, pagination);
    }

    /**
     * 목록 조회(페이징X)
     * @return
     */
    public List<MemberDto> findAll() {
        List<MemberVO> members = memberMapper.findAllNoPaging();
        List<MemberDto> result = members.stream()
                .map(m -> toDto(m)).collect(toList());
        return result;
    }

    /**
     * 수정
     * @param memberId
     * @param memberDto
     */
    @Transactional
    public void updateMember(Long memberId, MemberDto memberDto) {
        MemberVO findMember = memberMapper.findOneMemberByMemberId(memberId);
        findMember.updatemember(memberDto.getEmail(), memberDto.getMemberName(), memberDto.getPassword());
        memberMapper.updateMember(findMember);
    }

    /**
     * 삭제
     * @param memberId
     */
    @Transactional
    public void remove(Long memberId) {
        memberMapper.deleteMember(memberId);
    }
}
