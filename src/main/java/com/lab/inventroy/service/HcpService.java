package com.lab.inventroy.service;

import com.lab.inventroy.domain.Hcp;
import com.lab.inventroy.dto.HcpDto;
import com.lab.inventroy.entity.HcpEntity;
import com.lab.inventroy.exception.NotFoundException;
import com.lab.inventroy.exception.UnprocessableException;
import com.lab.inventroy.mapper.HcpMapper;
import com.lab.inventroy.repository.HcpRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HcpService {

  private final HcpRepository hcpRepository;
  private final HcpMapper hcpMapper;


  public List<HcpDto> getAllHcp() {
    List<HcpDto> hcps = hcpRepository.findAll()
                                     .stream()
                                     .map(
                                         hcp -> hcpMapper.hcpToHcpDtop(hcp))
                                     .collect(Collectors.toList());

    if (hcps.isEmpty()) {
      throw new NotFoundException("No Hcps found");

    }
    return hcps;
  }

  public void saveHcp(Hcp hcp) {
    hcpRepository.save(hcpMapper.hcpToHcpEntity(hcp));
  }

  public void updateHcp(long id, Hcp hcp) {
    HcpEntity hcpEntity = hcpMapper.hcpToHcpEntity(hcp);
    hcpEntity.setId(id);
    hcpRepository.save(hcpEntity);
  }

  public void deleteHcp(long id) {
    try {
      hcpRepository.delete(HcpEntity.builder()
                                    .id(id)
                                    .build());
    } catch (DataIntegrityViolationException ex) {
      throw new UnprocessableException("Error occurred while deleting hcp with id " + id);
    }
  }
}
