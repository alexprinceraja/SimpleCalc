package com.calculator.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

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
		Mockito.when(service.add(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(expected);
		Double actual = controller.add(1d, 2d);
		assertEquals(expected, actual);
	}
}
