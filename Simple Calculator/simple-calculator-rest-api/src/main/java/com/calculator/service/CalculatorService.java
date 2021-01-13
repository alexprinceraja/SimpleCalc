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

	public Double add(int a, int b) {
		Double c = (double) (a + b);
		repo.save(entityDtoMapping(a, b, c, "+"));
		return c;
	}

	public Double subtract(int a, int b) {
		Double c = (double) (a - b);
		repo.save(entityDtoMapping(a, b, c, "-"));
		return c;
	}

	public Double multiply(int a, int b) {
		Double c = (double) (a * b);
		repo.save(entityDtoMapping(a, b, c, "*"));
		return c;
	}

	public Double divide(int a, int b) throws ArithmeticException {
		if (b != 0) {
			Double c = (double) (a / b);
			repo.save(entityDtoMapping(a, b, c, "/"));
			return c;
		} else {
			throw new ArithmeticException("Number cannot be divided by 0");
		}
	}

	private Calc entityDtoMapping(int a, int b, Double c, String operator) {
		Calc calc = new Calc();
		calc.setInput1(String.valueOf(a));
		calc.setInput2(String.valueOf(b));
		calc.setResult(c.toString());
		calc.setOperator(operator);
		return calc;
	}

	public List<Calc> getHistory() {
		return repo.getHistory();
	}
}
