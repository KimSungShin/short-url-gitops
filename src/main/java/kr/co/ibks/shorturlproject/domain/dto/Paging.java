package kr.co.ibks.shorturlproject.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Data
public class Paging {
    private final int totalCount;
    private final boolean hasNext;
    private final boolean hasPrev;
    private final int pageNo;
    private final int pageSize;

    public Paging(Page page) {
        this.totalCount = (int) page.getTotalElements();
        this.hasNext = page.hasNext();
        this.hasPrev = page.hasPrevious();
        this.pageNo = page.getNumber() + 1;
        this.pageSize = page.getSize();
    }
}
