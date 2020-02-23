package com.lab.inventroy.mapper;

import com.lab.inventroy.domain.Hcp;
import com.lab.inventroy.dto.HcpDto;
import com.lab.inventroy.entity.HcpEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HcpMapper {

  HcpDto hcpToHcpDtop(HcpEntity hcp);

  @Mapping(target = "id", ignore = true)
  HcpEntity hcpToHcpEntity(Hcp hcp);

}
