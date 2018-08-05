package p19;

/**
 * 两个数相加等于target(采用两端夹逼的算法思想)
 * Example: 
 * Input: [2, 7, 12, 15](有序数组) target = 9
 * Ouput: [1, 2](索引地址)
 * @author Guozhu Zhu
 * @date 2018/8/5
 * @version 1.0
 *
 */
public class TwoSum {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 7, 12, 15};
		int[] res = twoSum(arr, 9);
		for (int i : res) {
			System.out.println(i);
		}
	}
	
	//两端夹逼方式求解:
	public static int[] twoSum(int[] numbers, int target) {
		if (numbers.length < 2) {
			return null;
		}
		int[] res = new int[2];
		int start = 0;
		int end = numbers.length-1;
		while (start < end) {
			if (numbers[start] + numbers[end] == target) {
				res[0] = start;
				res[1] = end;
				return res;
			} else if (numbers[start] + numbers[end] < target) {
				start++;
			} else {
				end--;
			}
		}
		return res;
	}

}
