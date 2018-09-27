class Solution {
    
    public int[][] generateMatrix(int n) {
        int[][] resArr = new int[n][n];
        int value = 0;
        int xStart = 0;
        int xEnd = n-1;
        int yStart = 0;
        int yEnd = n-1;
        while (xStart <= xEnd && yStart <= yEnd) {
            for (int i = xStart; i <= xEnd; i++) {
                resArr[yStart][i] = ++value;
            }
            if (yEnd > yStart) {
                for (int i = yStart+1; i <= yEnd; i++) {
                    resArr[i][xEnd] = ++value;
                }
            }
            if (yEnd > yStart && xEnd > xStart) {
                for (int i = xEnd-1; i >= xStart; i--) {
                    resArr[yEnd][i] = ++value;
                }
            }
            if (yEnd > yStart+1 && xEnd > xStart) {
                for (int i = yEnd-1; i >= yStart+1; i--) {
                    resArr[i][xStart] = ++value;
                }
            }
            xStart++;
            xEnd--;
            yStart++;
            yEnd--;
        }
        return resArr;
     }
     
}