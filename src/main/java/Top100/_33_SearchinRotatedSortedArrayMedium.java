import java.util.Arrays;

/**
 * 2021/6/8
 * 寻找索引
 * 旋转后的数组是一个递增数组旋转后得到的
 * 求target在当前数组中的索引
 */

public class _33_SearchinRotatedSortedArrayMedium {
    public int search(int[] nums, int target) {
        int res = -1 ;
        // 先比较target与数组头元素的大小，如果更大，则正向找，如果更小则逆向找
        boolean direction = target >= nums[0] ? true : false ;
        if(direction){
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] == target){
                    return i ;
                }
            }
        }else{
            for(int i = nums.length - 1 ; i >= 0 ; i--){
                if(nums[i] == target){
                    return i ;
                }
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        _33_SearchinRotatedSortedArrayMedium obj = new _33_SearchinRotatedSortedArrayMedium() ;
        int[] nums = {4,5,6,7,0,1,2} ;
        int target = 0 ;
        System.out.println(obj.search(nums,target));
    }
}
