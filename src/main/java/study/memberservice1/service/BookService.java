package study.memberservice1.service;

import study.memberservice1.domain.dto.BookDto;
import study.memberservice1.domain.dto.BookSearchDto;
import study.memberservice1.domain.vo.BookVO;
import study.memberservice1.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static study.memberservice1.domain.dto.BookDto.toDto;
import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {
    private final BookMapper bookMapper;

    /**
     * 등록
     * @param bookDto
     */
    @Transactional
    public void save(BookDto bookDto) {
        BookVO bookVO = BookVO.toVo(bookDto);
        bookMapper.insertBook(bookVO);
    }

    /**
     * 단건 조회
     * @param bookId
     * @return
     */
    public BookDto findOne(Long bookId) {
        BookVO findBook = bookMapper.findOneBook(bookId);
        return toDto(findBook);
    }

    /**
     * 목록 조회
     * @return
     */
    public List<BookDto> findAll() {
        List<BookVO> books = bookMapper.findAllBook();
        List<BookDto> result = books.stream()
                .map(b -> toDto(b)).collect(toList());
        return result;
    }

    /**
     * 책 목록 조건 조회
     * @param bookSearchDto
     * @return
     */
    public List<BookDto> findBooksByCondition(BookSearchDto bookSearchDto) {
        List<BookVO> findBooks = bookMapper.findBooksByCondition(bookSearchDto);
        List<BookDto> result = findBooks.stream()
                .map(b -> toDto(b)).collect(toList());
        return result;
    }

    /**
     * 책 수정
     * @param bookId
     * @param bookDto
     */
    @Transactional
    public void updateBook(Long bookId, BookDto bookDto) {
        BookVO findBook = bookMapper.findOneBook(bookId);
        findBook.updateBook(bookDto.getBookName(), bookDto.getBookPrice(), bookDto.getBookStockQuantity(), bookDto.getBookAuthor());
        bookMapper.updateBook(findBook);
    }

    /**
     * 책 재고 수정(주문/취소 시)
     * @param bookStockQuantity
     */
    @Transactional
    public void updateBookStockQuantity(Long bookId, int bookStockQuantity) {
        bookMapper.updateBookStockQuantity(bookId, bookStockQuantity);
    }

    /**
     * 삭제
     * @param
     */
    @Transactional
    public void remove(Long bookId) {
        bookMapper.deleteBook(bookId);
    }
}
