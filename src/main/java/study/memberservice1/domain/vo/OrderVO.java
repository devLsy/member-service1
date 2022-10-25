package study.memberservice1.domain.vo;

import study.memberservice1.domain.enu.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderVO {
    private Long orderId;
    private Long memberId;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;

    /**
     * 주문 생성
     * @param memberId
     * @return
     */
    public static OrderVO createOrder(Long memberId) {
        OrderVO orderVO = new OrderVO();
        orderVO.setMemberId(memberId);
        orderVO.setOrderStatus(OrderStatus.ORDER);
        return orderVO;
    }

}
