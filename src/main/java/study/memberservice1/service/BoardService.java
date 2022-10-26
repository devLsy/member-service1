package study.memberservice1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.memberservice1.domain.vo.BoardVO;
import study.memberservice1.mapper.BoardMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardMapper boardMapper;

    /**
     * insert board
     * @param boardVO
     */
    public void createBoard(BoardVO boardVO) {
        boardMapper.insertBoard(boardVO);
    }

    /**
     * select list board
     * @return
     */
    public List<BoardVO> findBoardList() {
        return boardMapper.findBoardList();
    }

    /**
     * board count
     * @param boardId
     * @return
     */
    public Long findBoardCount(Long boardId) {
        return boardMapper.findBoardCount(boardId);
    }

    /**
     * board detail
     * @param boardId
     * @return
     */
    public BoardVO findBoardDetail(Long boardId) {
        return boardMapper.findBoardDetail(boardId);
    }

    /**
     * update board
     * @param boardId
     * @param boardVO
     */
    public void updateBoard(Long boardId, BoardVO boardVO) {
        boardMapper.updateBoard(boardId, boardVO);
    }

    /**
     * delete board
     * @param boardId
     */
    public void deleteBoard(Long boardId) {
        boardMapper.deleteBoard(boardId);
    }
}
