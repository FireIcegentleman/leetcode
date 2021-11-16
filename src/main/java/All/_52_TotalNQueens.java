package All;

import org.w3c.dom.ls.LSException;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 2021/11/15
 *
 * N皇后II
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * */
public class _52_TotalNQueens {
    // 先按照前一个问题的答案写一遍，不过肯定有更优秀的写法
    public int totalNQueens(int n) {
        /*List<List<String>> res = new ArrayList<>() ;
        int[] queues = new int[n] ;

        Arrays.fill(queues , -1);*/

        HashSet<Integer> columns = new HashSet<>() ;
        HashSet<Integer> diag1 = new HashSet<>() ;
        HashSet<Integer> diag2 = new HashSet<>() ;

        return dfs(n , 0 , columns , diag1 , diag2) ;
    }

    private int dfs(int n, int row, HashSet<Integer> columns, HashSet<Integer> diag1, HashSet<Integer> diag2) {
        if (row == n){
            return 1 ;
        }else {
            int count = 0 ;
            for (int i = 0 ; i < n ; i++){
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

                columns.add(i) ;
                diag1.add(d1) ;
                diag2.add(d2) ;
                count += dfs(n , row + 1 , columns , diag1 , diag2) ;
                columns.remove(i) ;
                diag1.remove(d1) ;
                diag2.remove(d2) ;
            }
            return count ;
        }
    }

    private void dfs_memory(List<List<String>> res, int[] queues, int n, int row, HashSet<Integer> columns, HashSet<Integer> diag1, HashSet<Integer> diag2) {
        if (row == n){
            List<String> board = generate(queues , n) ;
            res.add(board) ;
        }else{
            // 循环所有行
            for (int i = 0 ; i < n ; i++){
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
                //dfs(res , queues , n , row + 1 , columns , diag1 , diag2);
                queues[row] = -1 ;
                columns.remove(i) ;
                diag1.remove(d1) ;
                diag2.remove(d2) ;
            }
        }
    }

    private List<String> generate(int[] queues, int n) {
        List<String> res = new ArrayList<>() ;

        for (int i = 0 ; i < n ; i++){
            char[] row = new char[n] ;
            Arrays.fill(row , '.');
            row[queues[i]] = 'Q' ;
            res.add(new String(row)) ;
        }

        return res ;
    }

    public static void main(String[] args) {
        _52_TotalNQueens obj = new _52_TotalNQueens() ;
        int n = 4 ;

        System.out.println(obj.totalNQueens(n));
    }
}
