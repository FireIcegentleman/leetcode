package ByteDance;

/**
 * 2021/11/2
 *
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * */

public class _17_Trap {
    // 动态规划
    public int trap(int[] height){
        int res = 0 ;

        int n = height.length ;

        int[] left = new int[n] ;
        int[] right = new int[n] ;

        left[0] = height[0] ;
        right[n - 1]  = height[n - 1] ;

        for (int i = 1 ; i < n ; i++){
            left[i] = Math.max(height[i] , left[i - 1]) ;
        }

        for (int i = n - 2 ; i >= 0 ; i--){
            right[i] = Math.max(height[i] , right[i + 1]) ;
        }

        for (int i = 0 ; i < n ; i++){
            res += Math.min(left[i] , right[i]) - height[i] ;
        }
        return res ;
    }
    // 双指针做法
    public int trap_double(int[] height) {
        // 一定是基于累加的
        int res = 0 ;

        int n = height.length;
        int left = 0 ;
        int right = n - 1 ;
        int maxleft = 0 ;
        int maxright = 0 ;

        while (left <= right){
            maxleft = Math.max(maxleft , height[left]) ;
            maxright = Math.max(maxright , height[right]) ;

            if (height[left] < height[right]){
                res += (maxleft - height[left]) ;
                left++ ;
            }else{
                res += (maxright - height[right]) ;
                right-- ;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _17_Trap obj = new _17_Trap() ;
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1} ;
        System.out.println(obj.trap(height));
    }
}
