package com.bntu.project.backend.repositories;

import com.bntu.project.backend.entity.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BandRepository extends JpaRepository<Band, Integer> {
    @Query(value = "SELECT * FROM band b WHERE b.?1 = ?2", nativeQuery = true)
    List<Band>  getBandByParams(@Param("col") String column, @Param("val") String value);
}
