package All;

/**
 * 2021/11/16
 *
 * 最后一个单词的长度
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * */
public class _59_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n] ;

        int up = 0 , down = n - 1 ;
        int left = 0 , right = n - 1 ;

        int num = 1 , tar = n * n ;

        // 直接把一轮做成完整的
        while (num <= tar){
            for (int i = left ; i <= right ; i++){
                res[up][i] = num++ ;
            }
            up++ ;
            for (int i = up ; i <= down ; i++){
                res[i][right] = num++ ;
            }
            right-- ;
            for (int i = right ; i >= left ; i--){
                res[down][i] = num++ ;
            }
            down-- ;
            for (int i = down ; i >= up ; i--){
                res[i][left] = num++ ;
            }
            left++ ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _59_GenerateMatrix obj = new _59_GenerateMatrix() ;
        int n = 3 ;

        int[][] res = obj.generateMatrix(n) ;

        for (int i = 0 ; i < res.length ; i++){
            for (int j = 0 ; j < res[i].length ; j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
