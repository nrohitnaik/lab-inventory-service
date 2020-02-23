package com.lab.inventroy.domain;

import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Hcp {

  @NotEmpty
  private String hcpId;
  @NotEmpty
  private String street;
  @NotEmpty
  private String city;
  @NotEmpty
  private String cityCode;
  @NotEmpty
  private String name;

}
