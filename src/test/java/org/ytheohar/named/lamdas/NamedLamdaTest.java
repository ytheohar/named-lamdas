package org.ytheohar.named.lamdas;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NamedLamdaTest {

	private static final String TO_UPPER_CASE_LAMDA_NAME = "toUpperCase";
	private static final String TO_LOWER_CASE_LAMDA_NAME = "toLowerCase";

	private static final NamedLamda TO_UPPER_CASE_LAMDA = ((NamedLamda) String::toUpperCase)
			.namedWith(TO_UPPER_CASE_LAMDA_NAME);
	private static final NamedLamda TO_LOWER_CASE_LAMDA = ((NamedLamda) e -> e
			.toLowerCase()).namedWith(TO_LOWER_CASE_LAMDA_NAME);

	private static final String INPUT = "HoW tO nAmE lAmDaS";
	private static final String OUTPUT_UPPER_CASE = "HOW TO NAME LAMDAS";
	private static final String OUTPUT_LOWER_CASE = "how to name lamdas";

	@Test
	public void namedLamdas() {
		assertEquals(TO_UPPER_CASE_LAMDA.apply(INPUT), OUTPUT_UPPER_CASE);
		assertEquals(TO_LOWER_CASE_LAMDA.apply(INPUT), OUTPUT_LOWER_CASE);

		assertEquals(TO_UPPER_CASE_LAMDA.toString(), TO_UPPER_CASE_LAMDA_NAME);
		assertEquals(TO_LOWER_CASE_LAMDA.toString(), TO_LOWER_CASE_LAMDA_NAME);
	}

	@DataProvider
	private Object[][] input() {
		return new Object[][] {
				{ TO_UPPER_CASE_LAMDA, INPUT, OUTPUT_UPPER_CASE },
				{ TO_LOWER_CASE_LAMDA, INPUT, OUTPUT_LOWER_CASE } };
	}

	@Test(dataProvider = "input")
	public void inputNamedLamdas(NamedLamda func, String input,
			String expectedOutput) {
		assertEquals(func.apply(input), expectedOutput);
		assertEquals(func.apply(input), expectedOutput);
	}

}
