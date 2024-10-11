package com.orgpgm.todopro.service;

import com.orgpgm.todopro.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO); //인터페이스 만들고(?)
    List<TodoDTO> getAll();
}
