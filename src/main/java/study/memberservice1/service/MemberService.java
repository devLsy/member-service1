package study.memberservice1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.memberservice1.domain.dto.MemberDto;
import study.memberservice1.domain.dto.MemberSearchDto;
import study.memberservice1.domain.vo.MemberVO;
import study.memberservice1.mapper.MemberMapper;

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
     * 조건으로 목록 조회
     * @param memberSearchDto
     * @return
     */
    public List<MemberDto> findMembersByCondition(MemberSearchDto memberSearchDto) {
        List<MemberVO> findMembers = memberMapper.findMembersByCondition(memberSearchDto);
        List<MemberDto> result = findMembers.stream()
                .map(m -> toDto(m)).collect(toList());
        return result;
    }

    /**
     * 목록 조회
     * @return
     */
    public List<MemberDto> findAll() {
        List<MemberVO> members = memberMapper.findAllMember();
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
