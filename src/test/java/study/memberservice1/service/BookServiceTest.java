package study.memberservice1.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.memberservice1.domain.dto.BookDto;
import study.memberservice1.mapper.BookMapper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BookServiceTest {

    @Autowired BookService bookService;
    @Autowired BookMapper bookMapper;

    @Test
    public void 책등록() throws Exception {
        BookDto bookDto = new BookDto();
        bookDto.setBookAuthor("김상민");
        bookDto.setBookPrice(190000);
        bookDto.setBookName("여전히 아름다운지");
        bookDto.setBookStockQuantity(90);
        bookService.save(bookDto);
    }

}