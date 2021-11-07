package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/11/1
 *
 * 排列序列
 *
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 *
 * 给定 n 和 k，返回第 k 个排列。
 *
 * hard
 * */
public class _14_GetPermutation {
    // 返回n个数的第k个排列
    // 46题全排列回溯算法可能会导致栈过深，实际上也不用求出所有的结果
    // 所求排列 一定在叶子结点处得到，进入每一个分支，可以根据已经选定的数的个数，进而计算还未选定的数的个数，然后计算阶乘，就知道这一个分支的 叶子结点 的个数：
    //如果 kk 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫「剪枝」；
    //如果 kk 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。
    /**
     * 记录数字是否使用过
     * */
    private boolean[] visited ;

    /**
     * 阶乘数组
     * */
    private int[] factorial ;

    private int n ;
    private int k ;

    public String getPermutation(int n, int k) {
        this.n = n ;
        this.k = k ;

        calculateFactorial(n) ;

        // 查找全排列需要的布尔数组
        visited = new boolean[n + 1] ;
        Arrays.fill(visited , false);

        StringBuilder path = new StringBuilder() ;
        dfs(0 , path) ;
        return path.toString() ;
    }

    private void dfs(int index, StringBuilder path) {
        if (index == n){
            return;
        }

        // 计算还未确定的数字的全排列个数，第1次进入的时候是n-1
        int cnt = factorial[n - 1 - index] ;
        for (int i = 1 ; i <= n ; i++){
            if (visited[i]){
                continue;
            }

            // 不断剪枝，各层次
            if (cnt < k){
                k -= cnt ;
                continue;
            }
            path.append(i) ;
            visited[i] = true ;
            // 缩小精度
            dfs(index + 1 , path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    /**
     * 计算阶乘数组，并记录
     * */
    private void calculateFactorial(int n) {
        factorial = new int[n + 1] ;
        factorial[0] = 1 ;
        for (int i = 1 ; i <= n ; i++){
            factorial[i] = factorial[i - 1] * i ;
        }
    }


    public static void main(String[] args) {
        _14_GetPermutation obj = new _14_GetPermutation() ;
        int n = 3 ;
        int k = 3 ;
        System.out.println(obj.getPermutation(n , k));
    }
}
