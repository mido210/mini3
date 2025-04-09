package com.example.mini3.todo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String home() {
        return "index"; // templates/index.html 렌더링
    }

    @GetMapping("/todo/list")
    public ModelAndView findAll() {
        return new ModelAndView("todo/list").addObject("todos", todoService.findAll());
    }

    @GetMapping("/todo/read")
    public ModelAndView findByMno(@RequestParam Integer tno) {
        Optional<Todo> result = todoService.findByMno(tno);
        if(result.isEmpty())
            return new ModelAndView("redirect:/todo/list");
        return new ModelAndView("todo/read").addObject("todo", result.get());
    }

    @GetMapping("/todo/write")
    public ModelAndView save() {
        return new ModelAndView("todo/write");
    }

    @PostMapping("/todo/write")
    public ModelAndView save(@ModelAttribute Todo todo) {
        int tno = todoService.save(todo);
        return new ModelAndView("redirect:/todo/read?tno=" + tno);
    }

    @PostMapping("/todo/update")
    public ModelAndView update(@ModelAttribute Todo todo) {
        todoService.update(todo);
        return new ModelAndView("redirect:/todo/read?tno=" + todo.getTno());
    }
    @PostMapping("/todo/finish")
    public ModelAndView finish(@RequestParam int tno){
        todoService.finish(tno);
        return new ModelAndView("redirect:/todo/read?tno=" + tno);
    }


    @PostMapping("/todo/delete")
    public ModelAndView delete(@RequestParam Integer tno) {
        todoService.delete(tno);
        return new ModelAndView("redirect:/todo/list");
    }
}

