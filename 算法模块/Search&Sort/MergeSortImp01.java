package p33;

/**
 * 归并排序算法实现
 * @author Guozhu Zhu
 * @date 2018/8/29
 * @version 1.0
 *
 */
public class Test03 {
	
	/*========== Test ==========*/
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 6, 7, 8};
		new Test03().MergeSort(arr, 6);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	//将有二个有序数列a[first...mid]和a[mid...last]合并。, O(n)=n;
	public void mergearray(int a[], int first, int mid, int last, int temp[]) {
		
		int i = first, j = mid + 1;
		int m = mid,   n = last;
		int k = 0;
		
		while (i <= m && j <= n) {
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		
		while (i <= m)
			temp[k++] = a[i++];
		
		while (j <= n)
			temp[k++] = a[j++];
		
		for (i = 0; i < k; i++)
			a[first + i] = temp[i];
	}
	
	public void mergesort(int a[], int first, int last, int temp[]) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergesort(a, first, mid, temp);        //左边有序
			mergesort(a, mid + 1, last, temp);     //右边有序
			mergearray(a, first, mid, last, temp); //再将二个有序数列合并
		}
	}
	 
	public boolean MergeSort(int a[], int n) {
		int[] p = new int[n];
		if (p == null)
			return false;
		mergesort(a, 0, n - 1, p);
		return true;
	}

}
