package com.boyan.unittesting.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.boyan.unittesting.data.SomeDataService;

@Service
public class SomeBusinessImpl {
	
	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
	
	public int calculateSum(int[] values) {
		return Arrays.stream(values)
					 .reduce(Integer::sum)
					 .orElse(0);
	}
	
	public int calculateSumUsingDataService() {
		
		int[] data = someDataService.retrieveAllData();
		
		return Arrays.stream(data)
					 .reduce(Integer::sum)
					 .orElse(0);
		
	}
	
}
