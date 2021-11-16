package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/11/7
 *
 * 三角形的最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * */
public class _31_MinimumTotal {
    // 只能移动到下一行中的相邻节点上
    // 动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size() ;
        int[][] dp = new int[len][len] ;
        dp[0][0] = triangle.get(0).get(0) ;

        int res = Integer.MAX_VALUE ;

        for (int i = 1 ; i < triangle.size() ; i++){
            for (int j = 0 ; j < triangle.get(i).size() ; j++){
                // 每行的第一个元素
                if (j == 0){
                    dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0) ;
                }else if(j == triangle.get(i).size() - 1){
                // 每行的最后一个元素
                    dp[i][j] = dp[i - 1][triangle.get(i - 1).size() - 1] + triangle.get(i).get(j) ;
                }else{
                // 其余的元素
                    dp[i][j] = Math.min(dp[i - 1][j - 1] , dp[i - 1][j]) + triangle.get(i).get(j) ;
                }
            }
        }

        // 最后一行的最小值
        for (int j = 0 ; j < len ; j++){
            res = Math.min(res , dp[len-1][j]) ;
        }
        return res ;
    }

    public static void main(String[] args) {
        _31_MinimumTotal obj = new _31_MinimumTotal() ;
        List<List<Integer>> triangle = new ArrayList<>() ;
        List<Integer> tmp = new ArrayList<>() ;
        tmp.add(2) ;
        triangle.add(tmp);

        List<Integer> tmp1 = new ArrayList<>() ;
        tmp1.add(3) ;
        tmp1.add(4) ;
        triangle.add(tmp1);

        List<Integer> tmp2 = new ArrayList<>() ;
        tmp2.add(6) ;
        tmp2.add(5) ;
        tmp2.add(7) ;
        triangle.add(tmp2);

        List<Integer> tmp3 = new ArrayList<>() ;
        tmp3.add(4) ;
        tmp3.add(1) ;
        tmp3.add(8) ;
        tmp3.add(3) ;
        triangle.add(tmp3);

        System.out.println(obj.minimumTotal(triangle));
    }
}
