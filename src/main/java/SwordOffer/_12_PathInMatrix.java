package SwordOffer;

import java.util.Arrays;

/**
 * 2021/09/29
 * 矩阵中的路径
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 * */
public class _12_PathInMatrix {
    // DFS，深度优先遍历
    private boolean dfs(char[][] board, int i, int j, String word , int index , boolean[][] visited) {
        if (index == word.length()){
            return true ;
        }

        if (!isvalid(board , i , j) || board[i][j] != word.charAt(index) || visited[i][j]){
            return false ;
        }

        visited[i][j] = true ;
        boolean flag = dfs(board , i - 1 , j , word , index + 1 , visited) ||
                    dfs(board , i + 1 , j , word , index + 1 , visited) ||
                    dfs(board , i , j - 1 , word , index + 1 , visited) ||
                    dfs(board , i , j + 1 , word , index + 1 , visited) ;
        visited[i][j] = false ;
        return flag ;
    }

    private boolean isvalid(char[][] board, int i, int j) {
        int m = board.length ;
        int n = board[0].length ;

        if (i >= 0 && i <= m - 1 && j >= 0 && j <= n - 1){
            return true ;
        }else{
            return false ;
        }
    }

    public boolean exist(char[][] board, String word) {
        boolean flag = false ;
        int m = board.length ;
        int n = board[0].length ;

        boolean[][] visited = new boolean[m][n] ;

        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (board[i][j] == word.charAt(0)){
                    if(dfs(board , i , j , word , 0 , visited)){
                        return true ;
                    }

                }
            }
        }
        return flag ;
    }


    public static void main(String[] args) {
        _12_PathInMatrix obj = new _12_PathInMatrix() ;
        char[][] board = {{'A','B','C','E'} ,
                          {'S','F','C','S'} ,
                          {'A','D','E','E'}} ;
        String word = "ABCCED" ;
        System.out.println(obj.exist(board , word));
    }
}
