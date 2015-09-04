package datastructures.sort;
/*
 * 逐次向后比较，大则换 O(n^2)
 * 具有稳定性，这里的稳定性是指原序列中相同元素的相对顺序仍然保持到排序后的序列，而堆排序、快速排序均不具有稳定性。
 * 1.i与i+1比较，大则换，i++
 * 2.循环1直至i>=n
 */
public class BobbleSort {

	public static void bobbleSort(int[] data) {
		for (int i = data.length - 1; i > 0; i--) {
			boolean isSorted = false;
			for (int j = 0; j < i; j++) {
				if (data[j] > data[j + 1]) {
					Util.swap(data, j, j + 1);
					isSorted = true;
					Util.print(data);
				}
			}
			if (!isSorted) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] data = Util.getRandomArray(10);
		Util.print(data);
		bobbleSort(data);
		Util.print(data);
	}

}
