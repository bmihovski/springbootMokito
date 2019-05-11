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
	public int calculateSumUsingDataService() {
		int[] data = someDataservice.retrieveAllData();
		return Arrays.stream(data).reduce(0, (acc, value) -> acc + value);
	}

}
