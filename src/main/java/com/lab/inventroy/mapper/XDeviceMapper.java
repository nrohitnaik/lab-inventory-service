package com.lab.inventroy.mapper;

import com.lab.inventroy.domain.XDevice;
import com.lab.inventroy.dto.XDeviceDto;
import com.lab.inventroy.entity.XDeviceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface XDeviceMapper {


  XDeviceDto xDeviceEntityToXDeviceDto(XDeviceEntity xDevice);

  @Mapping(target = "hcp.id", source = "xDevice.hcpId")
  @Mapping(target = "id", ignore = true)
  XDeviceEntity xDeviceToXDeviceEntity(XDevice xDevice);
}
