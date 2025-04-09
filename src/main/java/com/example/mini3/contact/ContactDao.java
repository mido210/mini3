package com.example.mini3.contact;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface ContactDao {
  @Select("select * from contact")
  List<Contact> findAll();

  @SelectKey(statement = "select con_seq.nextval from dual", keyProperty = "cno", resultType = Integer.class, before = true)
  @Insert("insert into contact(cno, name, address, tel) values(#{cno}, #{name}, #{address}, #{tel})")
  public void save(Contact contact);

  @Select("select * from contact where cno=#{cno} and rownum=1")
  public Contact findByCno(int cno);

  @Update("update contact set address=#{address}, tel=#{tel} where cno=#{cno} and rownum=1")
  public int update(Contact contact);

  @Delete("delete from contact where cno=#{cno} and rownum=1")
  public int delete(int cno);
}
