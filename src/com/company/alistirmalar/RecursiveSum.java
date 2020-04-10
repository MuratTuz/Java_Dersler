package com.company.alistirmalar;

import java.util.Random;

public class RecursiveSum {

	private static int id=0;

	public int getId() {
		return id;
	}

	public RecursiveSum() {
		id++;
	}


	public int[] randomSeries(int amount) {
		Random random = new Random(4711);
		int[] series = new int[amount];
		for (int index = 0; index < amount; index++) {
			series[index] = random.nextInt(10);
		}
		return series;
	}


}
