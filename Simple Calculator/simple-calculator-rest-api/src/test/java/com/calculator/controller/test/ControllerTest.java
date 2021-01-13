package com.calculator.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.calculator.controllers.SimpleCalculatorContoller;
import com.calculator.service.CalculatorService;

public class ControllerTest {

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@InjectMocks
	SimpleCalculatorContoller controller;

	@Mock
	CalculatorService service;

	@Test
	public void addTest() {
		Double expected = 3d;
		Mockito.when(service.add(Mockito.anyInt(), Mockito.anyInt())).thenReturn(expected);
		Double actual = controller.add(1, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void subtractTest() {
		Double expected = 5d;
		Mockito.when(service.subtract(Mockito.anyInt(), Mockito.anyInt())).thenReturn(expected);
		Double actual = controller.subtract(10, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void multiplyTest() {
		Double expected = 15d;
		Mockito.when(service.multiply(Mockito.anyInt(), Mockito.anyInt())).thenReturn(expected);
		Double actual = controller.multiply(10, 3);
		assertEquals(expected, actual);
	}

	@Test
	public void divideTest() throws Exception {
		Double expected = 5d;
		Mockito.when(service.divide(Mockito.anyInt(), Mockito.anyInt())).thenReturn(expected);
		Double actual = controller.divide(15, 3);
		assertEquals(expected, actual);
	}
}
