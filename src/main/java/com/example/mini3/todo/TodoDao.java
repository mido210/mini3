package com.example.mini3.todo;

import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

@Mapper
public interface TodoDao {
    @SelectKey(statement = "select todo_seq.nextval from dual", keyProperty = "tno",
            resultType = Integer.class, before = true)
    @Insert("insert into todo (tno, title, memo, deadline, finish) " +
            "values (#{tno}, #{title}, #{memo, jdbcType=VARCHAR}, #{deadline, jdbcType=DATE}, #{finish})")
    int save(Todo todo);


    @Select("select tno, title, memo, reg_Date as regDate, deadline, finish from todo order by tno desc ")
    public List<Todo> findAll();

    @Select("select tno, title, memo, reg_Date as regDate, deadline, finish from todo where tno=#{tno} and rownum=1")
    public Optional<Todo> findByTno(int tno);

    @Update("update todo set deadline=#{deadline}, memo=#{memo} where tno=#{tno} and rownum=1")
    public int update(Todo todo);

    @Update(("update todo set finish=1 where tno=#{tno}"))
    public int finish(int tno);

    @Delete("delete from todo where tno=#{tno}")
    public int delete(int tno);

}
