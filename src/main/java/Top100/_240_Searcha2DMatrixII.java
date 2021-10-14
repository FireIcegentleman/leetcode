/**
 * 2021/09/18
 *
 * 搜索二维矩阵II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *      1. 每行的元素从左到右升序排列。
 *      2. 每列的元素从上到下升序排列。
 * */
public class _240_Searcha2DMatrixII {
    // 高效的搜索算法。。。嗯。。。
    public boolean searchMatrix_binary(int[][] matrix, int target) {
        int m = matrix.length ;
        int n = matrix[0].length ;
        boolean flag = false ;

        // 对每一行进行二分查找
        for(int i = 0 ; i < m ; i++){
            flag = binarySearch(matrix , i , target) ;
            if (flag){
                return flag ;
            }
        }
        return flag ;
    }
    // 二分法在第i行寻找是否存在target
    private boolean binarySearch(int[][] matrix, int i, int target) {
        int left = 0 ;
        int right = matrix[i].length - 1 ;
        int mid ;
        boolean flag = false ;

        while(left <= right){
            mid = (left + right) / 2 ;
            if (matrix[i][mid] == target){
                return true ;
            }else if(matrix[i][mid] < target){
                left = mid  + 1 ;
            }else{
                right = mid - 1 ;
            }
        }
        return false ;
    }

    // 因为矩阵的行和列是排序的（分别从左到右和从上到下），所以在查看任何特定值时，我们可以修剪O(m)或O(n)元素。
    // 初始化一个指向矩阵左下角的(row,col)指针，然后直到找到目标并返回true位置：
    //   如果当前指向的值大于目标值，则向上移动一行，否则，如果当前指向的值小于目标值，则可以移动一列。
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length ;
        int n = matrix[0].length ;

        int row = m - 1 ;
        int col = 0 ;
        while(row >= 0 && col < n){
            if (matrix[row][col] == target){
                return true ;
            }else if(matrix[row][col] < target){
                col++ ;
            }else{
                row-- ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        _240_Searcha2DMatrixII obj = new _240_Searcha2DMatrixII() ;
        int[][] matrix = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}}  ;
        int target = 5 ;
        System.out.print(obj.searchMatrix(matrix , target));
    }
}
