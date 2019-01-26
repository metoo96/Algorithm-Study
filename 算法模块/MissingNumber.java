package p47;

import java.util.Arrays;

/**
 * MissingNumber
 * @author Guozhu Zhu
 * @date 2019/1/26
 * @version 1.0
 *
 */
public class MissingNumber {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] nums = new int[] {0, 1, 2, 4, 5, 6};
		int res = missingNumber1(nums);
		System.out.println(res);
	}
	
	//solution1: math
	public static int missingNumber(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return (nums.length)*(nums.length+1)/2 - sum;
	}
	
	//solution2: bin-search
	public static int missingNumber1(int[] nums) {
		Arrays.sort(nums);
		int l = 0;
		int r = nums.length-1;
		int m = 0;
		while (l < r) {
			m = (l+r) / 2;
			if (nums[m] > m) {
				r = m;
			} else {
				l = m+1;
			}
		}
		return r;
	}

}
