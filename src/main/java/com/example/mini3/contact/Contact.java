package com.example.mini3.contact;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Contact {
  private Integer cno;
  private String name;
  private String address;
  private String tel;
}
