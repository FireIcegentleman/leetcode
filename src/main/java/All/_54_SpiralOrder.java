package All;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/11/16
 *
 * 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * */
public class _54_SpiralOrder {
    // 按照顺时针螺旋顺序，返回所有的元素
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length ;
        int n = matrix[0].length ;

        List<Integer> res = new ArrayList<>() ;
        int up = 0 , down = m - 1 ;
        int left = 0 , right = n - 1 ;

        // 指示当前应该往哪边走，0123分别表示向右、向下、向左、向上
        int direct = 0 ;
        // 当前矩阵中一共有多少个数字
        int count = m * n ;
        // 只有当遍历到最后一个位置的时候循环才停止
        while (count > 0){
            if (direct == 0){
                for (int i = left ; i <= right && count > 0 ; i++){
                    res.add(matrix[up][i]) ;
                    count-- ;
                }
                up++ ;
                direct = 1 ;
            }else if(direct == 1){
                for (int i = up ; i <= down && count > 0 ; i++){
                    res.add(matrix[i][right]) ;
                    count-- ;
                }
                right-- ;
                direct = 2 ;
            }else if(direct == 2){
                for (int i = right ; i >= left && count > 0 ; i--){
                    res.add(matrix[down][i]) ;
                    count-- ;
                }
                down-- ;
                direct = 3 ;
            }else {
                for (int i = down ; i >= up && count > 0 ; i--){
                    res.add(matrix[i][left]) ;
                    count-- ;
                }
                left++ ;
                direct = 0 ;
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        _54_SpiralOrder obj = new _54_SpiralOrder() ;
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        List<Integer> res = obj.spiralOrder(matrix) ;

        for (int i = 0 ; i < res.size() ; i++){
            System.out.print(res.get(i) + ",");
        }
    }
}
