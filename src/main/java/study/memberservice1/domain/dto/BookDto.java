package study.memberservice1.domain.dto;

import study.memberservice1.domain.vo.BookVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BookDto {
    private Long bookId;
    private String bookName;
    private int bookPrice;
    private int bookStockQuantity;
    private String bookAuthor;


    /**
     * vo를 dto로 변환
     * @param bookVO
     * @return
     */
    public static BookDto toDto(BookVO bookVO) {
        BookDto bookDto = new BookDto();
        bookDto.setBookId(bookVO.getBookId());
        bookDto.setBookName(bookVO.getBookName());
        bookDto.setBookPrice(bookVO.getBookPrice());
        bookDto.setBookStockQuantity(bookVO.getBookStockQuantity());
        bookDto.setBookAuthor(bookVO.getBookAuthor());
        return bookDto;
    }


}
