package study.memberservice1.domain.vo;

import lombok.*;
import study.memberservice1.domain.dto.BookDto;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookVO {
    private Long bookId;
    private String bookName;
    private int bookPrice;
    private int bookStockQuantity;
    private String bookAuthor;

    /**
     * dto를 vo로 변환
     * @param bookDto
     * @return
     */
    public static BookVO toVo(BookDto bookDto) {
        BookVO bookVO = new BookVO();
        bookVO.setBookName(bookDto.getBookName());
        bookVO.setBookPrice(bookDto.getBookPrice());
        bookVO.setBookStockQuantity(bookDto.getBookStockQuantity());
        bookVO.setBookAuthor(bookDto.getBookAuthor());
        return bookVO;
    }

    /**
     * 객체 생성 메서드
     * @param bookName
     * @param bookPrice
     * @param bookStockQuantity
     * @param bookAuthor
     * @return
     */
    public static BookVO createBook(String bookName, int bookPrice, int bookStockQuantity, String bookAuthor) {
        BookVO bookVO = new BookVO();
        bookVO.setBookName(bookName);
        bookVO.setBookPrice(bookPrice);
        bookVO.setBookStockQuantity(bookStockQuantity);
        bookVO.setBookAuthor(bookAuthor);
        return bookVO;
    }

    /**
     * 수정 메서드
     * @param bookName
     * @param bookPrice
     * @param bookStockQuantity
     * @param bookAuthor
     */
    public void updateBook(String bookName, int bookPrice, int bookStockQuantity, String bookAuthor) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookStockQuantity = bookStockQuantity;
        this.bookAuthor = bookAuthor;
    }

    /**
     * 재고수량 감소(주문 시)
     * @param quantity
     */
    public void removeStock(int quantity) {
        int lastStock = this.bookStockQuantity - quantity;
        if (lastStock < 0) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
        this.bookStockQuantity = lastStock;
    }

    /**
     * 재고수량 증가(주문 취소 시)
     * @param quantity
     */
    public void addStock(int quantity) {
        this.bookStockQuantity += quantity;
    }
}
