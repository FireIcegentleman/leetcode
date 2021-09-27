import java.util.HashMap;

/**
 * 2021/09/26
 *
 * 和为K的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * */
public class _560_SubarraySumEqualsK {
    // 统计并返回该数组中和为K的连续子数组的个数
    // 滑动窗口机制
    public int subarraySum_(int[] nums, int k) {
        int n = nums.length ;
        if (n == 0){
            return 0 ;
        }

        int res = 0 ;
        int L = 0 , R = 0 ;

        for ( ; L <  n ; L++){
            int sum = 0 ;
            for (R = L ; R < n ; R++){
                sum += nums[R];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res ;
    }

    // 前缀和 + 哈希表优化
    // 定义pre[i]为[0...i]里所有数字的和，则pre[i] = pre[i−1] + nums[i]
    // 那么 pre[i] − pre[j−1] == k
    public int subarraySum(int[] nums, int k) {
        int count = 0 , pre = 0 ;

        HashMap<Integer , Integer> map = new HashMap<>() ;
        map.put(0 , 1) ;
        for (int i = 0 ; i < nums.length ; i++){
            pre += nums[i] ;
            if (map.containsKey(pre - k)){
                count +=  map.get(pre - k);
            }
            map.put(pre ,  map.getOrDefault(pre , 0) + 1) ;
        }
        return count ;
    }

    public static void main(String[] args) {
        _560_SubarraySumEqualsK obj = new _560_SubarraySumEqualsK() ;
        int[] nums = {1,1,1};
        int k = 2 ;
        System.out.println(obj.subarraySum(nums , k));
    }
}
