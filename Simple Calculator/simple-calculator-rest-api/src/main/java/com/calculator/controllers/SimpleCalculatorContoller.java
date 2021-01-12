package com.calculator.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.model.Calc;
import com.calculator.service.CalculatorService;
/**
 * REST Calculator Main Controller 
 * @author alexprinceraja.g
 *
 */
@RestController
@RequestMapping("/calculator")
public class SimpleCalculatorContoller {
	
	@Autowired
	CalculatorService service;

	@GetMapping("/add")
	public Double add(@RequestParam(value="input1", required=true) Double input1,@RequestParam(value="input2", required=true) Double input2) {
		return service.add(input1, input2);
	}
	@GetMapping("/subtract")
	public Double subtract(@RequestParam(value="input1", required=true) Double input1,@RequestParam(value="input2", required=true) Double input2) {
		return service.subtract(input1, input2);
	}
	@GetMapping("/multiply")
	public Double multiply(@RequestParam(value="input1", required=true) Double input1,@RequestParam(value="input2", required=true) Double input2) {
		return service.multiply(input1, input2);
	}
	@GetMapping("/divide")
	public Double divide(@RequestParam(value="input1", required=true) Double input1,@RequestParam(value="input2", required=true) Double input2) throws Exception {
		return service.divide(input1, input2);
	}
	
	@GetMapping("/history")
	public List<Calc> getHistory()
	{
		return service.getHistory();
	}

}
