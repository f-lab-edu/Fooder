package com.ryumina.fooder.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(builderMethodName = "innerBuilder")
@ToString
public class Paging<T> {

    private long totalCount;
    private long totalPage;
    private int pageIndex;
    private int rowsPerPage;
    private T list;

    public static <T> PagingBuilder<T> builder(long totalCount, int pageIndex, int rowsPerPage, T list) {
        PagingBuilder<T> innerBuilder = innerBuilder();

        return innerBuilder.totalPage((long) Math.ceil(totalCount / (double) rowsPerPage))
                           .pageIndex(pageIndex)
                           .totalCount(totalCount)
                           .rowsPerPage(rowsPerPage)
                           .list(list);
    }
}
