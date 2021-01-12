package com.calculator.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	public void divideFailTest() {
		Exception expected = new Exception("Number cannot be divided by 0");
		try {
			service.divide(10d, 0d);
		} catch (Exception ex) {
			assertEquals(expected.getLocalizedMessage(), ex.getLocalizedMessage());
		}
	}
}
