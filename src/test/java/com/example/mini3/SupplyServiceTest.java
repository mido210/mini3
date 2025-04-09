package com.example.mini3;

import com.example.mini3.supply.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SupplyServiceTest {

  @Autowired
  private SupplyService supplyService;

  @Test
  public void saveTest() {
    Supply supply = new Supply(null, "샤프", null, 10);
    System.out.println(supply);

    supplyService.save(supply);
    System.out.println(supply);

    assertNotNull(supply.getSno());
  }

  @Test
  public void findAllTest() {
    List<Supply> list = supplyService.findAll();
    System.out.println(list);
    assertNotEquals(0, list.size());
  }

  @Test
  public void findBySnoTest() {
    Supply supply = supplyService.findBySno(1);
    assertNotNull(supply);
  }

  @Transactional
  @Test
  public void plusTest() {
    boolean result = supplyService.plus(1);
    assertTrue(result);
  }

  @Transactional
  @Test
  public void downTest() {
    boolean result = supplyService.down(1);
    assertTrue(result);  // 수량이 1 초과인 경우에만 true
  }

  @Transactional
  @Test
  public void deleteTest() {
    boolean result = supplyService.delete(1);
    assertTrue(result);
  }
}