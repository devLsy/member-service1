package study.memberservice1.paging;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationResponse<T> {

    private List<T> list = new ArrayList<>();
    private Pagination pagination;

    public PaginationResponse(List<T> list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }
}
