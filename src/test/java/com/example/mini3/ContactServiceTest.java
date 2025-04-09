package com.example.mini3;

import com.example.mini3.contact.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContactServiceTest {
  @Autowired
  private ContactService contactService;

   @Test
  public void saveTest() {
     Contact contact = new Contact(null, "ㅎㅇ", "서울시 성수동 광야로0번길", "010-9852-3100");
     System.out.println(contact);

     contactService.save(contact);
     System.out.println(contact);
   }
  @Test
  public void findAllTest() {
    List<Contact> contacts = contactService.findAll();
    System.out.println(contacts);
    assertEquals(1,contacts.size());
  }

  @Test
  public void findByCnoTest() {
     assertEquals(true, contactService.findByCno(1).isPresent());
  }

  @Transactional
  @Test
  public void updateTest() {
     Contact contact = new Contact(1, "ㅂㅇ", "광야로 2번길 성수동 D 타워", "null");
     assertEquals(true, contactService.update(contact));
  }

  @Transactional
  @Test
  public void deleteTest() {
     assertEquals(true, contactService.delete(1));
  }
}
