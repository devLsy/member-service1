package study.memberservice1.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.memberservice1.domain.vo.BoardVO;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
class BoardServiceTest {
    @Autowired BoardService boardService;

    @Test
    @Commit
    public void createBoard() {
//        BoardVO board = BoardVO.createBoard("테스트1", "테스트_내용1", "닥스");
//        boardService.createBoard(board);
//        List<BoardVO> boardList = boardService.findBoardList();
//        assertThat(boardList.size()).isEqualTo(1);
        for (int i = 0; i < 100; i++) {
            BoardVO boardVO = BoardVO.createBoard(i + "테스트", i + "테스트_내용", i + "writer");
            boardService.createBoard(boardVO);
        }
    }

    @Test
    @DisplayName("find board List")
    public void findBoardList() {
        //given
        List<BoardVO> boardList = boardService.findBoardList();
        // when
        int size = boardList.size();
        //then
        assertThat(size).isEqualTo(1);
    }
    
    @Test
    @DisplayName("update board")
    @Commit
    public void updateBoard() {
        //given
        BoardVO boardVO = boardService.findBoardDetail(4L);
        // when
        boardVO.updateBoard("수정_제목", "수정_내용", "수정_이름");
        boardService.updateBoard(boardVO.getBoardId(), boardVO);
        //then
    }

    @Test
    @Commit
    @DisplayName("board delete")
    public void boardDel() {
        //given
        boardService.deleteBoard(4L);
        // when

        //then
    }





}