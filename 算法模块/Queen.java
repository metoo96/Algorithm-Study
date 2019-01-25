package p47;

/**
 * 八皇后问题
 * @author Guozhu Zhu
 * @date 2019/1/25
 * @version 1.0
 *
 */
public class Queen {
	
	public static int[][] arr = new int[8][8]; //棋盘
	public static int map = 0; //存储方案数量
	
	public static void main(String[] args) {
		findQueen(0);
		System.out.println(map);
	}
	
	public static void findQueen(int i) {
		if (i > 7) {
			map++;
			print();
			return;
		}
		//深度回溯，递归算法
		for (int m = 0; m < 8; m++) {
			if (check(i, m)) {
				arr[i][m] = 1;
				findQueen(i+1);
				arr[i][m] = 0;
			}
		}
	}
	
	public static boolean check(int k, int j) {
		//检查行列冲突
		for (int i = 0; i < 8; i++) {
			if (arr[i][j] == 1) {
				return false;
			}
		}
		//检查左对角线
		for (int i = k-1, m = j-1; i >= 0 && m >= 0; i--, m--) {
			if (arr[i][m] == 1) {
				return false;
			}
		}
		//检查右对角线
		for (int i = k-1, m = j+1; i >= 0 && m <= 7; i--, m++) {
			if (arr[i][m] == 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void print() {
		for (int i = 0; i < 8; i++) {
			for (int m = 0; m < 8; m++) {
				if (arr[i][m] == 1) {
					System.out.print("0");
				} else {
					System.out.print("+");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	

}
