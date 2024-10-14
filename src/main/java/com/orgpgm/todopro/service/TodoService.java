package com.orgpgm.todopro.service;

import com.orgpgm.todopro.dto.TodoDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface TodoService {
    void register(@Valid TodoDTO todoDTO); //인터페이스 만들고(?)
    List<TodoDTO> getAll();
    TodoDTO getOne(int tno);
    void remove(int tno);


    void modify(TodoDTO todoDTO);
}
