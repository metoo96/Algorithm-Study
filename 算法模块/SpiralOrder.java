/**
* 螺旋矩阵
* @author Guozhu Zhu
* @date 2018/9/27
* @version 1.0
*
*/
class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return resList;
        }
        int xStart = 0;
        int xEnd = matrix[0].length-1;
        int yStart = 0;
        int yEnd = matrix.length-1;
        while (xStart <= xEnd && yStart <= yEnd) {
            for (int i = xStart; i  <= xEnd; i++) {
                resList.add(matrix[yStart][i]);
            }
            if (yEnd > yStart) {
                for (int i = yStart+1; i <= yEnd; i++) {
                    resList.add(matrix[i][xEnd]);
                }
            }
            if (yEnd > yStart && xStart < xEnd) {
                for (int i = xEnd-1; i >= xStart; i--) {
                    resList.add(matrix[yEnd][i]);
                }
            }
            if (yEnd > yStart+1 && xStart < xEnd) {
                for (int i = yEnd-1; i >= yStart+1; i--) {
                    resList.add(matrix[i][xStart]);
                }
            }
            xStart++;
            yStart++;
            xEnd--;
            yEnd--;
        }
        return resList;
    }
    
}
