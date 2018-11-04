package p44;

/**
 * 查找和排序算法实现#week9#1
 * @author Guozhu Zhu
 * @date 2018/10/29
 * @version 1.0 
 *
 */
public class SearchAndSort01 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] arr = {1, 1, 0, 3, 2, 7, 6, 6, 5};
		//sort1(arr);
		//sort2(arr);
		//sort3(arr);
		//sort4(arr);
		//sort5(arr);
		//sort6(arr, 0, arr.length-1);
		//sort7(arr);
		sort8(arr);
		for (int i : arr) {
			System.out.print(i + ",");
		}
	}
	
	//1. BubbleSort, Time:O(n)=n^2, Space:O(n)=1, Stable;
	public static void sort1(int[] arr) {
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
	
	//2. SelectSort, Time:O(n)=n^2, Space:O(n)=1, UnStable;
	//UnStable e.g. : 1, 1, 0, ...
	public static void sort2(int[] arr) {
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
	
	//3. InsertSort, Time:O(n)=n^2, Space:O(n)=1, Stable;
	public static void sort3(int[] arr) {
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
	
	//4. InsertSortII, Time:O(n)=n^2, Space:O(n)=1, Stable;
	public static void sort4(int[] arr) {
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
	
	//5. ShellSort, Time:O(n)=nlogn ~ n^2, Space:O(n)=1, UnStable;
	public static void sort5(int[] arr) {
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
	
	//6. QuickSort, Time:O(n)=nlogn, Space:O(n)=logn, UnStable;
	public static void sort6(int[] arr, int left, int right) {
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
		sort6(arr, left, i-1);
		sort6(arr, i+1, right);
	}
	
	//7. MergeSort, Time:O(n)=nlogn, Space:O(n)=n, Stable;
	public static void sort7(int[] arr) {
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
		for (int a = 0; a < k; a++) {
			arr[first+a] = temp[a];
		}
	}

	//8. 堆排序算法实现， O(n)=nlogn;
	public static void sort8(int[] arr) {
		int len = arr.length;
		for (int i = (len-1)/2; i >= 0; i--) {
			downAdjust(arr, i, arr.length-1);
		}
		for (int k = arr.length-1; k >= 0; k--) {
			swap(arr, 0, k);
			downAdjust(arr, 0, k-1);
		}
	}
	
	public static void downAdjust(int[] arr, int parentIndex, int length) {
		int temp = arr[parentIndex];
		int childIndex = parentIndex*2+1;
		while (childIndex <= length) {
			if (childIndex+1 <= length && arr[childIndex+1] > arr[childIndex]) {
				childIndex++;
			}
			if (temp >= arr[childIndex]) {
				break;
			}
			arr[parentIndex] = arr[childIndex];
			parentIndex = childIndex;
			childIndex = childIndex*2+1;
		}
		arr[parentIndex] = temp;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
