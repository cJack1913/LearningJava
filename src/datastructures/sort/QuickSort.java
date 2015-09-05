package datastructures.sort;
/*
 * 快速排序，从待排序列中取一个数据(第一个)作为分界值，将小的放左边，大的放右边，直至长度为1 O(nlog2n)
 * 1.取第一个作为分界值mid = data[start]
 * 2.从start+1开始从前往后扫描，找到大于mid的则停，(i,标记大的)
 * 3.从end开始从后往前扫描，找到小于min的则停，(i,标记小的)
 * 4.若i<j则互换，循环2,3直至i>j(第一次循环时有可能i=j，之后不可能，此处true相当于i<=j)
 * 5.交换start和j的值
 * 6.递归[start,j-1],[j+1,end]
 */
public class QuickSort {

	public static void quickSort(int[] data, int start, int end) {
		if(start>=end){
			return;
		}
		int mid = data[start];
		int i = start + 1;
		int j = end;
		while (true) {
			while (i <= end && data[i] <= mid) {
				i++;
			}
			while (j > start && data[j] > mid) {
				j--;
			}
			if (i < j) {
				Util.swap(data, i, j);
				Util.print(data);
			} else {
				break;
			}
		}
		Util.swap(data, start, j);
		Util.print(data);
		quickSort(data, start, j - 1);
		quickSort(data, j + 1, end);

	}

	public static void main(String[] args) {
		int[] data = Util.getRandomArray(10);
		Util.print(data);
		quickSort(data, 0, data.length - 1);

	}

}
