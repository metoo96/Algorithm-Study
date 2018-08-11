package p25;

import java.util.Arrays;

/**
 * 排序算法和查找算法实现
 * @author Guozhu Zhu
 * @date 2018/8/12
 * @version 1.0
 *
 */
public class Test04 {
	
	public static void main(String[] args) {
		int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Arrays.sort(arr);
		System.out.println(search01(arr, 4));
		//Sort01(arr); //冒泡排序called
		//Sort02(arr); //简单插入排序called
		//Sort03(arr); //选择排序called
		//Sort04(arr);   //二分插入排序called
		//Sort05(arr, 0, arr.length-1);
		for (int i : arr) {
			System.out.println("value:" + i);
		}
	}
	
	//冒泡排序(稳定的排序) O(n)=n^2;
	public static void Sort01(int[] arr) {
		//外层循环最多就是需要n-1次的循环, 如有第n次的比较是多余的自己与自己的比较;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
			    if (arr[j+1] < arr[j]) {
			    	int temp  = arr[j+1];
			    	arr[j+1] = arr[j];
			    	arr[j] = temp;
			    }
			}
			System.out.println(Arrays.toString(arr) + "==>" + i);
		}
	}
	
	//简单插入排序 (稳定的排序) O(n)=n^2
	public static void Sort02(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; //待插入元素
			int j = i-1;
			while (j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		    System.out.println(Arrays.toString(arr) + "==>" + i);
		}
	}
	
	//简单选择排序(不稳定的排序) O(n)=n^2
	//不稳定体现在： 例如： 442 如果2和4换， 前一个4跑到后面去了
	public static void Sort03(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//二分插入排序
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
					low = mid+1; //保持稳定的关键
				}
			}
			for (int j = i-1; j >= low; j--) {
				arr[j+1] = arr[j];
			}
			arr[low] = temp;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//快速排序算法实现 (不稳定) O(n)=nlogn
	public static void Sort05(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int key = arr[i];
		while (i < j) {
			while (i < j && arr[j] > key) {
				j--;
			}
			arr[i] = arr[j];
			while (i < j && arr[i] < key) {
				i++;
			}
			arr[j] = arr[i];
		}
		arr[i] = key;
		Sort05(arr, left, i-1);
		Sort05(arr, i+1, right);
	}
	
	//二分查找算法
	public static int search01(int[] arr, int target) {
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while (low <= high) {
			mid = (low+high) / 2;
			if (arr[mid] > target) {
				high = mid-1;
			} else if (arr[mid] < target) {
				low = mid+1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	

}
