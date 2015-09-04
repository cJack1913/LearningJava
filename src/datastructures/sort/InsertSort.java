package datastructures.sort;
/* 直接插入排序
 * 某数与前面i个有序序列从后往前进行比较，自身小则将其后移，否则插入其后，即找到比自己小的插在后面 O(n^2)
 * 1.视data[0]为第一个数据，形成一个有序序列
 * 2.将data[1]与r[0]比较，若大则插入r[0]后面，若小则r[0]后移
 * 3.将data[i]依次往前比较，若大则插入其后，若小则将其后移
 */
public class InsertSort {
	
	public static void insertSort(int[] data){
		for(int i = 1;i < data.length;i++){
			int tmp = data[i];
			int j = i-1;
			while(j >= 0&&tmp < data[j]){
				data[j+1] = data[j];		//边比较边后移
				j--;
			}
			data[j+1] = tmp;				//满足时插入至已经移好的位置
			Util.print(data);
		}
		
		
	}
	public static void main(String[] args) {
		int[] data = Util.getRandomArray(10);
		Util.print(data);
		insertSort(data);
	}

}
