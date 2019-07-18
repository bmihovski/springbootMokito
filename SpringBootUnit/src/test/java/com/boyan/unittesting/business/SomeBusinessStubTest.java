package com.boyan.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boyan.unittesting.data.SomeDataService;

class SomeDataServiceStubBasic implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}
}

class SomeDataServiceStubOneValue implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 5 };
	}
}

class SomeDataServiceStubEmpty implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeBusinessStubTest {

	private SomeBusinessImpl someBusinessImpl;
	
	@Autowired
	public void setSomeBusinessStubTest(SomeBusinessImpl someBusinessImpl) {
		this.someBusinessImpl = someBusinessImpl;
	}

	@Test
	public void calculateSumDataService_basic() {
		someBusinessImpl.setSomeDataService(new SomeDataServiceStubBasic());
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		assertThat(actualResult).isEqualTo(6);
	}

	@Test
	public void calculateSum_empty() {
		someBusinessImpl.setSomeDataService(new SomeDataServiceStubEmpty());
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		assertThat(actualResult).isEqualTo(0);
	}

	@Test
	public void calculateSum_one_value() {
		someBusinessImpl.setSomeDataService(new SomeDataServiceStubOneValue());
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		assertThat(actualResult).isEqualTo(5);
	}

}
