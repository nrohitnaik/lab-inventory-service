package com.lab.inventroy.resource;

import com.lab.inventroy.domain.XDevice;
import com.lab.inventroy.service.XDeviceService;
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
@RequestMapping("/api/v1/x-devices")
@RequiredArgsConstructor
@Slf4j
public class XDeviceResource {

  private final XDeviceService xDeviceService;

  @GetMapping
  public ResponseEntity getAllXDevices() {
    return ResponseEntity.ok(xDeviceService.getAllXDevices());
  }

  @PostMapping
  public ResponseEntity saveXDevice(@Valid @RequestBody XDevice xDevice) {
    xDeviceService.saveDevice(xDevice);
    return ResponseEntity.ok("Device saved successfully");
  }

  @PutMapping("/{id}")
  public ResponseEntity updateXDevice(@PathVariable("id") long id,
      @Valid @RequestBody XDevice xDevice) {
    xDeviceService.updateXDevice(id, xDevice);
    return ResponseEntity.ok("updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteXDevice(@PathVariable("id") long id) {
    xDeviceService.deleteXDevice(id);
    return ResponseEntity.ok("X device deleted with id " + id);
  }
}
