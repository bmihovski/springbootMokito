package com.atos.boyan.business;

import com.atos.boyan.model.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataservice;

	public void setSomeDataservice(SomeDataService someDataservice) {
		this.someDataservice = someDataservice;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}

	public int calculateSumUsingDataService() {
		int sum = 0;
		int[] data = someDataservice.retrieveAllData();
		for (int value : data) {
			sum += value;
		}
		return sum;
	}

}
