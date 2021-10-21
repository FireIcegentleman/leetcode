package All;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2021/10/18
 *
 * Z字型变换
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * */
public class _6_Convert {
    public String convert_force(String s, int numRows) {
        int len = s.length() ;
        if (numRows == 1){
            return s ;
        }
        char[][] map = new char[numRows][len] ;

        for (int i = 0 ; i < numRows ; i++){
            for (int j = 0 ; j < len ; j++){
                map[i][j] = 'X' ;
            }
        }

        // 方向
        // 0 代表 向下
        // 1 代表 向左上
        int direction = 0 ;

        int row = 0 ;
        int col = 0 ;

        for (int i = 0 ; i < len ; i++){
            // 到达了最后一行
            if (row == numRows - 1){
                direction = 1 ;
            }
            // 到达了第一行
            if (row == 0){
                direction = 0 ;
            }
            // 向下运动的过程
            if(direction == 0){
                map[row][col] = s.charAt(i) ;
                row++ ;
            }else if(direction == 1){
                //向左上运动的过程
                map[row][col] = s.charAt(i) ;
                row-- ;
                col++ ;
            }
        }
        StringBuilder str = new StringBuilder() ;
        for (int i = 0 ; i < numRows ; i++){
            for (int j = 0 ; j < len ; j++){
                if (map[i][j] != 'X'){
                    str.append(map[i][j]) ;
                }
            }
        }
        return str.toString() ;
    }

    // 本质上到位置后反转
    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s ;
        }

        List<StringBuilder> rows = new ArrayList<StringBuilder>() ;
        for (int i = 0 ; i < numRows ; i++){
            rows.add(new StringBuilder()) ;
        }
        // 正向
        int index = 0 , flag = -1 ;
        char[] charArray = s.toCharArray() ;
        for (char c : charArray){
            rows.get(index).append(c) ;
            if (index == 0 || index == numRows - 1){
                flag = -flag ;
            }
            index += flag ;
        }
        StringBuilder res = new StringBuilder() ;
        for (int i = 0 ; i < numRows ; i++){
            res.append(rows.get(i)) ;
        }
        return res.toString() ;
    }
    public static void main(String[] args) {
        _6_Convert obj = new _6_Convert() ;
        String s = "AB" ;
        int numRows = 1 ;
        System.out.println(obj.convert(s , numRows));
    }
}
