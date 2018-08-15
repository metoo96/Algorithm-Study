package p27;

import java.util.Arrays;
import java.util.Collections;

/**
 * 排序和查找算法实现#Day4
 * @author Guozhu Zhu
 * @date 2018/8/15
 * @version 1.0
 *
 */
public class Test01 {
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 10-i;
		}
		//Sort01(arr);    //1. 冒泡排序
		//Sort02(arr);    //2. 直接插入排序
		//Sort03(arr);    //3. 二分插入排序
		//Sort04(arr);    //4. 简单选择排序
		//Sort05(arr, 0, arr.length-1);
	    Arrays.sort(arr);
		//System.out.println(search01(arr, 10));
	    System.out.println(search02(arr, 10, 0, arr.length-1));
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
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
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//2. 直接插入排序算法实现
	public static void Sort02(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; //待插入元素
			int j = i-1;
			while (j >= 0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	//3. 二分插入排序算法实现
	public static void Sort03(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];   //待插入元素
			int low = 0;
			int high = i-1;
			int mid = 0;
			while (low <= high) {
				mid = (low+high) / 2;
			    if (arr[mid] > temp) {
			    	high = mid-1;//插入点在低半区
			    } else {
			    	low = mid+1; //插入点在高半区
			    }
			}
			for (int j = i-1; j >= low; j--) {
				arr[j+1] = arr[j];
			}
			arr[low] = temp;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//4. 选择排序算法实现
	public static void Sort04(int[] arr) {
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
	
	//5. 快速排序算法实现
	public static void Sort05(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int key = arr[i];
		while (i < j) {
			while (i < j && key <= arr[j]) {
				j--;
			}
			arr[i] = arr[j];
			while (i < j && key >= arr[i]) {
				i++;
			}
			arr[j] = arr[i];
		}
		arr[i] = key;
		Sort05(arr, left, i-1);
	    Sort05(arr, i+1, right);
	}
	
	//6. 二分查找算法的非递归实现
	public static int search01(int[] arr, int target) {
		int low = 0;
		int high = arr.length-1;
	    int mid = 0;
	    while (low <= high) {
	    	mid = (low+high) / 2;
	    	if (arr[mid] < target) {
	    	    low = mid+1;
	    	} else if (arr[mid] > target) {
	    		high = mid-1;
	    	} else {
	    		return mid;
	    	}
	    } 
	    return -1;
	}
	
	//7. 二分查找递归实现
	public static int search02(int[] arr, int key, int low , int high) {
		if (low > high) {
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
