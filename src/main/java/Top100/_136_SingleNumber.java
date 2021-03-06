import java.util.Set;

/**
 * 2021/09/13
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * */
public class _136_SingleNumber {
    // O(n)的时间复杂度，O(1)的空间复杂度
    // 异或
    public int singleNumber(int[] nums) {
        int res = 0 ;
        for (int i = 0 ; i < nums.length ; i++){
            res ^= nums[i] ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _136_SingleNumber obj = new _136_SingleNumber() ;
        int nums[] = {4,1,2,1,2} ;
        System.out.print(obj.singleNumber(nums));
    }
}
