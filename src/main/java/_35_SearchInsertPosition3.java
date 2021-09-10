/**
 * 2021/6/9
 * 若存在则返回索引，若不存在则返回应该插入的位置
 */

public class _35_SearchInsertPosition3 {
    public int searchInsert(int[] nums, int target) {

        int left = 0 , right = nums.length - 1 ;
        int mid = 0 ;
        while( left <= right ){
            mid = left + ( ( right - left ) >> 1 ) ;
            if( target == nums[mid] ) {
                return mid ;
            }
            else if( target < nums[mid] ) {
                right = mid - 1 ;
            }
            else {
                left = mid + 1 ;
            }
        }
        return left ;
    }

    public static void main(String[] args) {
        _35_SearchInsertPosition3 obj = new _35_SearchInsertPosition3() ;
        int[] nums = {1,3,5,6} ;
        int target = 2 ;
        System.out.println(obj.searchInsert(nums , target));
    }

}
