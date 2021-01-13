package com.calculator.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.calculator.model.Calc;
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
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.add(1, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void subtractTest() {
		Double expected = 12d;
		Calc calc = new Calc();
		calc.setResult("12");
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.subtract(15, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void multiplyTest() {
		Double expected = 16d;
		Calc calc = new Calc();
		calc.setResult("16");
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.multiply(4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	public void divideTest() {
		Double expected = 10d;
		Calc calc = new Calc();
		calc.setResult("10");
		Mockito.when(repo.save(Mockito.any())).thenReturn(calc);
		Double actual = service.divide(40, 4);
		assertEquals(expected, actual);
	}
	@Test
	public void divideFailTest() {
		ArithmeticException expected = new ArithmeticException("Number cannot be divided by 0");
		try {
			service.divide(10, 0);
		} catch (ArithmeticException ex) {
			assertEquals(expected.getLocalizedMessage(), ex.getLocalizedMessage());
		}
	}
}
