import java.util.ArrayList;

/**
 * 旋转数组的最小值
 * @author Guozhu Zhu
 * @date 2018/8/15
 * @version 1.0
 *
 */
public class Solution {
    
    public int minNumberInRotateArray(int [] arr) {
      if (arr == null || arr.length <= 0) {
			return 0;
		}
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while (arr[low] >= arr[high]) {
			if (high-low == 1) {
				mid = high;
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
		int min = arr[low];
		for (int i = low; i < high; i++) {
			if (arr[i] < arr[low]) {
				min = arr[i];
			}
		}
		return min;
	}

}