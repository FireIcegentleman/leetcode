package All;

/**
 * 2021/10/23
 *
 * 删除有序数组中的重复项
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * */
public class _26_RemoveDuplicates {
    // 原地删除重复的元素
    // 双指针
    public int removeDuplicates(int[] nums) {
        int len = nums.length ;

        if (len < 2){
            return len ;
        }

        int p = 0 , q = 1 ;
        while (q != len){
            if (nums[p] != nums[q]){
                if (q - p > 1){
                    nums[p + 1] = nums[q] ;
                }
                p++ ;
            }
            q++ ;
        }
        return p + 1 ;
    }


    public static void main(String[] args) {
        _26_RemoveDuplicates obj = new _26_RemoveDuplicates() ;
        int[] nums = {0,0,1,1,1,2,2,3,3,4} ;
        System.out.println(obj.removeDuplicates(nums));
    }
}
