package p26;

import java.util.Arrays;

/**
 * 排序和查找算法#Day2
 * @author Guozhu Zhu
 * @date 2018/8/13
 * @version 1.0
 */
public class Test01 {
	
	public static void main(String[] args) {
	    int[] arr = {1, 2, 4, 3, 6, 8, 5, 0};
	    // Sort01(arr);
	    // Sort02(arr);
	    // Sort03(arr);
	    // Sort04(arr);
	    Arrays.sort(arr);
	    //System.out.println(search01(arr, 2));
	    System.out.println(search02(arr, 0, arr.length-1, 2));
	    for (int i : arr) {
	    	System.out.println(i);
	    }	    
	}
	
	//1. 冒泡排序， 属于交换排序的一种，是稳定的排序，O(n)= n^2
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
	
	//2. 选择排序，是不稳定的排序，O(n)=n^2
	public static void Sort02(int[] arr) {
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
	
	//3. 插入排序，是稳定的排序，O(n)=n^2
	public static void Sort03(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; //待插入的元素
			int j = i-1;
			while (j >= 0 && temp < arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	//4. 二分插入排序，是稳定的排序 
	public static void Sort04(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; //待插入元素
			int low = 0;
			int high = i-1;
			int mid;
			while (low <= high) {
				mid = (low+high) / 2;
				if (arr[mid] > temp) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			}
			for (int j = i-1; j >=low; j--) {
				arr[j+1] = arr[j];
			}
			arr[low] = temp; //插入元素
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//5. 快速排序, 不稳定排序，O(n)=nlogn
	public static void Sort05(int[] arr, int left, int right) {
		if (left >= right) {
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
		Sort05(arr, left, i-1);
		Sort05(arr, i+1, right);
	}
	
	//6.  二分查找算法非递归
	public static int search01(int[] arr, int target) {
		int low = 0;
		int high = arr.length;
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
	
	//7. 二分查找非递归实现
	public static int search02(int[] arr, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = (low+high) / 2;
		if (arr[mid] > target) {
			return search02(arr, low, mid-1, target);
		} else if (arr[mid] < target) {
			return search02(arr, mid+1, high, target);
		} else {
			return mid;
		}
	}

}
