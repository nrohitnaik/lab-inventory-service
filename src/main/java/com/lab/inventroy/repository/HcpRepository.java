package com.lab.inventroy.repository;

import com.lab.inventroy.entity.Hcp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HcpRepository extends JpaRepository<Hcp, Long> {

}
