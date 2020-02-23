package com.lab.inventroy.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HcpDto {

  private long id;
  private String hcpId;
  private String street;
  private String city;
  private String cityCode;
  private String name;

}
