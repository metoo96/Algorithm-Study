/**
* 岛屿的个数算法实现
* @author Guozhu Zhu
* @date 2018/9/22
* @version 1.0
*
*/
class Solution {
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
              if (grid[i][j] == '1') {
                  IslandsCore(i, j, grid);
                  count++;
              }
            }
        }
        return count;
    }
    
    public void IslandsCore(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return ;
        }
        grid[i][j] = 2;
        IslandsCore(i+1, j, grid);
        IslandsCore(i-1, j, grid);
        IslandsCore(i, j-1, grid);
        IslandsCore(i, j+1, grid);
    }
    
}
