package SwordOffer;
/**
 * 2021/10/11
 *
 * 在排序数组中查找数字
 *
 * 统计一个数字在排序数组中出现的次数。
 * */
public class _53_SearchNum {
    // 二分查找，中心扩展
    public int search(int[] nums, int target) {
        int len = nums.length ;
        if (len == 0){
            return 0 ;
        }
        int left = 0 , right = len - 1 ;
        int mid = 0 ;
        while (left <= right){
            mid = (left + right) / 2 ;
            if (nums[mid] == target){
                break;
            }else if(nums[mid] < target){
                left = mid + 1 ;
            }else{
                right = mid - 1 ;
            }
        }

        int i = mid , j = mid ;
        while (i >= 0){
            if (target == nums[i]){
                i-- ;
            }else{
                break ;
            }
        }

        while (j < len){
            if (target == nums[j]){
                j++ ;
            }else{
                break ;
            }
        }

        return Math.max((j - i - 1), 0);
    }
    public static void main(String[] args) {
        _53_SearchNum obj = new _53_SearchNum() ;
        int[] nums = {1,4} ;
        int target = 4 ;
        System.out.print(obj.search(nums , target));
    }
}
