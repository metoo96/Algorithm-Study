package p32;

/**
 * 查找和排序算法实现#Day12
 * @author Guozhu Zhu
 * @date 2018/8/24
 * @version 1.0
 *
 */
public class Test04 {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 4, 7, 8, 9, 10, 11, 32};
		//Sort01(arr);            //1.冒泡排序
		//Sort02(arr);              //2.选择排序
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//1.冒泡排序算法实现， 稳定的排序， O(n)=n^2;
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
	
	//2.选择排序算法实现， 不稳定的排序， O(n)=n^2;
	public static void Sort02(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
	//3.直接插入排序算法实现， 稳定的排序， O(n)=n^2;
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
	
	//4.二分插入排序算法实现， 稳定的排序， O(n)=n^2;
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
			for (int j = i-1; j >= low; j--) {
				arr[j+1] = arr[j];
			}
			arr[low] = temp;
		}
	}
	
	//5.冒泡排序算法实现， 不稳定的排序， O(n)=nlogn
	public static void Sort05(int[] arr, int left, int right) {
		if (left > right) {
			return ;
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
	
	//6.二分查找非递归实现 O(n)=logn
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
	
	//7.二分查找递归实现
	public static int search02(int[] arr, int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low+high) / 2;
		if (arr[mid] > target) {
			return search02(arr, target, low, mid-1);
		} else if (arr[mid] < target) {
			return search02(arr, target, mid+1, high);
		} else {
			return mid;
		}
	} 
	
	//8.顺序查找 O(n)= n;
	public static int search03(int[] arr, int target) {
		int i = 0;
		while (i < arr.length) {
			if (target == arr[i]) {
				return i;
			}
			i++;
		}
		return -1;
	}

}
