package datastructures.sort;

/*
 * 与直接插入类似，只是与前序比较时采用折半查找法找到插入位置 O(n^2)
 * 以low为插入位置，比它小则low不变，插在low的位置，比它大则low+1，插在其后
 */
public class BinaryInsertSort {

	public static void binaryInsertSort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			if (data[i] < data[i - 1]) {
				int tmp = data[i];
				int low = 0;
				int high = i - 1;
				while (low <= high) {
					int mid = (low + high) / 2;
					if (tmp <= data[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}
				for (int j = i; j > low; j--) {
					data[j] = data[j - 1];
				}
				data[low] = tmp;
				Util.print(data);
			}
		}
	}

	public static void main(String[] args) {
		int[] data = Util.getRandomArray(10);
		Util.print(data);
		binaryInsertSort(data);
	}
}
