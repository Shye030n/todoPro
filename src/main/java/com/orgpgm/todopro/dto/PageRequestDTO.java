package com.orgpgm.todopro.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data //getter, setter, toString() 메서드 자동 생성
@AllArgsConstructor //parameter 있는 생성자 자동 생성
@NoArgsConstructor // default 생성자 자동 생성
public class PageRequestDTO {
    //! paging 처리 !
    // => 한 페이지당 보여줄 항목의 개수(size)와
    //      현재 페이지 번호(page)를 나타내기 위해 사용한 클래스

    @Builder.Default
    @Min(value=1)
    @Positive
    private int page=1; //클라이언트의 화면에서 현재 페이지 (몇 쪽)

    @Builder.Default
    @Min(value=10)
    @Max(value=100)
    @Positive
    private int size=10; //한 페이지 당 보여줄 항목 개수

    public int getSkip(){
        // 페이지 넘기기 계산
        return(page-1)*10;
        // 1페이지: 데이터의 시작점은 0 (항목 1부터 시작)
        // 2페이지: 데이터의 시작점은 10 (항목 11부터 시작)
        // 3페이지: 데이터의 시작점은 20 (항목 21부터 시작)
    }
}
