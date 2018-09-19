package p40;

/**
 * 排序和查找算法实现
 * @author Guozhu Zhu
 * @date 2018/9/19
 * @version 1.0
 *
 */
public class Test11 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 6, 5, 8, 7};
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	//ArrToStr
	public static String ArrToStr(int[] arr) {
		if (arr == null) {
			return null;
		}
		if (arr.length == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i == arr.length-1) {
				break;
			}
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	//1. 冒泡排序算法实现，O(n)=n^2, 空间O(n)=1, 稳定的排序算法实现;
	public static void Sort01(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-j; j++) {
				if (arr[j+1] > arr[j]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	//2. 直接选择排序算法实现，  O(n)=n^2, 空间O(n)=1, 稳定的排序算法实现;
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
    
	//3. 堆排序算法实现， O(n)=nlogn, 空间O(n)=1, 不稳定的排序算法实现;
	public static void Sort03(int[] arr) {
		int len = arr.length;
		for (int i = (int) Math.floor(len/2); i > 0; i--) {
			downAdjust(arr, i, arr.length-1);
		}
		for (int i = arr.length-1; i >= 0; i--) {
			swap(arr, 0, i);
			downAdjust(arr, 0, i-1);
		}
	}
	
	public static void downAdjust(int[] arr, int parentIndex, int length) {
		int temp = arr[parentIndex];
		int childIndex = parentIndex*2+1;
		while (childIndex <= length) {
			if (childIndex+1 <= length && arr[childIndex+1] > arr[childIndex]) {
				childIndex++;
			}
			if (arr[childIndex] < temp) {
				break;
			}
			arr[parentIndex] = arr[childIndex];
			parentIndex = childIndex;
			childIndex = childIndex*2;
	    }
		arr[parentIndex] = temp;		
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//4. 直接插入排序算法实现， O(n)=n^2, 空间O(n)=1, 稳定的排序算法实现;
	public static void Sort04(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while (j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	//5. 二分插入排序算法实现， O(n)=n^2, 空间O(n)=1, 稳定的排序算法实现;
	public static void Sort05(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
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
	
	//6. 希尔排序算法实现， O(n)=nlogn ~ n^2, 最优n^1.3, 不稳定的排序算法;
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
				arr[j+gap] = arr[j];
			}
			gap = gap / 2;
		}
	}
	
	//7. 快速排序算法实现， O(n)=nlogn, 空间O(n)=logn, 不稳定的排序算法实现;
	public static void Sort07(int[] arr, int left, int right) {
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
			arr[j] = arr[i];
		}
		arr[i] = key;
		Sort07(arr, left, i-1);
		Sort07(arr, i+1, right);
	}
	
	//8. 归并排序算法实现， O(n)=nlogn, 空间O(n)=n, 稳定的排序算法实现;
	public static void Sort08(int[] arr) {
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
		int m = mid;
		int n = last;
		int k = 0;
		while (i <= m && j <= n) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i];
			} else {
				temp[k++] = arr[j];
			}
		}
		while (i <= m) {
			temp[k++] = arr[i];
		}
		while (j <= n) {
			temp[k++] = arr[j];
		}
		for (int a = 0; a < k; a++) {
			arr[a+first] = temp[a];
		}
	}
	
}
