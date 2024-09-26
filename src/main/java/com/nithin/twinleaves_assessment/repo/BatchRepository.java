package com.nithin.twinleaves_assessment.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nithin.twinleaves_assessment.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    
    List<Batch> findByAvailableQuantityGreaterThan(int availableQuantity);
    
    Optional<Batch> findTopByAvailableQuantityLessThanEqualOrderByInwardedOnDesc(int availableQuantity);
}

