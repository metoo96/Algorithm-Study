package p26;

/**
 * 旋转数组的最大值
 * @author Guozhu Zhu
 * @date 2018/8/14
 * @version 1.0
 *
 */
public class Test09 {
	
	public static void main(String[] args) {
		//int[] arr = {3, 4, 5, 1, 2};
		int[] arr = {1, 0, 1, 1, 1, 1};
		int res = MaxNumber(arr);
		System.out.println(res);
	}

	private static int MaxNumber(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return -1;
		}
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while (arr[low] >= arr[high]) {
			if (high-low == 1) {
				mid = low;
				break;
			}
			mid = (low+high) / 2;
			if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
				return seqSearch(arr, low, high);
			}
			if (arr[mid] >= arr[low]) {
				low = mid;
			}else if(arr[mid] <= arr[high]) {
				high = mid;
			}
		}
		return arr[mid];
	}

	private static int seqSearch(int[] arr, int low, int high) {
		int max = arr[low];
		for (int i = low; i < high; i++) {
			if (arr[i] > arr[low]) {
				max = arr[i];
			}
		}
		return max;
	}

}
