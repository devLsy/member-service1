package study.memberservice1.domain.dto;

import lombok.Data;

@Data
public class MemberSearchDto {
    private String memberName;
    private String email;
    private int page;           // 현재 페이지 번호
    private int recordSize;     // 페이지당 출력할 데이터 개수
    private int pageSize;       // 화면 하단에 출력할 페이지 사이즈(5면 1~5까지, 10이면 1~10까지 하단에 표시)
    private String keyWord;     // 검색 키워드  (이건 당장 필요하진 않지만 우선 만들어 둠)
    private String searchType;  // 검색 유형   (이건 당장 필요하진 않지만 우선 만들어 둠)

    public MemberSearchDto() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

    public int getOffset() {
        return (page - 1) * recordSize;
    }
}
