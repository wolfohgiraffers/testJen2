package com.ohgiraffers.tddproject.controller;

import com.ohgiraffers.tddproject.service.CalculatorService;
import com.ohgiraffers.tddproject.dto.CalculatorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health_check")
    public String health() {
        return "fine";
    }

    @GetMapping("/plus")
    public CalculatorDTO getPlus(CalculatorDTO calculatorDTO) {
        int result = calculatorService.plus(calculatorDTO);
        calculatorDTO.setSum(result);
        return calculatorDTO;
    }
}
