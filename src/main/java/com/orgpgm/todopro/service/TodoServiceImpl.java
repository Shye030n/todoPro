package com.orgpgm.todopro.service;

import com.orgpgm.todopro.dto.TodoDTO;
import com.orgpgm.todopro.mapper.TodoMapper;
import com.orgpgm.todopro.vo.TodoVo;
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
        log.info("service register"+todoDTO);// service에 register메서드가 잘 전달됐는지 확인(?) 머라노
        TodoVo todoVo = modelMapper.map(todoDTO, TodoVo.class);
        log.info(todoVo);
        todoMapper.insert(todoVo);


    }
    @Override
    public List<TodoDTO> getAll() {
        log.info("service getAll");
        //return todoMapper.getList();
        List<TodoDTO> dtoList = todoMapper.getList().stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toUnmodifiableList());
        return dtoList;
    }
}
