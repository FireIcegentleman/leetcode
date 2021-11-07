package Top100;

import java.util.Arrays;

/**
 * 2021/6/16
 * 判断当前的数独状态是否合法
 * 直接怼暴力解法，因为每次的输入数据最多也就是一个9*9的二维数组
 */

public class _36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Boolean res = true ;
        int m = board.length ; // 行数
        int n = board[0].length ; // 列数
        int[] tmp = new int[10] ;
        Arrays.fill(tmp , 0) ;

        // 行判断
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] != '.' && tmp[board[i][j] - '0'] == 0){
                    tmp[board[i][j] - '0']++;
                }else if(board[i][j] != '.' && tmp[board[i][j] - '0'] > 0){
                    return false ;
                }
            }
            Arrays.fill(tmp , 0) ;
        }
        // 每次判断后将标识数组清零
        Arrays.fill(tmp , 0) ;

        // 列判断
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[j][i] != '.' && tmp[board[j][i] - '0'] == 0){
                    tmp[board[j][i] - '0']++;
                }else if(board[j][i] != '.' && tmp[board[j][i] - '0'] > 0){
                    return false ;
                }
            }
            Arrays.fill(tmp , 0) ;
        }
        Arrays.fill(tmp , 0) ;

        // 九宫格判断
        int row_flag = 0;

        for( ; row_flag < m ; row_flag +=3){
            // 注意每次需要再将列指标清零
            for(int col_flag = 0 ; col_flag < n ; col_flag += 3){
                for(int i = row_flag ; i < row_flag + 3 ; i++){
                    for(int j = col_flag ; j < col_flag + 3 ; j++){
                        if(board[i][j] != '.' && tmp[board[i][j] - '0'] == 0){
                            tmp[board[i][j] - '0']++;
                        }else if(board[i][j] != '.' && tmp[board[i][j] - '0'] > 0){
                            return false ;
                        }
                    }
                }
                Arrays.fill(tmp , 0) ;
            }

        }

        return res ;
    }
    public static void main(String[] args) {
        _36_ValidSudoku obj = new _36_ValidSudoku() ;
        char[][] board = /*{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};*/
                       {{'.','.','.','.','.','.','5','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'9','3','.','.','2','.','4','.','.'},
                        {'.','.','7','.','.','.','3','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','3','4','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','.'},
                        {'.','.','.','.','.','5','2','.','.'}};// 倒数第二个3*3中有两个‘3’

        System.out.println(obj.isValidSudoku(board));
    }
}
