package com.orgpgm.todopro.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
/* VO(ValueObject)란? (폴더명 및 파일명)
- DB에서 가져온 데이터나 사용자 입력을 표현하는 객체
- Address(주소), Date(날짜), Point(좌표) 등 특정한 의미를 가진 데이터 구조.
- 일반적으로 불변 객체(ImmutableObject 생성 후 변경 X)로 설계됨
    -> 데이터 안전 유지, 여러 스레드 동시접근 문제 예방
- 주로 Property(속성)dmfh rntjdehlau, getter만 가지고 있는 경우가 많다
- 데이터 모델링에서 중요한 역할, 도메인 모델을 구성하는데 사용
- 비즈니스 의미를 가진 불변 객체로, 데이터를 안전하게 표현하고 관리.
    -> 코드의 가독성을 높이고 데이터 무결성 유지 */

@Getter
@ToString
@AllArgsConstructor //모든 필드에 매게변수로 받는 생성자를 자동으로 생성
                    // 클래스 내 존재하는 모든 필드에 값 전달 -> 객체 생성
@NoArgsConstructor //아무 인자도 받지 않는 기본 생성자를 자동으로 생성
                    // 매개변수 없이 객체 생성
public class TodoVO {
    //MySQL springdb에서 만든 tbl_todo와 통일시켜 변수 생성 (dto/TodoDTO에서 복붙)
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private String writer;
    private boolean finished;
}
