package study.memberservice1.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearchDto {
    private String memberName;
    private String orderStatus;
}
