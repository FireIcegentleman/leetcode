package All;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/10/27
 *
 * 解数独
 *
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * */
public class _37_SolveSudoku {
    /**
     * 可以考虑按照“行优先”的顺序依次枚举每一个空白格中填的数字，通过递归+回溯的方法枚举所有可能的填法。
     * 当递归到最后一个空白格后，如果仍然没有冲突，说明我们找到了答案；在递归的过程中，如果当前的空白格不能填充任何一个数字，那么进行回溯
     * */
    // 第i行是否出现过数字j
    public boolean[][] line = new boolean[9][9] ;
    // 第i列是否出现过数字j
    public boolean[][] column = new boolean[9][9] ;
    // 记录某块内是否出现过数字j
    public boolean[][][] block = new boolean[3][3][9] ;
    public boolean vaild = false ;
    // 记录当前的空白格
    public List<int[]> spaces = new ArrayList<>() ;
    public void solveSudoku(char[][] board) {
        // 对声明的数据结构赋值，如果是.说明是空值，则记录到空白格列表里
        // 如果是数字，则更新三个记录表
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                if (board[i][j] == '.'){
                    spaces.add(new int[]{i , j}) ;
                }else{
                    int digit = board[i][j] - '0' - 1 ;
                    line[i][digit] = true ;
                    column[j][digit] = true ;
                    block[i / 3][j / 3][digit] = true ;
                }
            }
        }

        dfs(board , 0) ;
    }

    // 递归枚举，回溯过程
    // pos表示当前的第pos个空白格
    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()){
            vaild = true ;
            return;
        }

        int[] space = spaces.get(pos) ;

        int i = space[0] , j = space[1] ;

        for (int digit = 0 ; digit < 9 && !vaild ; digit++){
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]){
                line[i][digit] = true ;
                column[j][digit] = true ;
                block[i / 3][j / 3][digit] = true ;

                board[i][j] = (char)(digit + '0' + 1) ;
                dfs(board , pos + 1);

                line[i][digit] = false ;
                column[j][digit] = false ;
                block[i / 3][j / 3][digit] = false ;
            }
        }
    }

    public static void main(String[] args) {
        _37_SolveSudoku obj = new _37_SolveSudoku() ;
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}} ;

        obj.solveSudoku(board);

        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
