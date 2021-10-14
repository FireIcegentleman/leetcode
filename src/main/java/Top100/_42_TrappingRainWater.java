/**
 * 2021/7/26
 * 没有特殊算法，就是数据的简单模拟
 * 从两侧向中间归拢
 * */
public class _42_TrappingRainWater {
    public int trap(int[] height) {
        int res = 0 ;

        int n = height.length ;
        int left = 0 ;
        int right = n - 1 ;
        int maxleft = 0 ;
        int maxright = 0 ;

        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= maxleft){
                    maxleft = height[left] ;
                }else{
                    res += maxleft - height[left] ;
                }
                left ++ ;
            }else{
                if(height[right] >= maxright){
                    maxright = height[right] ;
                }else{
                    res += maxright - height[right] ;
                }
                right -- ;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _42_TrappingRainWater obj = new _42_TrappingRainWater() ;
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));
    }
}
