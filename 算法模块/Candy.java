package p48;

/**
 * 分发糖果    leetCode135
 * @author Guozhu Zhu
 * @date 2019/2/14
 * @version 1.0
 *
 */

public class Candy135 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] ratings = {1, 2, 2}; // answer eq 4
		int result = giveCandy(ratings);
		System.out.println(result);
	}
	
	public static int giveCandy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] candies = new int[ratings.length];
		candies[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i-1]) {
				candies[i] = candies[i-1] + 1;
			} else {
				candies[i] = 1;
			}
		}
		int result = candies[ratings.length-1];
		for (int i = ratings.length-2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i+1]) {
				cur = candies[i+1] + 1;
			}
			result += Math.max(candies[i], cur);
			candies[i] = cur;
		}
		return result;
	}

}
