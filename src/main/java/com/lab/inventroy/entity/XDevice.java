package com.lab.inventroy.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "xdevices")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class XDevice {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String manufacturerId;
  @JoinColumn(name = "hcps.id")
  @OneToOne
  private Hcp hcp;
  private String hardwareState;
}
