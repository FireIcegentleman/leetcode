/**
 * 2021/1/20
 * leetcode 9
 * untime: 57 ms, faster than 7.58% of Java online submissions for ZigZag Conversion.
 * Memory Usage: 44.4 MB, less than 13.22% of Java online submissions for ZigZag Conversion.
 * 暴力解法通过
 * 示例代码按行迭代
 */
public class _6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s ;
        }
        String res = "" ;
        // 字符数组的默认值为‘/0’
        char[][] matrix = new char[numRows][Math.min(1000 , s.length())] ;
        // dir_flag用来表示当前需要行进的方向 ， 当为0时，表示向下走；当为1时，表示向左上方走
        int dir_flag = 0 ;
        // m表示行 ，n表示列
        int m = 0 , n = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(dir_flag == 0){// 向下走，直到n == numRows - 1
                matrix[m][n] = s.charAt(i) ;
                m++ ;
                if(m == numRows - 1){
                    dir_flag = 1 ;
                }
            }else if(dir_flag == 1){// 向左上方走，直到m == 0
                matrix[m][n] = s.charAt(i) ;
                m-- ;
                n++ ;
                if(m == 0){
                    dir_flag = 0 ;
                }
            }
        }
        for(int i = 0 ; i < numRows ; i++){
            for(int j = 0 ; j < s.length() ; j++){
                if(matrix[i][j] != '\0'){
                    res += matrix[i][j] ;
                }
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        String s = "AB" ;
        int numRows = 1 ;
        _6_ZigZagConversion obj = new _6_ZigZagConversion() ;
        System.out.println(obj.convert(s , numRows));
    }
}
/**
 * 示例代码
 * class Solution {
 *     public String convert(String s, int numRows) {
 *
 *         if (numRows == 1) return s;
 *
 *         List<StringBuilder> rows = new ArrayList<>();
 *         for (int i = 0; i < Math.min(numRows, s.length()); i++)
 *             rows.add(new StringBuilder());
 *
 *         int curRow = 0;
 *         boolean goingDown = false;
 *
 *         for (char c : s.toCharArray()) {
 *             rows.get(curRow).append(c);
 *             if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
 *             curRow += goingDown ? 1 : -1;
 *         }
 *
 *         StringBuilder ret = new StringBuilder();
 *         for (StringBuilder row : rows) ret.append(row);
 *         return ret.toString();
 *     }
 * }
 *
 * Runtime: 5 ms, faster than 75.61% of Java online submissions for ZigZag Conversion.
 * Memory Usage: 39.8 MB, less than 40.29% of Java online submissions for ZigZag Conversion.
 * */