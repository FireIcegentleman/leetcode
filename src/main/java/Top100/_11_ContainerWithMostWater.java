/**
 * 2021/2/2
 * leetcode 11
 * 装最多的水
 * 暴力解法
 * 另一种解法：双指针，显著降低了时间复杂度
 * */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0 ;
        int tmp ;
        for(int i = 0 ; i < height.length ; i++){
            for(int j = i + 1 ; j < height.length ; j++){
                tmp = Math.min(height[j],height[i]) * (j - i) ;
                if(tmp > res){
                    res = tmp ;
                }
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        int[] height = {4,3,2,1,4} ;
        _11_ContainerWithMostWater obj = new _11_ContainerWithMostWater() ;
        System.out.println(obj.maxArea(height)) ;
    }
}
/**
 * 2.Two Pointer Approach
 * The area be limited by
 *  (1)the height of the shorter line.
 *  (2)Further, the farther the lines, the more will be the area obtained.
 *  Source code:
 *  public class Solution {
 *     public int maxArea(int[] height) {
 *         int maxarea = 0, l = 0, r = height.length - 1;
 *         while (l < r) {
 *             maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
 *             if (height[l] < height[r])
 *                 l++;
 *             else
 *                 r--;
 *         }
 *         return maxarea;
 *     }
 * }
 *  时间复杂度显著下降
 * */
