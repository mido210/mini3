package com.example.mini3.contact;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Controller
public class ContactController {
  @Autowired
  private ContactService contactService;

  @GetMapping("/contact/list")
  public ModelAndView findAll() {
    return new ModelAndView("contact/list").addObject("contacts", contactService.findAll());
  }

  @GetMapping ("/contact/write")
  public ModelAndView save() {
    return new ModelAndView("contact/write");
  }

  @GetMapping ("/contact/read")
  public ModelAndView findByCno(@RequestParam Integer cno) {
    Contact contact = contactService.findByCno(cno);
    if (contact==null)
      return new ModelAndView("redirect:/contact/list");
    return new ModelAndView("contact/read").addObject("contact", contact);
  }

  @PostMapping("/contact/write")
  public ModelAndView save(@ModelAttribute Contact contact) {
    int cno = contactService.save(contact);
    return new ModelAndView("redirect:/contact/read?cno=" + cno);
  }

  @PostMapping("/contact/update")
  public ModelAndView update(@ModelAttribute Contact contact) {
    contactService.update(contact);
    return new ModelAndView("redirect:/contact/read?cno=" + contact.getCno());
  }

  @PostMapping("/contact/delete")
  public ModelAndView delete(@RequestParam(required = false) Integer cno) {
    if(cno == null) {
      return new ModelAndView("redirect:/contact/list");
    }
    contactService.delete(cno);
    return new ModelAndView("redirect:/contact/list");
  }



}
