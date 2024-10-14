package com.orgpgm.todopro.mapper;

import com.orgpgm.todopro.vo.TodoVO;


import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO); //추상메서드 삽입
    List<TodoVO> getList();
    TodoVO selectOne(int tno);
    void delete(int dto);
    void update(TodoVO todoVo); // TodoMapper 인터페이스에 정의

}