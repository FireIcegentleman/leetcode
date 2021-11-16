package All;

import java.util.Map;

/**
 * 2021/11/13
 *
 * 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * */
public class _42_Trap {
    public int trap(int[] height) {
        int[] left = new int[height.length] ;
        int[] right = new int[height.length] ;

        int maxleft = 0 , maxright = 0 ;

        int res = 0 ;
        for (int i = 0 ; i < height.length ; i++){
            maxleft = Math.max(maxleft , height[i]) ;
            left[i] =  maxleft;
        }

        for (int i = height.length - 1 ; i >= 0 ; i--){
            maxright = Math.max(maxright , height[i]) ;
            right[i] =  maxright;
        }

        for (int i = 0 ; i < height.length ; i++){
            res += Math.min(left[i] , right[i]) - height[i] ;
        }

        return res ;
    }
    public static void main(String[] args) {
        _42_Trap obj = new _42_Trap() ;
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1} ;
        System.out.println(obj.trap(height));
    }
}
