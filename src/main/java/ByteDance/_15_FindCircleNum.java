package ByteDance;
/**
 * 2021/11/1
 *
 * 省份数量
 *
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 *
 * 求解图的连通分量个数
 * */
public class _15_FindCircleNum {
    // 求图中有几个子图
    public int findCircleNum(int[][] isConnected) {
        // 图中一共有几个节点
        boolean[] visited = new boolean[isConnected.length] ;
        int count = 0 ;

        for (int i = 0 ; i < isConnected.length ; i++){
            if (!visited[i]){
                count++ ;
                // 一遍将所有与i节点连通的节点全部标记为true
                dfs(i , isConnected , visited) ;
            }
        }
        return count ;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true ;

        for (int j = 0 ; j < isConnected.length ; j++){
            if (!visited[j] && isConnected[i][j] == 1){
                dfs(j , isConnected , visited);
            }
        }
    }

    public static void main(String[] args) {
        _15_FindCircleNum obj = new _15_FindCircleNum() ;
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}} ;
        System.out.println(obj.findCircleNum(isConnected));
    }
}
