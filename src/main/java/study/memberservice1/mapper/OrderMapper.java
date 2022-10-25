package study.memberservice1.mapper;

import study.memberservice1.domain.dto.OrderSearchDto;
import study.memberservice1.domain.enu.OrderStatus;
import study.memberservice1.domain.vo.OrderResultVO;
import study.memberservice1.domain.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 주문
     * @param orderVO
     */
    void createOrder(OrderVO orderVO);

    /**
     * 주문취소
     * @param orderId
     * @param orderStatus
     */
    void cancelOrder(@Param("orderId") Long orderId, @Param("orderStatus") OrderStatus orderStatus);

    /**
     * 주문 시 매핑 테이블에 정보 저장
     * @param orderId
     * @param bookId
     * @param orderPrice
     * @param orderCount
     */
    void storeOrderBookMapping(@Param("orderId") Long orderId,
                               @Param("bookId") Long bookId,
                               @Param("orderPrice") int orderPrice,
                               @Param("orderCount") int orderCount);

    /**
     * 주문 목록 조회
     * @return
     */
    List<OrderResultVO> findAllOrder(OrderSearchDto orderSearchDto);

    /**
     * 주문번호로 책번호 조회
     * @param orderId
     * @return
     */
    OrderResultVO findBookIdByOrderId(Long orderId);
}
