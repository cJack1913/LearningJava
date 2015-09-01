package datastructures.sort;

import java.util.Random;

public class randomArray {
	public static int[] getRandomArray(int n){
		Random random = new Random();
		int data[] = new int[n];
		for(int i = 0;i < n;i++){
			data[i] = random.nextInt(100);
		}
		return data;
	}
}
