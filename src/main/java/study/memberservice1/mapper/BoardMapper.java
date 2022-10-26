package study.memberservice1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import study.memberservice1.domain.vo.BoardVO;

import java.util.List;

@Mapper
public interface BoardMapper {

    // board list
    List<BoardVO> findBoardList();

    /// board count
    Long findBoardCount(Long boardId);

    // board detail
    BoardVO findBoardDetail(Long boardId);

    // board insert
    void insertBoard(BoardVO boardVO);

    // board update
    void updateBoard(@Param("boardId") Long boardId, @Param("boardVO") BoardVO boardVO);

    // board delete
    void deleteBoard(Long boardId);

}
