package com.atos.boyan.business;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SomeBusinessTest {
	SomeBusinessImpl someBusiness;
	@Before
	public void setup() {
		someBusiness = new SomeBusinessImpl();
	}

	@Test
	public void calculateSum_basic() {
		int actualResult = someBusiness.calculateSum(new int[] {1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSum_empty() {
		int actualResult = someBusiness.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSum_oneValue() {
		int actualResult = someBusiness.calculateSum(new int[] {5});
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
