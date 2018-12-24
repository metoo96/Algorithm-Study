package pOffer;

/**
 * 二维数组中的查找
 * @author Guozhu Zhu
 * @date 2018/12/24
 * @version 1.0
 *
 */
public class Demo01 {
	
	/* =========== Test ========== */
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3},
			       {4, 5, 6},
			       {7, 8, 9}};
		boolean res01 = find01(5, arr);
		boolean res02 = find02(5, arr);
		boolean res03 = find03(5, arr);
		System.out.println(res01);
		System.out.println(res02);
		System.out.println(res03);
	}
	
	//method1    O(n) = nlogn
	public static boolean find01(int target, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int low = 0;
			int high = array[i].length-1;
			int mid = 0;
			while (low <= high) {
				mid = (low+high) / 2;
				if (array[i][mid] > target) {
					high = mid-1;
				} else if (array[i][mid] < target) {
					low = mid+1;
				} else {
					return true;
				}
			}
		}
		return false;
	}
	
	//method2
	public static boolean find02(int target, int[][] array) {
		int row = 0;
		int col = array[0].length-1;
		while (row < array.length && col >= 0) {
			if (array[row][col] > target) {
				col--;
			} else if (array[row][col] < target) {
				row++;
			} else {
				return true;
			}
		}
		return false;
	}
	
	//method3
	public static boolean find03(int target, int[][] array) {
		int row =  array.length-1;
		int col = 0;
		while (col < array[0].length && row >= 0) {
			if (array[row][col] < target) {
				col++;
			} else if (array[row][col] > target) {
				row--;
			} else {
				return true;
			}
		}
		return false;
	}

}
