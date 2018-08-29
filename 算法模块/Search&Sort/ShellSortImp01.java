package p33;

/**
 * 希尔排序算法实现(缩小增量排序)
 * @author Guozhu Zhu
 * @date 2018/8/29
 * @version 1.0
 *
 */
public class Test04 {
	
	/*========== Test ==========*/
	public static void main(String[] args) {
		int[] arr = {1, 45, 3, 2, 8, 7};
		Sort01(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	//希尔排序算法， 不稳定的排序， O(n)=nlogn;
	public static void Sort01(int[] arr) {
		int gap = arr.length / 2;
		while (gap >= 1) {
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				int j = 0;
				for (j = i-gap; j >= 0 && temp < arr[j]; j = j-gap) {
					arr[j+gap] = arr[j];
				}
				arr[j+gap] = temp;
			}
			gap = gap / 2;
		}
	}

}
