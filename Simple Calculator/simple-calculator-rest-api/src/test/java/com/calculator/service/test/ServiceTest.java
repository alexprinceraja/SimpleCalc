package com.calculator.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.calculator.model.Calc;
import com.calculator.model.ErrorResponse;
import com.calculator.repo.CalcRepo;
import com.calculator.service.CalculatorService;

public class ServiceTest {

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Mock
	CalcRepo repo;

	@InjectMocks
	CalculatorService service;

	@Test
	public void addTest() {
		Double expected = 3d;
		Calc calc = new Calc();
		calc.setResult("3");
		calc.getResult();
		calc.setInput1(calc.getInput1());
		calc.setInput2(calc.getInput2());
		calc.setOperator(calc.getOperator());
		calc.setId(calc.getId());
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.add(1, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void subtractTest() {
		Double expected = 12d;
		Calc calc = new Calc();
		calc.setInput1(calc.getInput1());
		calc.setInput2(calc.getInput2());
		calc.setOperator(calc.getOperator());
		calc.setResult("12");
		calc.getResult();
		calc.setId(calc.getId());
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.subtract(15, 3);
		assertEquals(expected, actual);
	}

	@Test
	public void multiplyTest() {
		Double expected = 16d;
		Calc calc = new Calc();
		calc.setInput1(calc.getInput1());
		calc.setInput2(calc.getInput2());
		calc.setOperator(calc.getOperator());
		calc.setResult("16");
		calc.getResult();
		calc.setId(calc.getId());
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.multiply(4, 4);
		assertEquals(expected, actual);
	}

	@Test
	public void divideTest() {
		Double expected = 10d;
		Calc calc = new Calc();
		calc.setInput1(calc.getInput1());
		calc.setInput2(calc.getInput2());
		calc.setOperator(calc.getOperator());
		calc.setResult("10");
		calc.getResult();
		calc.setId(calc.getId());
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.divide(40, 4);
		assertEquals(expected, actual);
	}

	@Test
	public void getHistoryTest() {
		List<Calc> expected = new ArrayList<Calc>();
		expected.add(new Calc());
		Mockito.when(repo.getHistory()).thenReturn(expected);
		List<Calc> actual = service.getHistory();
		assertEquals(expected, actual);
	}

	@Test
	public void divideFailTest() {
		try {
			service.divide(10, 0);
		} catch (ArithmeticException ex) {
			ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
			error.setMessage(error.getMessage());
			ArithmeticException expected = new ArithmeticException("Number cannot be divided by 0");
			assertEquals(expected.getLocalizedMessage(), ex.getLocalizedMessage());
		}
	}
}
