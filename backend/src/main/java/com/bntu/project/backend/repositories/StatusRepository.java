package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Status;
import org.apache.logging.log4j.status.StatusLogger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
