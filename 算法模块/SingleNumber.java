package p23;

/**
 * [说明]
 * 在数组中返回数组中唯一一个出现一次的数组元素，其他的数组元素都出现两次
 * @author Guozhu Zhu
 * @date 2018/8/8
 * @version 1.0
 *
 */
public class Test02 {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 1, 7};
		System.out.println(singleNumber(arr));
	}
	
	public static int singleNumber(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}

}
