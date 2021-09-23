/**
 * 2021/09/20
 * 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * * */
public class _287_FindtheDuplicateNumber {
    // 在不修改数组并常数级的空间复杂度下，找到数组的重复元素
    // 暴力解法超时
    public int findDuplicate_force(int[] nums) {
        int n = nums.length ;

        for (int i = 0 ; i < n ; i++){
            for (int j = i  + 1; j < n ; j++){
                if (nums[i] == nums[j]){
                    return nums[i] ;
                }
            }
        }
        return 0 ;
    }

    // 142题，环形链表，快慢指针
    public int findDuplicate(int[] nums) {
        int n = nums.length ;
        int slow = 0 , fast = 0 ;
        slow = nums[slow] ;
        // 初始时，fast位于slow的下一个位置
        fast = nums[nums[fast]] ;
        // 循环等待相遇
        while(slow != fast){
            slow = nums[slow] ;
            fast = nums[nums[fast]] ;
        }

        int p = 0 ;
        int q = slow ;

        // 找到环的入口
        while(p != q){
            p = nums[p] ;
            q = nums[q] ;
        }
        return p ;

    }
    public static void main(String[] args) {
        _287_FindtheDuplicateNumber obj = new _287_FindtheDuplicateNumber() ;
        int[] nums = {3,1,3,4,2} ;
        System.out.print(obj.findDuplicate(nums));
    }
}
