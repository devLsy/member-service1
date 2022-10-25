package study.memberservice1.service;

import study.memberservice1.domain.dto.OrderSearchDto;
import study.memberservice1.domain.enu.OrderStatus;
import study.memberservice1.domain.vo.BookVO;
import study.memberservice1.domain.vo.OrderResultVO;
import study.memberservice1.domain.vo.OrderVO;
import study.memberservice1.mapper.BookMapper;
import study.memberservice1.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class OrderService {

    private final OrderMapper orderMapper;
    private final BookMapper bookMapper;


    /**
     * 주문
     * @param orderVO
     * @param bookId
     * @param orderCount
     */
    @Transactional
    public void createOrder(OrderVO orderVO, Long bookId, int orderCount) {
        BookVO findBook = bookMapper.findOneBook(bookId);
        findBook.removeStock(orderCount);
        // 주문
        orderMapper.createOrder(orderVO);
        // 책 재고 수정
        bookMapper.updateBookStockQuantity(bookId, findBook.getBookStockQuantity());
        // 자동채번 orderId 세팅
        Long orderId = orderVO.getOrderId();
        // order_book_mapping 테이블 데이터 저장
        orderMapper.storeOrderBookMapping(orderId, findBook.getBookId(), findBook.getBookPrice() * orderCount, orderCount);
    }

    /**
     * 주문 취소
     * @param orderId
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        OrderResultVO findVO = orderMapper.findBookIdByOrderId(orderId);
        BookVO findBook = bookMapper.findOneBook(findVO.getBookId());
        // 책 재고 원복
        findBook.addStock(findVO.getOrderCount());
        orderMapper.cancelOrder(orderId, OrderStatus.CANCEL);
        bookMapper.updateBookStockQuantity(findBook.getBookId(), findBook.getBookStockQuantity());
    }

    /**
     * 주문 목록 조회
     * @return
     */
    public List<OrderResultVO> findAllOrder(OrderSearchDto orderSearchDto) {
        return orderMapper.findAllOrder(orderSearchDto);
    }
}
