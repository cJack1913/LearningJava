package datastructures.sort;

import java.util.Random;

public class Util {

	public static int[] getRandomArray(int n) {
		Random random = new Random();
		int data[] = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = random.nextInt(100);
		}
		return data;
	}

	public static void print(int[] data) {
		for (int i : data) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	public static void swap(int[] data, int i, int j) {
		if (i == j) {
			//若i=j则操作数为0
			return;
		}
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}
}
