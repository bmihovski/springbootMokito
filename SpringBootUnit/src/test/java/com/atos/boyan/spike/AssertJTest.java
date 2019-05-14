package com.atos.boyan.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void learning() {

		List<Integer> numbers = Arrays.asList(10, 15, 34, 54);

		assertThat(numbers).hasSize(4)
			.contains(10, 15)
			.allMatch(x -> x > 5)
			.allMatch(x -> x < 100)
			.noneMatch(x -> x == 0);

		assertThat("").isEmpty();

		assertThat("ABCDE").contains("BCD")
			.startsWith("ABC")
			.endsWith("CDE");

	}

}
