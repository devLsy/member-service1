package study.memberservice1.domain.vo;

import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderBookMappingVO {
    private Long orderBookId;
    private String orderId;
}
