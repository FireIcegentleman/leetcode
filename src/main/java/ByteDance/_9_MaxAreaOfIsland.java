package ByteDance;

/**
 * 2021/10/30
 *
 * 岛屿的最大面积
 *
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * */
public class _9_MaxAreaOfIsland {
    // 返回岛屿的最大面积
    // DFS
    public int res ;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;
        res = 0 ;

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                res = Math.max(res , dfs(grid , i , j)) ;
            }
        }
        return res ;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return 0;
        }

        // 这个格子被访问过
        grid[i][j] = 0 ;
        int[] di = {1,-1,0,0} ;
        int[] dj = {0,0,1,-1} ;

        int ans = 1 ;
        for (int k = 0 ; k < 4 ; k++){
            int next_i = i + di[k] ;
            int next_j = j + dj[k] ;
            ans += dfs(grid , next_i , next_j) ;
        }
        return ans ;
    }


    public static void main(String[] args) {
        _9_MaxAreaOfIsland obj = new _9_MaxAreaOfIsland() ;
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}} ;
        /*int[][] grid = {{1,1,0,0,0},
                        {1,1,0,0,0},
                        {0,0,0,1,1},
                        {0,0,0,1,1}} ;*/
        System.out.println(obj.maxAreaOfIsland(grid));
    }
}
