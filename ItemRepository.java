package com.rpy.monthly.expences.repository;

import com.rpy.monthly.expences.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<CategoryEntity, Long> {

//    List<CategoryEntity> saveAll(List<CategoryEntity> categoryList);
}
