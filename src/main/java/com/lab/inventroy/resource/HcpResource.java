package com.lab.inventroy.resource;

import com.lab.inventroy.domain.Hcp;
import com.lab.inventroy.service.HcpService;
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
@RequestMapping("/api/v1/hcps")
@Slf4j
@RequiredArgsConstructor
@Api(value = "Resource to manage Hcp")
public class HcpResource {

  private final HcpService hcpService;

  /**
   * Api to return all the hcps available
   *
   * @return the list of hcps
   */
  @ApiOperation(value = "Get all the available hcps", response = Hcp.class,
      responseContainer = "List")
  @GetMapping
  public ResponseEntity getAllHcp() {
    log.debug("fetching all Hcps");
    return ResponseEntity.ok(hcpService.getAllHcp());
  }

  /**
   * Api to save the new hcp
   *
   * @param hcp the new hcp to be saved
   * @return success message on saving the request object
   */
  @ApiOperation(value = "To save new hcp", notes = "all inputs are mandatory",
      response = String.class)
  @PostMapping
  public ResponseEntity saveHcp(@Valid @RequestBody Hcp hcp) {
    hcpService.saveHcp(hcp);
    log.debug("save request for hcp with hcp id {}", hcp.getHcpId());
    return ResponseEntity.ok("saved successfully");
  }

  /**
   * Api to update the already existing hcp
   *
   * @param id  the id of the hcp to be updated
   * @param hcp updated hcp request object
   * @return success message on updating the request object
   */
  @ApiOperation(value = "To update an existing hcp", notes = "all inputs are mandatory",
      response = String.class)
  @PutMapping("/{id}")
  public ResponseEntity updateHcp(@PathVariable("id") long id,
      @Valid @RequestBody Hcp hcp) {
    hcpService.updateHcp(id, hcp);
    log.debug("update request for hcp with  id {}", hcp.getHcpId());
    return ResponseEntity.ok("updated successfully");
  }

  /**
   * Api to deleted the already existing hcp
   *
   * @param id of the hcp to be deleted
   * @return success message on deleting the request object
   */
  @ApiOperation(value = "To delete an existing hcp", notes = "all inputs are mandatory",
      response = String.class)
  @DeleteMapping("/{id}")
  public ResponseEntity deleteHcp(@PathVariable long id) {
    hcpService.deleteHcp(id);
    log.debug("delete request for hcp with  id {}", id);
    return ResponseEntity.ok("Hcp deleted with id " + id);
  }
}
