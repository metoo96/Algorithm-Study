package p33;

/**
 * 查找和排序算法实现
 * @author Guozhu Zhu
 * @date 2018/8/30
 * @version 1.0
 *
 */
public class Test08 {
	
	/*========== Test ==========*/
	public static void main(String[] args) {
		int[] arr = {1, 5, 4, 3, 2, 9, 0};
		Sort07(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	//1.冒泡排序算法实现(交换排序)， 稳定的排序， O(n)=n^2;
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
	
	//2.选择排序算法实现，不稳定的排序， O(n)=n^2;
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
	
	//3.直接插入排序算法实现，稳定的排序，O(n)=n^2;
	public static void Sort03(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while (j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	//4.二分插入排序算法实现， 稳定的排序，O(n)=n^2;
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
		}
	}
	
	//5.快速排序算法实现(交换排序)， 不稳定的排序算法实现， O(n)=nlogn; 利用分治算法的递归实现;
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
	
	//6.希尔排序算法实现(插入排序算法的增强版), 不稳定的排序， O(n)=nlogn~n^2, 最优O(n)=n^1.3;
	public static void Sort06(int[] arr) {
		int gap = arr.length-1 / 2;
		while (gap >= 1) {
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				int j = i-gap;
				while (j >= 0 && arr[j] > temp) {
					arr[j+gap] = arr[j];
					j = j-gap;
				}
				arr[j+gap] = temp;
			}
			gap = gap / 2;
		}
	}
	
	//7.归并排序算法实现， 稳定的排序， O(n)=nlogn;
	public static void Sort07(int[] arr) {
		int[] temp = new int[arr.length];
		MergeSortCore(arr, 0, arr.length-1, temp);
	}
	
	public static void MergeSortCore(int[] arr, int first, int last, int[] temp) {
		int mid = (first+last) / 2;
		if (first < last) {
			MergeSortCore(arr, first, mid, temp);
			MergeSortCore(arr, mid+1, last, temp);
			Merge(arr, first, mid, last, temp);
		}
	}
	
	public static void Merge(int[] arr, int first, int mid, int last, int[] temp) {
		int i = first;
		int j = mid+1;
		int m = mid;
		int n = last;
		int k = 0;
		while (i <= m && j <= n) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= m) {
			temp[k++] = arr[i++];
		}
		while (j <= n) {
			temp[k++] = arr[j++];
		}
		for (int l = 0; l < k; l++) {
			arr[first+l] = temp[l];
		}
	}
	
	//8.顺序查找算法， O(n)=n;
	public static int search01(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	//9.二分查找算法实现， 递归实现， O(n)=logn;
	public static int search02(int[] arr, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = (low+high) / 2;
		if (arr[mid] < target) {
			low = mid+1;
		} else if (arr[mid] > target) {
			high = mid-1;
		} else {
			return mid;
		}
		return -1;
	}

}
