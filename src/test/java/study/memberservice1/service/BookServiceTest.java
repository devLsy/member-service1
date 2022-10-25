package study.memberservice1.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import study.memberservice1.domain.vo.BookVO;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    @Commit
    public void 책등록() throws Exception {
        //givin
        BookVO bookVO = BookVO.createBook("영심이", 100000000, 10, "누구지?");
//        bookService.save(bookVO);
        //when

//        BookVO oneBook = bookService.findOne(2L);

        //then
//        assertThat(oneBook.getBookName()).isEqualTo("원피스");
    }

    @Test
    public void 책단건조회() throws Exception {
        //givin
//        BookVO oneBook = bookService.findOne(1L);
        //when

        //then
//        assertThat(oneBook.getBookAuthor()).isEqualTo("양극진");
    }

    @Test
    public void 책목록조회() throws Exception {
        //givin
//        List<BookDto> books = bookService.findBooksByCondition()
//        System.out.println("books = " + books.toString());
        //when
        //then
    }

    @Test
    public void 책목록_조건조회() throws Exception {
        //givin
//        BookDto bookDto = new BookDto();
//        bookDto.setBookName("영심이");
//        bookDto.setBookAuthor("누구지?");
        //when
//        List<BookDto> findBooks = bookService.findBooksByCondition(bookDto);
//        System.out.println("findBooks = " + findBooks);
        //then
//        assertThat(findBooks.get(0).getBookId()).isEqualTo(5L);
    }

    @Test
    public void 책삭제() throws Exception {
        //givin
        bookService.remove(1L);
        //when
//        List<BookVO> allBook = bookService.findAll();

        //then
//        assertThat(allBook.size()).isEqualTo(1);
    }

    @Test
    public void 책수정() throws Exception {
        //givin
//        BookVO findBook = bookService.findOne(2L);
//        when
//        findBook.updateBook("열혈강호", 19000, 50, "양극진, 전재형");
//        bookService.updateBook(findBook);
//        System.out.println("findBook = " + findBook.toString());
        //then
    }
}