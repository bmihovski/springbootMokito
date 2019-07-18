package com.boyan.unittesting.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

	@MockBean
	SomeDataService mockedDataService;
	
	@Before
	public void setUp() {
		someBusinessImpl.setSomeDataService(mockedDataService);
	}
	
	
	@Test
	public void calculateSomeBusinessImpl_basic() {
		when(mockedDataService.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
		
		assertThat(someBusinessImpl.calculateSumUsingDataService()).isEqualTo(6);
	}

	@Test
	public void calculateSomeBusinessImpl_no_value() {
		when(mockedDataService.retrieveAllData()).thenReturn(new int[] {});
		
		assertThat(someBusinessImpl.calculateSumUsingDataService()).isEqualTo(0);
	}
	
	@Test
	public void calculateSomeBusinessImpl_single_value() {
		when(mockedDataService.retrieveAllData()).thenReturn(new int[] {5});
		
		assertThat(someBusinessImpl.calculateSumUsingDataService()).isEqualTo(5);
	}
}
