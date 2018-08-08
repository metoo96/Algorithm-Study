package p23;

/**
 * 二分查找算法实现
 * @author Guozhu Zhu
 * @date 2018/8/9
 * @version 1.0
 *
 */
public class Test05 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	    int ans = search(arr, 5);
	    System.out.println(ans);
	}
	
	public static int search(int[] arr, int target) {
		int low = 0;
		int high = arr.length-1; 
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] > target) {
				high = mid - 1;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
