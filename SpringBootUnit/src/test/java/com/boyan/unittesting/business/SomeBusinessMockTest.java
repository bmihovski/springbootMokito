package com.boyan.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boyan.unittesting.data.SomeDataService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeBusinessMockTest {

	SomeBusinessImpl someBusinessImpl;
	
	@Autowired
	public void setSomeBusinessImpl(SomeBusinessImpl someBusinessImpl) {
		this.someBusinessImpl = someBusinessImpl;
	}

	@Test
	public void calculateSomeBusinessImpl_basic() {
		SomeDataService mockedDataService = mock(SomeDataService.class);
		when(mockedDataService.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
		
		someBusinessImpl.setSomeDataService(mockedDataService);
		
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		
		assertThat(actualResult).isEqualTo(6);
	}

	@Test
	public void calculateSomeBusinessImpl_no_value() {
		SomeDataService mockedDataService = mock(SomeDataService.class);
		when(mockedDataService.retrieveAllData()).thenReturn(new int[] {});
		
		someBusinessImpl.setSomeDataService(mockedDataService);
		
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		
		assertThat(actualResult).isEqualTo(0);
	}
	
	@Test
	public void calculateSomeBusinessImpl_single_value() {
		SomeDataService mockedDataService = mock(SomeDataService.class);
		when(mockedDataService.retrieveAllData()).thenReturn(new int[] {5});
		
		someBusinessImpl.setSomeDataService(mockedDataService);
		
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		
		assertThat(actualResult).isEqualTo(5);
	}
}
