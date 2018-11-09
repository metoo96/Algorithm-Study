package com.zhuguozhu.util3;

/**
 * 随机选择算法实现
 * @author Guozhu Zhu
 * @date 2018/11/10
 * @version 1.0
 *
 */
public class RandomSelected01 {
	
	/* ============ Test =========== */
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 4, 7, 6};
		int ans = randomSelectedCore(arr, 0, arr.length-1, 4);
		System.out.println(ans);
	}
	
	public static int randomSelectedCore(int[] arr, int left, int right, int k) {
		if (left == right) {
			return arr[left];
		}
		int p = partition(arr, left, right);
		int m = p-left+1;
		if (k == m) {
			return arr[p];
		} else if (k < m) {
			return randomSelectedCore(arr, left, p-1, k);
		} else {
			return randomSelectedCore(arr, p+1, right, k-m);
		}
	}
	
	public static int partition(int[] arr, int left, int right) {
		int p = left;  //left ~ right随机数
		swap(arr, left, p);
		int temp = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
