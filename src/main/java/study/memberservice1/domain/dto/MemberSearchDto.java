package study.memberservice1.domain.dto;

import lombok.Data;

@Data
public class MemberSearchDto {
    private String memberName;
    private String email;
}
