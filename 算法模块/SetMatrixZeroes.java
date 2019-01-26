package p47;

/**
 * SetMatrixZeros
 * @author Guozhu Zhu
 * @date 2019/1/26
 * @version 1.0
 *
 */
public class SetMatrixZeros {
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
		setMatrixZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void setMatrixZeroes(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColumnZero = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColumnZero = true;
				break;
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstColumnZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if (firstRowZero) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
	}

}
