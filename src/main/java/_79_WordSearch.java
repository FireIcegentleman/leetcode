import java.util.Arrays;

/**
 * 2021/09/10
 * 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * */

public class _79_WordSearch {
    private boolean dfs(char[][] board, int i, int j, int cur, String word , boolean[][] visited) {
        if(cur == word.length()){
            return true ;
        }
        int m = board.length ;
        int n = board[0].length ;

        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j] != word.charAt(cur)){
            return false ;
        }

        visited[i][j] = true ;
        boolean res =  dfs(board , i - 1 , j , cur + 1 , word , visited)
                    || dfs(board , i + 1 , j , cur + 1 , word , visited)
                    || dfs(board , i , j - 1, cur + 1 , word , visited)
                    || dfs(board , i , j + 1, cur + 1 , word , visited) ;
        visited[i][j] = false ;
        return res ;
    }

    private boolean exist(char[][] board, String word) {
        // 分步骤进行判断，如果遇到没有四周的满足条件，则返回false，否则继续进行DFS
        int m = board.length ;
        int n = board[0].length ;
        if(m == 0 || n == 0){
            return false ;
        }
        boolean flag = false ;
        boolean[][] visited = new boolean[m][n] ;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false ;
            }
        }
        // 首先在字符数组中找到满足起始位置
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(dfs(board, i, j, 0 , word ,visited)){
                    return true ;
                }
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        _79_WordSearch obj = new _79_WordSearch() ;
        char[][] boarad = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}} ;
        String word = "ABCB" ;
        System.out.print(obj.exist(boarad , word));
    }
}
