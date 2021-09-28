package SwordOffer;
/**
 * 2021/09/28
 *
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * */
public class _4_NumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length ;
        if (m == 0){
            return false ;
        }

        int n = matrix[0].length ;


        int i = m - 1 ;
        int j = 0 ;


        while (i >= 0 && j < n){
            if (matrix[i][j] == target){
                return true ;
            }else if (matrix[i][j] < target){
                j++ ;
            }else{
                i-- ;
            }
        }
        return false ;
    }
    public static void main(String[] args) {
        _4_NumberIn2DArray obj = new _4_NumberIn2DArray() ;
        int[][] matrix = {{1,   4,  7, 11, 15} ,
                          {2,   5,  8, 12, 19} ,
                          {3,   6,  9, 16, 22} ,
                          {10, 13, 14, 17, 24} ,
                          {18, 21, 23, 26, 30}} ;
        int target = 20 ;
        System.out.println(obj.findNumberIn2DArray(matrix , target));
    }
}
