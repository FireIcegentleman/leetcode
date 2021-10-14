import com.sun.deploy.cache.InMemoryLocalApplicationProperties;

import java.util.ArrayList;
import java.util.List;
/**
 * 2021/09/23
 *
 * 找到所有数组中小时的数字
 *
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * */
public class _448_FindAllNumbersDisappearedinanArray {
    // 要求时间复杂度为O(n)且不使用额外空间，假定返回的数组不算在额外的空间里
    // 原地修改
    // 遍历 nums，每遇到一个数 x，就让 nums[x−1] 增加 n。由于 nums 中所有数均在[1,n] 中，
    // 增加以后，这些数必然大于 n。最后我们遍历nums，若 nums[i] 未大于 n，就说明没有遇到过数 i+1。这样我们就找到了缺失的数字。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length ;

        for (int num : nums){
            // 防止已经加过即出现过一遍
            int x = (num - 1) % n ;
            nums[x] += n ;
        }

        List<Integer> res = new ArrayList<>() ;

        for (int i = 1 ; i <= nums.length ; i++){
            if (nums[i - 1] <= n){
                res.add(i) ;
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        _448_FindAllNumbersDisappearedinanArray obj = new _448_FindAllNumbersDisappearedinanArray() ;
        int[] nums = {4,3,2,7,8,2,3,1} ;
        List<Integer> res = obj.findDisappearedNumbers(nums) ;
        for (int i = 0 ; i < res.size() ; i++){
            System.out.print(res.get(i) + ",");
        }
    }
}
