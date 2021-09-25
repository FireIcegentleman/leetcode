import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/09/24
 * 分隔等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * */
public class _416_PartitionEqualSubsetSum {
    public boolean[] visited ;
    public List<Integer> res ;
    public List<List<Integer>> memory  ;
    // 在nums中寻找一组数，使得其和等于targat
    private void findtarget(List<Integer> res , int[] nums, boolean[] visited, int i, int target) {
        if (target == 0){// 找到了这组数，返回
            memory.add(new ArrayList<>(res)) ;
            return ;
        }
        if (i >= nums.length || target < 0){// 没有找到这样的数值
            return ;
        }

        visited[i] = true ;
        res.add(nums[i]) ;
        findtarget(res , nums , visited , i + 1 , target - nums[i]) ;
        res.remove(res.size() - 1) ;
        visited[i] = false ;
        findtarget(res , nums , visited , i + 1 , target);
    }

    // 判断是否可以将这个数组分成两个和相等的子集
    public boolean canPartition_force(int[] nums) {
        if (nums.length == 0){
            return true ;
        }

        visited = new boolean[nums.length] ;
        Arrays.fill(visited , false);
        // 数组排序
        Arrays.sort(nums);

        int sum = 0 ;
        for (int num : nums){
            sum += num ;
        }

        if (sum % 2 != 0){// 说明是奇数
            return false ;
        }

        // 这两个数组的和应该等于target
        int target = sum / 2 ;

        // 问题转换成是否存在一组数，使其和等于target？
        // memory中存储着数组中加起来等于target的所有值
        memory = new ArrayList<>() ;
        findtarget(new ArrayList<Integer>(0) , nums , visited , 0 , target) ;
        if (memory.size() != 2){// 必须有两组值等于target
            return false ;
        }

        List<Integer> res_list = new ArrayList<>(memory.get(0)) ;
        res_list.addAll(new ArrayList<>(memory.get(1))) ;

        int[] res_array = new int[res_list.size()] ;

        for (int i = 0 ; i < res_list.size() ; i++){
            res_array[i] = res_list.get(i) ;
        }
        Arrays.sort(res_array);

        if (res_array.length != nums.length){
            return false ;
        }
        for (int i = 0 ; i < nums.length ; i++){
            if (res_array[i] != nums[i]){
                return false ;
            }
        }
        return true ;
    }

    // 转换为0-1背包问题
    public boolean canPartition(int[] nums){
        if (nums.length == 0){
            return true ;
        }

        int sum = 0 ;
        for (int num : nums){
            sum += num ;
        }

        if (sum % 2 != 0){// 说明是奇数
            return false ;
        }

        // 这两个数组的和应该等于target
        int target = sum / 2 ;

        // 创建二维数组，行：物品索引，列：容量（包括零）
        boolean[][] dp = new boolean[nums.length][target + 1] ;

        // 先填表格第0行，第1个数只能让容积为他自己的背包恰好装满
        if (nums[0] <= target){
            dp[0][nums[0]] = true ;
        }

        //在填表格后面几行
        for (int i = 1 ; i < nums.length ; i++){
            for (int j = 0 ; j <= target ; j++){
                // 直接从上一行把结果抄下来，再修正
                dp[i][j] = dp[i - 1][j] ;

                if (nums[i] == j){
                    dp[i][j] = true ;
                    continue;
                }

                if (nums[i] < j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]] ;
                }
            }
        }
        return dp[nums.length - 1][target] ;
    }
    public static void main(String[] args) {
        _416_PartitionEqualSubsetSum obj = new _416_PartitionEqualSubsetSum() ;
        int[] nums = {1,1,1,1} ;
        System.out.println(obj.canPartition(nums));
    }
}
