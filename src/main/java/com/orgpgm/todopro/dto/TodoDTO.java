package com.orgpgm.todopro.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDTO {
    //MySQL springdb에서 만든 tbl_todo와 통일시켜 변수 생성(vo/TodoVo랑 똑같이 써야 함)
    private Long tno;
    @NotEmpty
    private String title;
    @Future //미래 날짜로만 설정 가능.
    private LocalDate dueDate;
    @NotEmpty
    private String writer;
    private boolean finished;
}
