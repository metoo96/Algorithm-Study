package p48;

/**
 * TrappingRainWater
 * @author Guozhu Zhu
 * @date 2019/2/14
 * @version 1.0
 *
 */
public class TrappingRainWater {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int res = trappingRainWater(arr);
		System.out.println(res);    // res eq 6
	}
	
	public static int trappingRainWater(int[] heights) {
		int result = 0;
		if (heights == null || heights.length <= 2) {
			return result;
		}
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];
		//left to right
		int max = heights[0];
		left[0] = heights[0];
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] < max) {
				left[i] = max;
			} else {
				left[i] = heights[i];
				max = heights[i];
			}
		}
		
		max = heights[heights.length-1];
		right[heights.length-1] = heights[heights.length-1];
		for (int i = heights.length-2; i >= 0; i--) {
			if (heights[i] < max) {
				right[i] = max;
			} else {
				right[i] = heights[i];
				max = heights[i];
			}
		}
		for (int i = 0; i < heights.length; i++) {
			result += Math.min(left[i], right[i]) - heights[i];
		}
		return result;
	}

}
