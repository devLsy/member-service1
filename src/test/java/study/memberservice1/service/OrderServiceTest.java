package study.memberservice1.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.memberservice1.domain.vo.OrderVO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class OrderServiceTest {

    @Autowired OrderService orderService;
    
    @Test
    public void 주문() throws Exception {
        orderService.createOrder(OrderVO.createOrder(1291L), 1L, 80);
    }
}