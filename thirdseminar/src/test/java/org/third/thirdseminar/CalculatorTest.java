package org.third.thirdseminar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void plus(){
		int sum = Calculator.plus(1,2);
		assertEquals(3,sum);
		assertEquals(5,Calculator.plus(4,1));
	}
}
