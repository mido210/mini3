package com.example.mini3.supply;

import lombok.*;

import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Supply {
  private Integer sno;
  private String name;
  private LocalDate regDate;
  private Integer quantity;
}
