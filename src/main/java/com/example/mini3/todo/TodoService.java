package com.example.mini3.todo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
public class TodoService {
    @Autowired
    private TodoDao todoDao;

    public int save(Todo todo) {
        if (todo.getMemo() == null) {
            todo.setMemo("");  // null 방지 처리
        }
        todoDao.save(todo);
        return todo.getTno();
    }
    public List<Todo> findAll(){
        return todoDao.findAll();
    }

    public Optional<Todo> findByMno(int tno){
        return todoDao.findByTno(tno);
    }
    public boolean update(Todo todo){
        if (todo.getDeadline() == null) {
            todo.setDeadline(LocalDate.now()); // 또는 적절한 기본값
        }
        return todoDao.update(todo)>0;
    }
    public boolean finish(int tno){
        return todoDao.finish(tno)>0;
    }
    public boolean delete (int tno){
        return todoDao.delete(tno)>0;
    }
}
