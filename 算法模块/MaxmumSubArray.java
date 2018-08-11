package p25;

/**
 * 动态规划问题(连续子数组)
 * Maximum subarray
 * @author Guozhu Zhu
 * @date 2018/8/11
 * @version 1.0
 *
 */
public class Test03 {
	
	public static void main(String[] args) {
		int[] arr = {1, -1, 3, 9, 7, 0};
		System.out.println(solution1(arr));
	}
	
	public static int solution1(int[] arr) {
		int ans = arr[0];
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum = Integer.max(arr[i]+sum, arr[i]);
			if (sum > ans) {
				ans = sum;
			}
		}
		return ans;
	}
	
}
