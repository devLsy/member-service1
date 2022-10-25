package study.memberservice1.domain.dto;

import study.memberservice1.domain.enu.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class OrderDto {
    private Long orderId;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
}
