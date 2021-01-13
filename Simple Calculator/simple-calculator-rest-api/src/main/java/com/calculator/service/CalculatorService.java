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

	/**
	 * This method is used to add two value.
	 * 
	 * @param input1 This is the first param
	 * @param input2 This is the second param
	 * @return double This returns sum of input1 and input2.
	 */
	public Double add(int input1, int input2) {
		Double result = (double) (input1 + input2);
		repo.save(entityDtoMapping(input1, input2, result, "+"));
		return result;
	}

	/**
	 * This method is used to subtract two value.
	 * 
	 * @param input1 This is the first param
	 * @param input2 This is the second param
	 * @return double This returns subtract of input1 and input2.
	 */
	public Double subtract(int input1, int input2) {
		Double result = (double) (input1 - input2);
		repo.save(entityDtoMapping(input1, input2, result, "-"));
		return result;
	}

	/**
	 * This method is used to multiply two value.
	 * 
	 * @param input1 This is the first param
	 * @param input2 This is the second param
	 * @return double This returns multiply of input1 and input2.
	 */
	public Double multiply(int input1, int input2) {
		Double result = (double) (input1 * input2);
		repo.save(entityDtoMapping(input1, input2, result, "*"));
		return result;
	}

	/**
	 * This method is used to divide two value.
	 * 
	 * @param input1 This is the first param
	 * @param input2 This is the second param
	 * @return double This returns divide of input1 and input2.
	 */
	public Double divide(int input1, int input2) throws ArithmeticException {
		if (input2 != 0) {
			Double result = (double) (input1 / input2);
			repo.save(entityDtoMapping(input1, input2, result, "/"));
			return result;
		} else {
			throw new ArithmeticException("Number cannot be divided by 0");
		}
	}

	/**
	 * This method is used for Mapping DTO entity.
	 * 
	 * @return Calc
	 */
	private Calc entityDtoMapping(int input1, int input2, Double result, String operator) {
		Calc calc = new Calc();
		calc.setInput1(String.valueOf(input1));
		calc.setInput2(String.valueOf(input2));
		calc.setResult(result.toString());
		calc.setOperator(operator);
		return calc;
	}

	/**
	 * This method is used to fetch history details from DB.
	 * 
	 * @return List
	 */
	public List<Calc> getHistory() {
		return repo.getHistory();
	}
}
