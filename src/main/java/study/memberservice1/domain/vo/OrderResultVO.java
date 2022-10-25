package study.memberservice1.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class OrderResultVO {

    private Long memberId;
    private String email;
    private String memberName;
    private String password;

    private long bookId;
    private String bookAuthor;
    private String bookName;
    private int bookPrice;
    private int bookStockQuantity;

    private Long orderId;
    private String orderDate;
    private String  orderStatus;
    private int orderPrice;
    private int orderCount;
}
