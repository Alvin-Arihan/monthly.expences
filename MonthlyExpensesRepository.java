package com.rpy.monthly.expences.repository;

import com.rpy.monthly.expences.dto.MonthlyItems;
import com.rpy.monthly.expences.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyExpensesRepository extends JpaRepository<Items, Long> {
}
