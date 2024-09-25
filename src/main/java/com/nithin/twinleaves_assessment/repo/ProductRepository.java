package com.nithin.twinleaves_assessment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nithin.twinleaves_assessment.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
