package SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/10/02
 *
 * 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * */
public class _29_SprialOrderPrint {
    // 顺时针打印矩阵
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0] ;
        }
        if (matrix[0].length == 0){
            return matrix[0] ;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length] ;
        List<Integer> list = new ArrayList<>() ;
        int upboard = 0 ;
        int downboard = matrix.length ;
        int leftboard = 0 ;
        int rightboard = matrix[0].length ;

        while (upboard <= downboard && leftboard <= rightboard){
            // 上横行
            for (int i = leftboard ; i < rightboard ; i++){
                if (!visited[upboard][i]){
                    list.add(matrix[upboard][i]) ;
                    visited[upboard][i] = true ;
                }
            }
            // 右列
            for (int i = upboard ; i < downboard ; i++){
                if (!visited[i][rightboard - 1]){
                    list.add(matrix[i][rightboard - 1]) ;
                    visited[i][rightboard - 1] = true ;
                }
            }
            // 下行
            for (int i = rightboard - 1 ; i >= leftboard ; i--){
                if (!visited[downboard - 1][i]){
                    list.add(matrix[downboard - 1][i]) ;
                    visited[downboard - 1][i] = true ;
                }
            }
            // 左列
            for (int i = downboard - 1 ; i >= upboard ; i--){
                if (!visited[i][leftboard]){
                    list.add(matrix[i][leftboard]) ;
                    visited[i][leftboard] = true ;
                }
            }
            upboard++ ;
            downboard-- ;
            leftboard++ ;
            rightboard-- ;
        }

        int len = list.size() ;
        int[] res = new int[len] ;

        for (int i = 0 ; i < len ; i++){
            res[i] = list.get(i) ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _29_SprialOrderPrint obj = new _29_SprialOrderPrint() ;
        int[][] matirx = {{1 , 2 , 3 , 4},
                          {5 , 6 , 7 , 8},
                          {9 , 10, 11, 12}} ;
        System.out.println(Arrays.toString(obj.spiralOrder(matirx)));
    }
}
