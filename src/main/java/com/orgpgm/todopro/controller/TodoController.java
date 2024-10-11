package com.orgpgm.todopro.controller;

import com.orgpgm.todopro.dto.TodoDTO;
import com.orgpgm.todopro.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    //@Autowired
    private final TodoService todoService;

    @GetMapping("/list")
    public void list(Model model){
        log.info("list"); //  /WEB-INF/views/todo/list가 리턴
        List<TodoDTO> todoList= todoService.getAll(); // 모든 데이터 갖고 온 것을 왼쪽에 넣음
        model.addAttribute("todoList", todoList);
    }
}
