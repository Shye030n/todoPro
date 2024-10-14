package com.orgpgm.todopro.service;


import com.orgpgm.todopro.dto.TodoDTO;
import com.orgpgm.todopro.mapper.TodoMapper;
import com.orgpgm.todopro.vo.TodoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info("service register"+todoDTO);
        TodoVO todoVO=modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {
        log.info("service getAll");
        //return todoMapper.getList();
        List<TodoDTO> dtoList=todoMapper.getList().stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toUnmodifiableList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(int tno) {
        log.info("service getOne");
        TodoVO todoVO=todoMapper.selectOne(tno);
        TodoDTO todoDTO=modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(int tno) {
        log.info("service remove");
        todoMapper.delete(tno);
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO=modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }
}