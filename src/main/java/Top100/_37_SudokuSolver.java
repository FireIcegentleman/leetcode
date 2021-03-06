package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/6/17
 * 解数独
 *
 * 递归 + 回溯法
 **/
public class _37_SudokuSolver {
    private boolean[][] line = new boolean[9][9] ;
    private boolean[][] column = new boolean[9][9] ;
    private boolean[][][] block = new boolean[3][9][9] ;
    private boolean valid = false ;
    private List<int[]> spaces = new ArrayList<int[]>() ;

    public void solveSudoku(char[][] board) {
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == '.'){
                    spaces.add(new int[]{i,j}) ;
                }else{
                    int digit = board[i][j] - '0' - 1 ;
                    line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true ;
                }
            }
        }

        dfs(board , 0) ;
        // 结果打印
        printSudoku(board) ;
    }

    private void dfs(char[][] board, int pos) {
        if(pos == spaces.size()){
            valid = true ;
            return ;
        }

        int[] space = spaces.get(pos) ;
        int i = space[0] , j = space[1] ;
        for(int digit = 0 ; digit < 9 && !valid; digit++){
            if(!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true ;
                board[i][j] = (char)(digit + '0' + 1);
                dfs(board,pos + 1);
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false ;
            }
        }
    }

    private void printSudoku(char[][] board) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
      _37_SudokuSolver obj = new _37_SudokuSolver() ;
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
                /*{{'.','.','.','.','.','.','5','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'9','3','.','.','2','.','4','.','.'},
                        {'.','.','7','.','.','.','3','.','.'},
                        {'.','.','.','.','.','.','.','.','.'},
                        {'.','.','.','3','4','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','.'},
                        {'.','.','.','.','.','5','2','.','.'}};*/// 倒数第二个3*3中有两个‘3’

        obj.solveSudoku(board);
    }
}
