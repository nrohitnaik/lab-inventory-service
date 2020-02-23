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
public class XDevice {

  @NotEmpty
  private String manufactureId;
  private String hcpId;
  private HardwareState hardwareState;
}
