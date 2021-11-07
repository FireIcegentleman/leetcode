package Top100;

/**
 * 2021/09/16
 * 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * */
public class _200_NumberofIsland {
    // 深度优先遍历
    private void dfs(char[][] grid, int i, int j) {
        // 超出边界
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return ;
        }

        // 遍历至四条边向外，都再没有未被访问过的节点了
        if(grid[i][j] != '1'){
            return ;
        }

        grid[i][j] = '2' ;

        dfs(grid , i - 1 , j);
        dfs(grid , i + 1 , j);
        dfs(grid , i , j - 1);
        dfs(grid , i , j + 1);
    }

    // 深度优先遍历DFS
    public int numIslands(char[][] grid) {
        int res = 0 ;

        for (int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    dfs(grid , i , j ) ;
                    res ++ ;
                }
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _200_NumberofIsland obj = new _200_NumberofIsland() ;
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}} ;
        System.out.println(obj.numIslands(grid));
    }
}
/**
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * */
