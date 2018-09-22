/**
* 岛屿的周长
* @author Guozhu Zhu
* @date 2018/9/22
* @version 1.0
*
*/
class Solution {
    
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                } 
                if (i == 0 || grid[i-1][j] == 0) {
                    res++;
                }
                if (j == 0 || grid[i][j-1] == 0) {
                    res++;
                }
                if (i == grid.length-1 || grid[i+1][j] == 0) {
                    res++;
                }
                if (j == grid[0].length-1 || grid[i][j+1] == 0) {
                    res++;
                }
            }
        }
        return res;
    }
    
}
