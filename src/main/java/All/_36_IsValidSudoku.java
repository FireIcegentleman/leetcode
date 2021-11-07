package All;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 2021/10/27
 *
 * 有效的数独
 *
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * */
public class _36_IsValidSudoku {
    // 判断数度是否有效
    public boolean isValidSudoku(char[][] board) {
        int row = board.length ;
        int col = board[0].length ;
        int[] tmp = new int[10] ;
        Arrays.fill(tmp , 0) ;

        // 行判断
        for (int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                if (board[i][j] != '.' && tmp[board[i][j] - '0'] == 0){
                    tmp[board[i][j] - '0']++ ;
                }else if(board[i][j] != '.' && tmp[board[i][j] - '0'] > 0){
                    return false ;
                }
            }
            Arrays.fill(tmp , 0);
        }
        // 列判断
        for (int j = 0 ; j < col ; j++){
            for (int i = 0 ; i < row ; i++){
                if (board[i][j] != '.' && tmp[board[i][j] - '0'] == 0){
                    tmp[board[i][j] - '0']++ ;
                }else if(board[i][j] != '.' && tmp[board[i][j] - '0'] > 0){
                    return false ;
                }
            }
            Arrays.fill(tmp , 0);
        }

        // 九宫格判断
        int row_unit = 0 ;
        for (; row_unit < row ; row_unit += 3){
            for (int col_unit = 0 ; col_unit < col ; col_unit += 3){
                for (int i = row_unit ; i < row_unit + 3 ; i++){
                    for (int j = col_unit ; j < col_unit + 3 ; j++){
                        if (board[i][j] != '.' && tmp[board[i][j] - '0'] == 0){
                            tmp[board[i][j] - '0']++ ;
                        }else if(board[i][j] != '.' && tmp[board[i][j] - '0'] > 0){
                            return false ;
                        }
                    }
                }
                Arrays.fill(tmp , 0);
            }
        }

        return true ;
    }
    public static void main(String[] args) {
        _36_IsValidSudoku obj = new _36_IsValidSudoku() ;
        char[][] board = {{'.','.','.','.','5','.','.','1','.'},
                          {'.','4','.','3','.','.','.','.','.'},
                          {'.','.','.','.','.','3','.','.','1'},
                          {'8','.','.','.','.','.','.','2','.'},
                          {'.','.','2','.','7','.','.','.','.'},
                          {'.','1','5','.','.','.','.','.','.'},
                          {'.','.','.','.','.','2','.','.','.'},
                          {'.','2','.','9','.','.','.','.','.'},
                          {'.','.','4','.','.','.','.','.','.'}};
        System.out.println(obj.isValidSudoku(board));
    }
}
