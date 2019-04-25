package com.atos.boyan.business;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.atos.boyan.model.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int [] {1, 2, 3};
	}

}

class SomeDataServiceStubEmpty implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class SomeDataServiceStubOneValue implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}

}


public class SomeBusinessStubTest {
	SomeBusinessImpl someBusiness;
	@Before
	public void setup() {
		someBusiness = new SomeBusinessImpl();
	}

	@Test
	public void calculateSumUsingDataService_basic() {
		someBusiness.setSomeDataservice(new SomeDataServiceStub());
		int actualResult = someBusiness.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		someBusiness.setSomeDataservice(new SomeDataServiceStubEmpty());
		int actualResult = someBusiness.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		someBusiness.setSomeDataservice(new SomeDataServiceStubOneValue());
		int actualResult = someBusiness.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}

}
