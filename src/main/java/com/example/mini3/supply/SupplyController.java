package com.example.mini3.supply;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class SupplyController {
  @Autowired
  private SupplyService supplyService;

  @GetMapping("/supply/add")
  public ModelAndView save() {
    return new ModelAndView("supply/add");
  }
  @PostMapping("/supply/add")
  public ModelAndView save(@ModelAttribute Supply supply) {
    int sno = supplyService.save(supply);
    return new ModelAndView("redirect:/supply/read?sno=" + sno);
  }
  @GetMapping("/supply/list")
  public ModelAndView findAll() {
    List<Supply> list = supplyService.findAll();
    return new ModelAndView("supply/list").addObject("supplies", supplyService.findAll());
  }
  @GetMapping("/supply/read")
  public ModelAndView findBySno(@RequestParam Integer sno) {
    Supply supply = supplyService.findBySno(sno);
    if(supply==null)
      return new ModelAndView("redirect:/supply/list");
    return new ModelAndView("supply/read").addObject("supply", supply);
  }
  @PostMapping("/supply/plus")
  public ModelAndView plus(@RequestParam Integer sno) {
    supplyService.plus(sno);
    return new ModelAndView("redirect:/supply/read?sno=" + sno);
  }
  @PostMapping("/supply/down")
  public ModelAndView down(@RequestParam Integer sno) {
    supplyService.down(sno);
    return new ModelAndView("redirect:/supply/read?sno=" + sno);
  }
  @PostMapping("/supply/delete")
  public ModelAndView delete(@RequestParam Integer sno) {
    supplyService.delete(sno);
    return new ModelAndView("redirect:/supply/list");
  }
}
