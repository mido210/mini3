package com.example.mini3;

import com.example.mini3.todo.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TodoServiceTest {
    @Autowired
    private  TodoService todoService;

    @Test
   public void saveTest(){
        Todo todo = Todo.builder()
                .title("할 일 제목")
                .memo("메모 내용")
                .deadline(LocalDate.of(2025, 4, 10))
                .finish(1)
                .build();
        System.out.println(todo);
        todoService.save(todo);
    }


    public void findAllTest(){
        List<Todo> todos = todoService.findAll();
        assertNotEquals(0,todos.size());
    }
    public void findByMnoTest() {
        assertEquals(true, todoService.findByMno(1).isPresent());
    }
    public void updateTest() {
        Todo todo = Todo.builder()
                .title("할 일 제목2")
                .memo("메모 내용13321")
                .deadline(LocalDate.of(2025, 4, 10))
                .build();
        assertEquals(true, todoService.update(todo));
    }
    public void finishTest(){
        Todo todo = Todo.builder().finish(1).build();
        assertEquals(true,todoService.finish(1));
    }

    public void deleteTest() {
        assertEquals(true, todoService.delete(1));
    }
}
