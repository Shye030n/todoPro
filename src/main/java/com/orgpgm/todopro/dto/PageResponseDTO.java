package com.orgpgm.todopro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page; // 현재 페이지
    private int size; // 한 페이지당 보여줄 데이터 개수
    private int total; // 전체 데이터 개수
    private int start; // 시작 페이지 번호
    private int end; // 끝 페이지 번호
    private boolean prev; //이전 페이지의 존재 여부
    private boolean next; // 다음 페이지의 존재 여부
    private List<E> dtoList; // 현재 페이지에서 보여줄 데이터 리스트

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList= dtoList;

        this.end = (int)(Math.ceil((double) this.page/this.size)) * this.size;
        // (1 나누기 10) 곱하기 10 = 마지막페이지
        this.start = this.end - (this.size - 1);
        // 첫 페이지 = 마지막 페이지 - (
        int last = (int)(Math.ceil((double) total / this.size));
        this.end = end > last? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
