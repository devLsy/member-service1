package study.memberservice1.controller;

import study.memberservice1.domain.dto.BookDto;
import study.memberservice1.domain.dto.BookSearchDto;
import study.memberservice1.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    /**
     * 책 저장 폼
     */
    @GetMapping("/book/new")
    public String storeBook(Model model) {
        model.addAttribute("bookForm", new BookDto());
        return "book/createBookForm";
    }

    /**
     * 책 저장
     */
    @PostMapping("/book/new")
    public String storeBook(BookDto bookDto) {
        bookService.save(bookDto);
        return "redirect:/";
    }

    /**
     * 책 수정폼
     * @param bookId
     * @param model
     * @return
     */
    @GetMapping("/book/{bookId}/edit")
    public String modifyBookForm(@PathVariable Long bookId, Model model) {
        BookDto bookDto = bookService.findOne(bookId);
        model.addAttribute("bookForm", bookDto);
        return "book/updateBookForm";
    }

    /**
     * 책 수정
     * @param bookId
     * @param bookDto
     * @return
     */
    @PostMapping("/book/{bookId}/edit")
    public String modifyBook(@PathVariable Long bookId, BookDto bookDto) {
        bookService.updateBook(bookId, bookDto);
        return "redirect:/books";
    }

    /**
     * 책 목록 조회
     * @return
     */
    @GetMapping("/books")
    public String findAllBook(@ModelAttribute("bookSearch")BookSearchDto bookSearchDto, Model model) {
        List<BookDto> books = bookService.findBooksByCondition(bookSearchDto);
        model.addAttribute("books", books);
        return "book/bookList";
    }
}
