package study.memberservice1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import study.memberservice1.domain.dto.OrderSearchDto;
import study.memberservice1.domain.vo.OrderResultVO;
import study.memberservice1.domain.vo.OrderVO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @Test
    @Commit
    public void 주문() throws Exception {
        //givin
        OrderVO orderVO = OrderVO.createOrder(23L);
        orderService.createOrder(orderVO, 2L, 5);

        //when

        //then
    }

    @Test
    public void 주문목록조회() throws Exception {
        OrderSearchDto orderSearchDto = new OrderSearchDto();
        orderSearchDto.setMemberName("ironMan");
        orderSearchDto.setOrderStatus("CANCEL");
        List<OrderResultVO> result = orderService.findAllOrder(orderSearchDto);
        System.out.println("result = " + result.toString());
//        Assertions.assertThat(allOrder.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("주문취소")
    public void 주문취소() throws Exception {
        //givin
//        orderService.cancelOrder(26L, 2L, 5);
        //when

        //then
    }
}