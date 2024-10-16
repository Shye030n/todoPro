package com.orgpgm.todopro.controller;


import com.orgpgm.todopro.dto.PageRequestDTO;
import com.orgpgm.todopro.dto.TodoDTO;
import com.orgpgm.todopro.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    //@Autowired
    private final TodoService todoService;
    @GetMapping("/register")
    public void registerGet(){
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        log.info("registerPost()"+todoDTO);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult);
            return "redirect:/todo/register";
        }
        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }

   // @GetMapping("/list") //이거만 주석처리 해도, 밑에 메서드 실행 X
    public void list(Model model){
        log.info("list"); //  /WEB-INF/views/todo/list가 리턴
        List<TodoDTO> todoList= todoService.getAll(); // 모든 데이터 갖고 온 것을 왼쪽에 넣음
        model.addAttribute("todoList", todoList);
        //return "todo/list";
    }
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, BindingResult bindingResult,Model model){
        log.info("list");
        if(bindingResult.hasErrors()){
            pageRequestDTO=PageRequestDTO.builder().build();
        }
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    @PostMapping("/remove")
    public String remove(TodoDTO todoDTO, RedirectAttributes redirectAttributes) {
        log.info("remove()");
        todoService.remove(Math.toIntExact(todoDTO.getTno()));
        return "redirect:/todo/list";

    }
    @PostMapping("/modify")
    public String modify(TodoDTO todoDTO, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes){
        log.info("modify()"+todoDTO);
        todoService.modify(todoDTO);
        redirectAttributes.addAttribute("tno", todoDTO.getTno());
        redirectAttributes.addFlashAttribute("pageRequestDTO", pageRequestDTO);
        return "redirect:/todo/read";

    }

    @GetMapping({"/read","/modify"})
    public void read(@RequestParam("tno") int tno, PageRequestDTO pageRequestDTO, Model model) {
        log.info("read");
        TodoDTO todoDTO=todoService.getOne(tno);
        model.addAttribute("dto",todoDTO);
    }

}