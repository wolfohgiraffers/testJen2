package com.ohgiraffers.tddproject.service;

import com.ohgiraffers.tddproject.dto.CalculatorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    private static Stream<Arguments> providerStringSource() {

        // given
        return Stream.of(
                Arguments.of(new CalculatorDTO(1, 2)),
                Arguments.of(new CalculatorDTO(3, 5)),
                Arguments.of(new CalculatorDTO(10, -2))
        );
    }

    @DisplayName("두 수의 합 구하기 테스트")
    @ParameterizedTest
    @MethodSource("providerStringSource")
    void testPlus(CalculatorDTO input) {

        // when
        int expected = input.getNum1() + input.getNum2();

        // then
        int actual = calculatorService.plus(input);

        Assertions.assertEquals(expected, actual);
    }
}