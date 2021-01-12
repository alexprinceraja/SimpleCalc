package com.calculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculator.model.Calc;
import com.calculator.repo.CalcRepo;

@Service
public class CalculatorService {

	@Autowired
	CalcRepo repo;

	public Double add(Double a, Double b) {
		Double c = a + b;
		repo.save(entityDtoMapping(a, b, c, "+"));
		return c;
	}

	public Double subtract(Double a, Double b) {
		Double c = a - b;
		repo.save(entityDtoMapping(a, b, c, "-"));
		return c;
	}

	public Double multiply(Double a, Double b) {
		Double c = a * b;
		repo.save(entityDtoMapping(a, b, c, "*"));
		return c;
	}

	public Double divide(Double a, Double b) throws Exception {
		if (b != 0) {
			Double c = a / b;
			repo.save(entityDtoMapping(a, b, c, "/"));
			return c;
		} else {
			throw new Exception("Number cannot be divided by 0");
		}
	}

	private Calc entityDtoMapping(Double a, Double b, Double c, String operator) {
		Calc calc = new Calc();
		calc.setInput1(a.toString());
		calc.setInput2(b.toString());
		calc.setResult(c.toString());
		calc.setOperator(operator);
		return calc;
	}

	public List<Calc> getHistory() {
		return repo.getHistory();
	}
}
