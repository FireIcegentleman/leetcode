/**
 * 2021/09/07
 * 旋转图像：原地旋转图像90°，不要使用另外的矩阵
 * */
public class _48_RotateImage {
    // 将矩阵分为左上、左下、右上、右下四个角，引入一个中间变量tmp辅助进行数字交换，唯一需要注意的是索引下标
    // 上述方案错误，应该先验证对角线折叠，再沿着x轴折叠
    public void rotate(int[][] matrix) {
        int tmp = 0 ;
        int n = matrix.length ;
        for(int i = 0 ; i < n - 1; i++){
            for(int j = 0 ; j < n  - i ; j++){
                // java不能直接交换 ，可以采用数组交换或者成员变量交换的方式
                tmp = matrix[i][j] ;
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i] ;
                matrix[n - 1 - j][n - 1 - i] = tmp ;
            }
        }
        for(int i = 0 ; i < n / 2 ; i++){
            for(int j = 0 ; j < n ; j++){
                tmp = matrix[i][j] ;
                matrix[i][j] = matrix[n - 1 - i][j] ;
                matrix[n - 1 - i][j] = tmp ;
            }
        }
        printMatrix(matrix) ;
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        _48_RotateImage obj = new _48_RotateImage() ;
        int[][] matrix = {{1 , 2} , {3 , 4}} ;
        printMatrix(matrix) ;
        obj.rotate(matrix);
    }

}
