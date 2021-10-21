package All;

import javax.swing.text.MaskFormatter;

/**
 * 2021/10/20
 *
 * 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * */
public class _11_MaxArea {
    // 输出最大面积
    // 在移动过程中不断消去不可能为最大值的状态
    public int maxArea(int[] height) {
        int len = height.length ;
        int maxArea = 0 ;

        int left = 0 , right = len - 1 ;

        while (left < right){
//            maxArea = Math.max(maxArea , Math.min(height[left] , height[right]) * (right - left)) ;
//            if (height[left] < height[right]){
//                left++ ;
//            }else {
//                right-- ;
//            }
            maxArea = height[left] < height[right] ?
                    Math.max(maxArea , (right - left) * height[left++]) :
                    Math.max(maxArea , (right - left) * height[right--]) ;
        }
        return maxArea ;
    }
    public static void main(String[] args) {
        _11_MaxArea obj = new _11_MaxArea() ;
        int[] height = {1,8,6,2,5,4,8,3,7} ;
        System.out.println(obj.maxArea(height));
    }
}
