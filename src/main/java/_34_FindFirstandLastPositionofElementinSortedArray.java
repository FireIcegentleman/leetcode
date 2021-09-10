/**
 * 2021/6/8
 * 给定一个递增排列的数组，找到其中target值的start和end值
 */

public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length == 0){
            res[0] = -1 ;
            res[1] = -1 ;
            return res ;
        }
        int left = 0 , right = nums.length ;
        int mid = 0 ;
        while(left < right){
            mid = (left + right) / 2 ;
            if(target > nums[mid]){
                left = mid + 1 ;
            }else if(target < nums[mid]){
                right = mid ;
            }else if(target == nums[mid]){
                break ;
            }
        }

        if(target != nums[mid]){
            res[0] = -1 ;
            res[1] = -1 ;
            return res ;
         }
        int start = mid , end = mid ;
        //mid为target索引位置,在其附近寻找
        for(int i = mid ; i>= 0 ; i--){
            if(nums[i] != target){
                break ;
            }
            start = i ;
        }

        for(int i = mid ; i < nums.length ; i++){
            if(nums[i] != target){
                break ;
            }
            end = i ;
        }
        res[0] = start ;
        res[1] = end ;
        return res ;
    }

    public static void main(String[] args) {
        _34_FindFirstandLastPositionofElementinSortedArray obj = new _34_FindFirstandLastPositionofElementinSortedArray() ;
        int[] nums = {5,7,7,8,8,10} ;
        int target = 6 ;
        System.out.println(obj.searchRange(nums , target));
    }
}
