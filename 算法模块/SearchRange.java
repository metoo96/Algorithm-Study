package p48;

/**
 * 查找搜索范围
 * @author Guozhu Zhu
 * @date 2019/2/14
 * @version 1.0
 *
 */
public class SearchRange {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 3, 6};
		int[] res = new int[2];
		res[0] = -1;
		res[0] = -1;
		searchRange(arr, res, 3);
		System.out.println(res[0] + " " + res[1]);
	}
	
	public static void searchRange(int[] arr, int[] res, int target) {
		core(arr, 0, arr.length-1, target, res);
	}
	
	public static void core(int[] arr, int left, int right, int target, int[] res) {
		if (left > right) {
			return ;
		}
		if (arr[left] == arr[right] && arr[left] == target) {
			res[0] = left;
			res[1] = right;
			return;
		}
		int mid = (left+right) / 2;
		if (target < arr[mid]) {
			core(arr, left, mid-1, target, res);
		} else if (target > arr[mid]) {
			core(arr, mid+1, right, target, res);
		} else {
			res[0] = mid;
			res[1] = mid;
			int t1 = mid;
			while (left < t1 && arr[t1] == arr[t1-1]) {
				t1--;
				res[0] = t1;
			}
			int t2 = mid;
			while (t2 < right && arr[t2] == arr[t2+1]) {
				t2++;
				res[1] = t2;
			}
			return;
		}
	}

}
