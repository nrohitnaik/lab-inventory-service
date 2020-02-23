package com.lab.inventroy.service;

import com.lab.inventroy.domain.HardwareState;
import com.lab.inventroy.domain.XDevice;
import com.lab.inventroy.dto.XDeviceDto;
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
    checkIfHcpIdExists(xDevice);
    xDeviceRepository.save(xDeviceMapper.xDeviceToXDeviceEntity(xDevice));
  }

  public void updateXdevice(long id, XDevice xDevice) {
    checkIfHcpIdExists(xDevice);
    XDeviceEntity xDeviceEntity = xDeviceMapper.xDeviceToXDeviceEntity(xDevice);
    xDeviceEntity.setId(id);
    xDeviceRepository.save(xDeviceEntity);
  }

  private void checkIfHcpIdExists(XDevice xDevice) {
    if (xDevice.getHcpId().isBlank()) {
      xDevice.setHardwareState(HardwareState.UNASSIGNED);
    } else {
      xDevice.setHardwareState(HardwareState.ASSIGNED);
    }
  }

  public void deleteXdDevice(long id) {
    try {
      xDeviceRepository.delete(XDeviceEntity.builder()
                                            .id(id)
                                            .build());
    } catch (DataIntegrityViolationException ex) {
      throw new UnprocessableException("Error occurred while deleting X device with id " + id);
    }
  }
}
