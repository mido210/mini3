package com.example.mini3.supply;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class SupplyService {
  @Autowired
  private SupplyDao supplyDao;

  public int save(Supply supply) {
    supplyDao.save(supply);
    return supply.getSno();
  }
  public List<Supply> findAll() {
    return supplyDao.findAll();
  }
  public Supply findBySno(Integer sno) {
    return supplyDao.findBySno(sno);
  }
  public boolean plus(Integer sno) {
    return supplyDao.plus(sno) == 1;
  }
  public boolean down(Integer sno) {
    if(supplyDao.findBySno(sno).getQuantity()<=1)
      return false;
    return supplyDao.down(sno) == 1;
  }
  public boolean delete(Integer sno) {
    return supplyDao.delete(sno) == 1;
  }
}
