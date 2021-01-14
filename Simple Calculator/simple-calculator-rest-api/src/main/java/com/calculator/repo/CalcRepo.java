package com.calculator.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.calculator.model.Calc;

@Repository
public interface CalcRepo extends JpaRepository<Calc, Integer> {

	@Query("select cal from Calc cal order by cal.id desc")
	List<Calc> getHistory();
}
