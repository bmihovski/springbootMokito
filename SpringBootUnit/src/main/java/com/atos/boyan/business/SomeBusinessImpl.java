package com.atos.boyan.business;

import java.util.Arrays;

import com.atos.boyan.model.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataservice;

	public void setSomeDataservice(SomeDataService someDataservice) {
		this.someDataservice = someDataservice;
	}

	public int calculateSum(int[] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
   // Convert it with func programming
	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataservice.retrieveAllData();
		for (int value : data) {
			sum += value;
		}
		return sum;
	}

}
