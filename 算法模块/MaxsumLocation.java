package other;

/**
 * 最大子序列和(起始位置及结束位置)
 * @author Guozhu Zhu
 * @date 2018/12/08
 * @version 1.0
 *
 */
public class Demo01 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		//int[] arr = {1, 3, 2, 0, -1, 6, 1};
		int[] arr = {0, -2, 3, 5, -1, 2};
		int res = solution(arr);
		System.out.println(res);
	}
	
	public static int solution(int[] array) {
		int sum = array[0];
		int max = array[0];
		int start = 0 , curstart = 0;
		int end = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i]+sum > array[i]) {
				sum = array[i]+sum;
			} else {
				sum = array[i];
				curstart = i;
			}
			if (sum > max) {
				max = sum;
				start = curstart;
				end = i;
			} else {
				max = max;
			}
		    //sum = Math.max(array[i]+sum, array[i]);
		    //max = Math.max(sum, max);
		}
		System.out.println("start:" + start + "end:" + end);
		return max;
	}

}
