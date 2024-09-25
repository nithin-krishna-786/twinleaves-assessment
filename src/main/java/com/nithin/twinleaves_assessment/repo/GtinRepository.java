package com.nithin.twinleaves_assessment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nithin.twinleaves_assessment.entity.Gtin;

public interface GtinRepository extends JpaRepository<Gtin, Long> {
    List<Gtin> findByGtin(String gtin);
}
