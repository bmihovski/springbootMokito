package com.boyan.unittesting.business;

import java.util.Arrays;

public class SomeBusinessImpl {

	public int calculateSum(int[] values) {
		return Arrays.stream(values)
					 .reduce(Integer::sum)
					 .orElse(0);
	}
}
