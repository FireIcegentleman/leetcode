import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 2021/09/11
 *
 * 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为1。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 单调栈
 * */

public class _84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
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

    public static void main(String[] args) {
        _84_LargestRectangleinHistogram obj = new _84_LargestRectangleinHistogram() ;
        int[] heights = {2,4} ;
        System.out.print(obj.largestRectangleArea(heights));
    }
}
