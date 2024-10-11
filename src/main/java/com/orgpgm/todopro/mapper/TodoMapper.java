package com.orgpgm.todopro.mapper;

import com.orgpgm.todopro.dto.TodoDTO;
import com.orgpgm.todopro.vo.TodoVo;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVo todoVo);//추상메서드 삽입
    List<TodoVo>getList();
}
