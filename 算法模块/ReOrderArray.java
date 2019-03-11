package week03;

/**
 * 调整数组顺序，使奇数位于偶数前面并保持原有的稳定性(即原来前后位置)
 * @author Guozhu Zhu
 * @date 2019/3/11
 * @version 1.0
 *
 */
public class ReOrderArray01 {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[] array = {1, 3, 2, 4, 6, 5};
		reOrderArray(array);
		for (int i : array) {
			System.out.println(i);
		}
	}
	
	public static void reOrderArray(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if (array[j+1] % 2 != 0 && array[j] % 2 == 0) {
					int temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

}
