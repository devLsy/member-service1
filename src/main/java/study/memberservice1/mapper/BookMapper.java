package study.memberservice1.mapper;

import study.memberservice1.domain.dto.BookSearchDto;
import study.memberservice1.domain.vo.BookVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    /**
     * 등록
     * @param bookVO
     */
    void insertBook(BookVO bookVO);

    /**
     * 단건조회
     * @param bookId
     * @return
     */
    BookVO findOneBook(Long bookId);

    /**
     * 목록 조회
     * @return
     */
    List<BookVO> findAllBook();

    /**
     * 책 목록 조건 조회 
     * @param bookSearchDto
     * @return
     */
    List<BookVO> findBooksByCondition(BookSearchDto bookSearchDto);

    /**
     * 책 수정 
     * @param bookVO
     */
    void updateBook(BookVO bookVO);


    /**
     * 책 재고 수정
     * @param bookId
     * @param bookStockQuantity
     */
    void updateBookStockQuantity(@Param("bookId") Long bookId , @Param("bookStockQuantity") int bookStockQuantity);

    /**
     * 삭제
     * @param bookId
     */
    void deleteBook(Long bookId);
}
