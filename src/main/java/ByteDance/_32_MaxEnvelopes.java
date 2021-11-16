package ByteDance;

import java.util.*;

/**
 * 2021/11/8
 *
 * 俄罗斯套娃信封问题
 *
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 * */
public class _32_MaxEnvelopes {
    // 当一个信封比另一个信封的长宽都大（严格大）时，可以组成套娃
    // 不允许旋转信封
    // 首先我们将所有的信封按照 w 值第一关键字升序、h 值第二关键字降序进行排序。
    // 随后我们就可以忽略 w 维度，求出 h 维度的最长严格递增子序列，其长度即为答案。
    public int maxEnvelopes_simple(int[][] envelopes) {
        int len = envelopes.length ;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            // 先按照长升序排序，再按照宽降序排序
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]){
                    return e1[0] - e2[0];
                }else{
                    return e2[1] - e1[1] ;
                }
            }
        });

        int[] dp = new int[len];
        Arrays.fill(dp , 1);

        int res = 1 ;

        for (int i = 1 ; i < len ; i++){
            for (int j = 0 ; j < i ; j++){
                // 注意判定条件
                if (envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[j] + 1 , dp[i]) ;
                }
            }
            res = Math.max(dp[i] , res) ;
        }
        return res;
    }

    // 二分法
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length ;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            // 先按照长升序排序，再按照宽降序排序
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]){
                    return e1[0] - e2[0];
                }else{
                    return e2[1] - e1[1] ;
                }
            }
        });

        // 记录最长严格递增子序列
        List<Integer> list = new ArrayList<>() ;
        list.add(envelopes[0][1]) ;

        for (int i = 1 ; i < len ; i++){
            int num = envelopes[i][1] ;
            if (num > list.get(list.size() - 1)){
                // 比当前最大值还大
                list.add(num) ;
            }else{
                // 需要更新原递增序列中的值
                int index = binarySearch(list , num) ;
                list.set(index , num) ;
            }
        }
        return list.size() ;
    }

    // 这个函数用来找到num应该在的位置
    private int binarySearch(List<Integer> list, int num) {
        int left = 0 , right = list.size() - 1 ;
        while (left <= right){
            int mid = (left + right) >> 1 ;
            if (list.get(mid) < num){
                left = mid + 1 ;
            }else{
                right = mid - 1 ;
            }
        }
        return left ;
    }

    public static void main(String[] args) {
        _32_MaxEnvelopes obj = new _32_MaxEnvelopes() ;
        int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}} ;
        System.out.println(obj.maxEnvelopes(envelopes));
    }
}
