package All;

import java.util.Arrays;

/**
 * 2021/11/14
 *
 * 旋转图像
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * */
public class _48_Rotate {
    // 旋转图像
    // 沿轴翻转
    public void rotate(int[][] matrix) {
        int n = matrix.length ;

        // 先沿x轴翻转，然后再沿斜率为-1的对角线翻转
        for (int i = 0 ; i < n / 2 ; i++){
            for (int j = 0 ; j < n ; j++){
                swap(matrix , i , j , n - i - 1, j) ;
            }
        }

        // 沿斜率为-1的对角线翻转
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < i ; j++){
                swap(matrix , i , j , j , i);
            }
        }
    }

    // 数组位置交换
    public void swap(int[][] matrix , int ai , int aj , int bi , int bj){
        int tmp = matrix[ai][aj] ;
        matrix[ai][aj] = matrix[bi][bj] ;
        matrix[bi][bj] = tmp ;
    }
    public static void main(String[] args) {
        _48_Rotate obj = new _48_Rotate() ;
        int[][] matrix = {{1,2,3} , {4,5,6} , {7,8,9}} ;

        obj.rotate(matrix);

        System.out.println(Arrays.toString(matrix));
    }
}
