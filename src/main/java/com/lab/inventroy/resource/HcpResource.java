package com.lab.inventroy.resource;

import com.lab.inventroy.domain.Hcp;
import com.lab.inventroy.service.HcpService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hcps")
@Slf4j
@RequiredArgsConstructor
public class HcpResource {

  private final HcpService hcpService;

  @GetMapping
  public ResponseEntity getAllHcp() {
    log.debug("fetching all Hcps");
    return ResponseEntity.ok(hcpService.getAllHcp());
  }

  @PostMapping
  public ResponseEntity saveHcp(@Valid @RequestBody Hcp hcp) {
    hcpService.saveHcp(hcp);
    return ResponseEntity.ok("saved successfully");
  }

  @PutMapping("/{id}")
  public ResponseEntity updateHcp(@PathVariable("id") long id, @Valid @RequestBody Hcp hcp) {
    hcpService.updateHcp(id, hcp);
    return ResponseEntity.ok("updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteHcp(@PathVariable("id") long id) {
    hcpService.deleteHcp(id);
    return ResponseEntity.ok("Hcp deleted with id " + id);
  }
}
