class Solution {
    
    public int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int res = IslandCore(i, j, grid);
                    if (res > max) {
                        max = res;
                    }
                }
            }
        }
        return max;
    }
    
    public int IslandCore(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        } 
        grid[i][j] = 2;
        return 1+IslandCore(i+1, j, grid) + IslandCore(i-1, j, grid) + IslandCore(i, j-1, grid) + IslandCore(i, j+1, grid);
    }
    
}