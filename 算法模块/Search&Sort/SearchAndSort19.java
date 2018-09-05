package p33;

import java.util.Arrays;
/**
 * 查找和排序算法实现
 * @author Guozhu Zhu
 * @date 2018/9/4
 * @version 1.0
 *
 */
public class Test12 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 5, 2, 7};
		//Sort01(arr);
		//Sort02(arr);
		Sort07(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	//1.冒泡排序算法实现， 稳定的排序，O(n)=n^2;
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
			System.out.println(Arr2Str(arr));
		}
	}
	
	//2. 将数组转换为字符串
	public static String Arr2Str(int[] a) {
		if (a == null) {
			return "null";
		}
		int iMax = a.length-1;
		if (iMax == -1) {
			return "[]";
		}
		StringBuilder b = new StringBuilder();
		b.append("[");
		for (int i =0; ; i++) {
			b.append(a[i]);
			if (i == a.length-1) {
			    return b.append("]").toString();
			}
			b.append(",");
		}
	}
	
	//3. 选择排序算法实现， 不稳定的排序算法实现， O(n)=n^2;
	public static void Sort02(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				} 
			}
			System.out.println(Arr2Str(arr));
		}
	}
	
	//4. 直接插入排序算法实现，稳定的排序算法实现， O(n)=n^2;
	public static void Sort03(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];    //待插入元素
			int j = i-1;
			while (j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;     //插入元素
		}
	}
	
	//5. 二分插入排序算法实现， 稳定的排序算法实现， O(n)=n^2;
	public static void Sort04(int[] arr) {
		for (int i= 1; i < arr.length; i++) {
			int temp = arr[i];
			//开始二分查找插入元素位置
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
	
	//6. 希尔排序（缩小增量排序）， 不稳定的排序， O(n)=n^2;
	public static void Sort05(int[] arr) {
		int gap = arr.length-1 / 2;
		while (gap >= 1) {
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				int j = i-gap;
				while (j >= 0 && arr[j] > temp) {
					arr[j+gap] = arr[gap];
					j = j-gap;
				}
				arr[j+gap] = temp;
			}
			gap = gap / 2;    //缩小增量
		}
	}
	
	//7. 快速排序算法实现， 不稳定的排序， O(n)=nlogn;
	public static void Sort06(int[] arr, int left, int right) {
		if (left > right) {
			return;
		}
		int i = left;
		int j = right;
		int temp = arr[i];    //基准元素
		while (i < j) {
			while (i < j && arr[j] > temp) {
				j--;
			}
			arr[i] = arr[j];
			while (i < j && arr[i] < temp) {
				i++;
			}
			arr[j] = arr[i];
		}
		arr[i] = temp;
		Sort06(arr, left, i-1);
		Sort06(arr, i+1, right);
	}
	
	//8. 归并排序算法实现， 稳定的排序算法实现， O(n)=nlogn;
	public static void Sort07(int[] arr) {
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
			temp[k++] =arr[j++];
		}
		for (int a = 0; a < k; a++) {
			arr[a+first] = temp[a];
		}
	}

}
