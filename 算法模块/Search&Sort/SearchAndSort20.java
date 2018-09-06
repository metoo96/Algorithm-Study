package p36;

/**
 * 查找和排序算法实现
 * @author Guozhu Zhu
 * @date 2018/9/7
 * @version 1.0
 *
 */
public class Test01 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
	    int[] arr = {1, 3, 2, 4, 0, 9, 6, 7, 5, 8};	
	    for (int i : arr) {
	        System.out.println(i);	
	    }
	}
	
	//1. 冒泡排序算法实现， 稳定的排序， O(n)=n^2;
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
	
	//2. 选择排序算法实现， 稳定的排序， O(n)=n^2;
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
	
	//3. 直接插入排序算法实现，稳定的排序算法实现， O(n)=n^2;
	public static void Sort03(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while (j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
	}
	
	//4. 二分插入排序算法实现， 稳定的排序算法实现， O(n)=n^2, 只是缩短了查找插入位置的时间，并没有降低时间复杂度；
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
	
	//5. 希尔排序算法实现， 不稳定的排序， O(n) = nlogn ~ n^2之间， 最好O(n)=n^1.3;
	public static void Sort05(int[] arr) {
		int gap = arr.length-1 / 2;
		while (gap >= 1) {
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				int j = i-1;
				while (j >= 0 && arr[j] > temp) {
					arr[j+gap] = arr[gap];
				}
				arr[j+gap] = temp;
			}
			gap = gap / 2;
		}
	}
	
	//6. 快速排序算法实现， 不稳定的排序， O(n)=nlogn;
	public static void Sort06(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int key = arr[i];
		while (i < j) {
			while (i < j && arr[j] >= key) {
				j--;
			}
			arr[i] = arr[j];
			while (i < j && arr[i] <= key) {
				i++;
			}
		}
		arr[i] = key; //复位
		Sort06(arr, left, i-1);
		Sort06(arr, i+1, right);
	}
	
	//7. 归并排序算法实现， 稳定的排序算法实现，O(n)=nlogn;
	public static void Sort7(int[] arr) {
		int[] temp = new int[arr.length];
		MergeSort(arr, 0, arr.length-1, temp);
	}
	
	public static void MergeSort(int[] arr, int first, int last, int[] temp) {
		if (first < last) {
			int mid = (first+last) / 2;
			MergeSort(arr, first, mid, temp);
			MergeSort(arr, mid+1, last, temp);
			Merge(arr, first, mid, last, temp);
		}
	}
	
	public static void Merge(int[] arr, int first, int mid, int last, int[] temp) {
		int i = first;
		int j = mid+1;
		int m = mid+1;
		int n = last;
		int k = 0;
		while (i <= n && j <= m) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= n) {
			temp[k++] = arr[i++];
		} 
		while (j <= m) {
			temp[k++] = arr[j++];
		}
		for (int a = 0; a <= k; a++) {
			arr[a+first] = arr[a];
		}
	}
	
	//8. 顺序查找算法实现, O(n)=n;
	public static int Search01(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (target == arr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	//9  二分查找算法实现， O(n)=logn;
	public static int Search02(int[] arr, int target) {
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
	
	//10 二分查找算法实现， O(n)=logn;
	public static int Search03(int[] arr, int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low+high) / 2;
		if (arr[mid] < target) {
			return Search03(arr, target, mid+1, high);
		} else if(arr[mid] > target){
			return Search03(arr, target, low, mid-1);
		} else {
			return mid;
		}
	}

}
