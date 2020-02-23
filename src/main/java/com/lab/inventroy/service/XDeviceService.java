package com.lab.inventroy.service;

import com.lab.inventroy.domain.HardwareState;
import com.lab.inventroy.domain.XDevice;
import com.lab.inventroy.dto.XDeviceDto;
import com.lab.inventroy.entity.HcpEntity;
import com.lab.inventroy.entity.XDeviceEntity;
import com.lab.inventroy.exception.NotFoundException;
import com.lab.inventroy.exception.UnprocessableException;
import com.lab.inventroy.mapper.XDeviceMapper;
import com.lab.inventroy.repository.XDeviceRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class XDeviceService {

  private final XDeviceRepository xDeviceRepository;
  private final XDeviceMapper xDeviceMapper;

  public List<XDeviceDto> getAllXDevices() {
    List<XDeviceDto> xDevices = xDeviceRepository.findAll()
                                                 .stream()
                                                 .map(
                                                     xDevice -> xDeviceMapper.xDeviceEntityToXDeviceDto(
                                                         xDevice))
                                                 .collect(Collectors.toList());
    if (xDevices.isEmpty()) {
      throw new NotFoundException("No x devices were found");
    }
    return xDevices;
  }

  public void saveDevice(XDevice xDevice) {
    xDeviceRepository.save(XDeviceEntity.builder()
                                        .hardwareState(updateHardwareState(xDevice.getHcpId()))
                                        .manufactureId(xDevice.getManufactureId())
                                        .hcp(buildHcpEntity(xDevice.getHcpId()))
                                        .build());
  }

  public void updateXDevice(long id, XDevice xDevice) {
    xDeviceRepository.save(XDeviceEntity.builder()
                                        .id(id)
                                        .hcp(buildHcpEntity(xDevice.getHcpId()))
                                        .manufactureId(xDevice.getManufactureId())
                                        .hardwareState(updateHardwareState(xDevice.getHcpId()))
                                        .build());
  }

  public void deleteXDevice(long id) {
    try {
      xDeviceRepository.delete(XDeviceEntity.builder()
                                            .id(id)
                                            .build());
    } catch (DataIntegrityViolationException ex) {
      throw new UnprocessableException("Error occurred while deleting X device with id " + id);
    }
  }

  private HardwareState updateHardwareState(String hcpId) {
    if (hcpId == null || hcpId
        .isBlank()) {

      return HardwareState.UNASSIGNED;
    } else {
      return HardwareState.ASSIGNED;
    }
  }

  private HcpEntity buildHcpEntity(String hcpId) {
    if (hcpId == null || hcpId.isBlank()) {
      return null;
    }
    return HcpEntity.builder()
                    .id(Long.parseLong(hcpId))
                    .build();
  }

}
