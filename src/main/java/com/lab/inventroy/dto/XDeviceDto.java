package com.lab.inventroy.dto;


import com.lab.inventroy.domain.HardwareState;
import com.lab.inventroy.entity.HcpEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XDeviceDto {

  private long id;
  private String manufactureId;
  private HcpEntity hcp;
  private HardwareState hardwareState;
}
