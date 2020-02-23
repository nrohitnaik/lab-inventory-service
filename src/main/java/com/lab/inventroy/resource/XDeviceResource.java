package com.lab.inventroy.resource;

import com.lab.inventroy.domain.XDevice;
import com.lab.inventroy.service.XDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "Resource to manage X device")
public class XDeviceResource {

  private final XDeviceService xDeviceService;

  /**
   * Api to return all the X device available
   *
   * @return the list of xdevices
   */
  @ApiOperation(value = "To get all the x devices", response = XDevice.class, responseContainer = "List")
  @GetMapping
  public ResponseEntity getAllXDevices() {
    log.debug("fetching all x devices");
    return ResponseEntity.ok(xDeviceService.getAllXDevices());
  }

  /**
   * Api to save the new x device
   *
   * @param xDevice the new x device to be saved
   * @return success message on saving the request object
   */
  @ApiOperation(value = "To save new x device", notes =
      "If the hcpId is not provide then the device will"
          + " be in unassigned state", response = String.class)
  @PostMapping
  public ResponseEntity saveXDevice(@Valid @RequestBody XDevice xDevice) {
    log.debug("save request for x device with manufacture id {}", xDevice.getManufactureId());
    xDeviceService.saveDevice(xDevice);
    return ResponseEntity.ok("Device saved successfully");
  }

  /**
   * Api to update the already existing x device
   *
   * @param id      the id of the x device to be updated
   * @param xDevice updated x device request object
   * @return success message on updating the request object
   */
  @ApiOperation(value = "To update an existing x device", notes =
      "If the hcpId is not provide then the device will"
          + " be in unassigned state", response = String.class)
  @PutMapping("/{id}")
  public ResponseEntity updateXDevice(@PathVariable("id") long id,
      @Valid @RequestBody XDevice xDevice) {
    log.debug("update request for x device with id {}", id);
    xDeviceService.updateXDevice(id, xDevice);
    return ResponseEntity.ok("updated successfully");
  }

  /**
   * Api to deleted the already existing x device
   *
   * @param id of the x device to be deleted
   * @return success message on deleting the request object
   */
  @ApiOperation(value = "To delete an existing x device", response = String.class)
  @DeleteMapping("/{id}")
  public ResponseEntity deleteXDevice(@PathVariable("id") long id) {
    xDeviceService.deleteXDevice(id);
    log.debug("delete request for x device with id {}", id);
    return ResponseEntity.ok("X device deleted with id " + id);
  }
}
