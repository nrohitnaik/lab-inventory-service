package com.lab.inventroy.mapper;

import com.lab.inventroy.dto.XDeviceDto;
import com.lab.inventroy.entity.XDeviceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface XDeviceMapper {

  XDeviceDto xDeviceEntityToXDeviceDto(XDeviceEntity xDevice);

}
