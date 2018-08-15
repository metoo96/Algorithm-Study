package p26;

import java.util.Arrays;

/**
 * 排序和查找算法实现#Day3
 * @author Guozhu Zhu
 * @date 2018/8/13
 * @version 1.0
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 5, 7, 9, 0};
		//Sort01(arr);
		//Sort02(arr);
		//Sort03(arr);
		//Sort04(arr);
		//Sort05(arr, 0, arr.length-1);
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}		
	}
	
	//1. 冒泡排序算法实现
	public static void Sort01(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j+1] < arr[j]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				} 
			}
		}
	}
	
	//2. 选择排序算法实现
	public static void Sort02(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	//3. 插入排序算法实现
	public static void Sort03(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while (j >= 0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			} 
			arr[j+1] = temp;
		}
	}
	
	//4. 二分插入排序算法实现
	public static void Sort04(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int low = 0;
			int high = i-1;
			int mid = 0;
			while (low <= high) {
				mid = (low+high) / 2;
				if (arr[mid] > temp) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			}
			for (int j = i-1; j >= high+1; j--) {
				arr[j+1] = arr[j];
			}
			arr[high+1] = temp;
		}
	}
	
	//5. 快速排序算法实现
	public static void Sort05(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int key = arr[i];
		while (i < j) {
			while (i < j && key < arr[j]) {
				j--;
			}
			arr[i] = arr[j];
			while (i < j && key > arr[i]) {
				i++;
			}
			arr[j] = arr[i];
		}
		arr[i] = key;
		Sort05(arr, left,  i-1);
		Sort05(arr, i+1, right);
	}
	
	//6. 二分插入排序算法实现非递归实现
	public static int search01(int[] arr, int key) {
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while (low <= high) {
			mid = (low+high) / 2;
			if (arr[mid] > key) {
				high = mid-1;
			} else if (arr[mid] < key) {
				low = mid+1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	//7. 二分插入排序算法实递归实现
	public static int search02(int[] arr, int key, int low, int high) {
		if (low >= high) {
			return -1;
		}
		int mid = (low+high) / 2;
		if (arr[mid] > key) {
			return search02(arr, key, low, mid-1);
		} else if (arr[mid] < key) {
			return search02(arr, key, mid+1, high);
		} else {
			return mid;
		}
	}

}
