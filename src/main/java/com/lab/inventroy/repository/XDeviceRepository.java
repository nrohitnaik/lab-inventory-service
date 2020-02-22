package com.lab.inventroy.repository;

import com.lab.inventroy.entity.XDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XDeviceRepository extends JpaRepository<XDevice, Long> {

}
