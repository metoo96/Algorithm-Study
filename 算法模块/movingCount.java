package p33;

/**
 * 机器人的运动范围
 * @author Guozhu Zhu
 * @date 2018/8/26
 * @version 1.0
 *
 */
public class Test01 {
	
	/*========== Test ==========*/
	
	/* 数位之和图示:
	 * 
	 *    | 0 | 1 | 2 | 3 |
	 *    -----------------
	 *    | 1 | 2 | 3 | 4 |
	 *    -----------------
	 *    | 2 | 3 | 4 | 5 |
	 *    -----------------
	 *    | 3 | 4 | 5 | 6 |
	 */
	public static void main(String[] args) {
		int res = movingCount(4, 4, 4);
		System.out.println(res);
	}
	
	public static int movingCount(int threshold, int rows, int cols) {
		//1. 参数校验
		if (threshold <= 0 || rows <= 0 || cols <= 0) {
			return 0;
		}
		//2. 标记设置
		boolean[][] visitFlag = new boolean[rows][cols];
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < cols; j++) {
				visitFlag[i][j] = false;
			}
		}
		//3. 搜索
		return movingCountCore(0, 0, rows, cols, threshold, visitFlag);
	}
	
	public static int movingCountCore(int i, int j, int rows, int cols, int threshold, boolean[][] visitFlag) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i)+numSum(j) > threshold || visitFlag[i][j] == true) {
			return 0;
		}
		visitFlag[i][j] = true;
		return         1+movingCountCore(i+1, j, rows, cols, threshold, visitFlag) +
				 movingCountCore(i-1, j, rows, cols, threshold, visitFlag) +
				 movingCountCore(i, j+1, rows, cols, threshold, visitFlag) +
				 movingCountCore(i, j-1, rows, cols, threshold, visitFlag);
	}
	
	//数位之和
	public static int numSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}

}
