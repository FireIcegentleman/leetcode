import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 2021/09/11
 * 最大矩形
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * */
public class _85_MaximalRectangle {
    private int largestRectangleArea(int[] heights) {
        int len = heights.length ;
        if(len == 0){
            return 0 ;
        }
        if(len == 1){
            return heights[0] ;
        }

        int res = 0 ;

        int[] newHeights = new int[len + 2] ;
        newHeights[0] = 0 ;
        System.arraycopy(heights , 0 , newHeights , 1 , len);
        newHeights[len + 1] = 0 ;
        len += 2 ;
        heights = newHeights;

        // 双端队列，在两端都可以进行插入和删除，同时实现了栈和队列的功能
        Deque<Integer> stack = new ArrayDeque<>(len) ;
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for(int i = 1 ; i < len ; i++){
            while(heights[i] < heights[stack.peekLast()]){// 更新数据状态
                int curHeight = heights[stack.pollLast()] ;
                int curWidth = i - stack.peekLast() - 1 ;
                res = Math.max(res , curHeight * curWidth) ;
            }
            stack.addLast(i);
        }
        return res ;
    }

    // 转化为上一题中求最大矩形的问题
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0 ;
        }
        // 列高度
        int[] height = new int[matrix[0].length] ;

        int maxArea = 0 ;
        // 每一行的最大矩形面积
        for(int row = 0 ; row < matrix.length ; row++){
            // 遍历每一列，更新列高度
            for(int col = 0 ; col < matrix[0].length ; col++){
                if(matrix[row][col] == '1'){
                    height[col] += 1 ;
                }else{
                    height[col] = 0 ;
                }
            }

            maxArea = Math.max(maxArea , largestRectangleArea(height)) ;
        }
        return maxArea ;
    }


    public static void main(String[] args) {
        _85_MaximalRectangle obj = new _85_MaximalRectangle();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}} ;
        System.out.println(obj.maximalRectangle(matrix));
    }
}
