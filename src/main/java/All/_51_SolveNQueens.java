package All;

import java.util.*;

/**
 * 2021/11/15
 *
 * N皇后
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * */
public class _51_SolveNQueens {
    // 任何两个皇后都不能处于同一条横行、纵行或者斜线上
    // 基于集合的回溯
    // 使用一个数组记录每行放置的皇后的列下标，依次在每一行放置一个皇后。每次新放置的皇后都不能和已经放置的皇后之间有攻击：
    // 即新放置的皇后不能和任何一个已经放置的皇后在同一列以及同一条斜线上，并更新数组中的当前行的皇后列下标。
    // 当N个皇后都放置完毕，则找到一个可能的解。当找到一个可能的解之后，将数组转换成表示棋盘状态的列表，并将该棋盘状态的列表加入返回列表。
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>() ;
        // 存储每行的皇后位置
        int[] queues = new int[n] ;
        Arrays.fill(queues , -1);

        Set<Integer> columns = new HashSet<>() ;
        // 斜率为负的对角线
        Set<Integer> diag1 = new HashSet<>() ;
        // 斜率为正的对角线
        Set<Integer> diag2 = new HashSet<>() ;

        backtrack(res , queues , n , 0 , columns , diag1 , diag2) ;
        return res ;
    }

    private void backtrack(List<List<String>> res, int[] queues, int n, int row, Set<Integer> columns, Set<Integer> diag1, Set<Integer> diag2) {
        // 遍历到最后一行
        if (row == n){
            List<String> board = generateboard(queues , n) ;
            res.add(board) ;
        }else{
            for (int i = 0 ; i < n ; i++){
                // 同一列有皇后
                if (columns.contains(i)){
                    continue;
                }

                int d1 = row - i ;
                if (diag1.contains(d1)){
                    continue;
                }

                int d2 = row + i ;
                if (diag2.contains(d2)){
                    continue;
                }

                queues[row] = i ;
                columns.add(i) ;
                diag1.add(d1) ;
                diag2.add(d2) ;
                // 递归下一行
                backtrack(res , queues , n , row + 1 , columns , diag1 , diag2);
                queues[row] = -1 ;
                columns.remove(i) ;
                diag1.remove(d1) ;
                diag2.remove(d2) ;
            }
        }
    }

    private List<String> generateboard(int[] queues, int n) {
        List<String> res = new ArrayList<>() ;

        for (int i = 0 ; i < n ; i++){
            char[] row = new char[n] ;
            Arrays.fill(row , '.');
            row[queues[i]] = 'Q' ;
            // 注意这里需要使用 new String
            res.add(new String(row)) ;
        }

        return res ;
    }

    public static void main(String[] args) {
        _51_SolveNQueens obj = new _51_SolveNQueens() ;
        int n = 4 ;

        List<List<String>> res = obj.solveNQueens(n) ;

        for (int i = 0 ; i < res.size() ; i++){
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
