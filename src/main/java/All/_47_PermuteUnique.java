package All;

import java.util.*;

/**
 * 2021/11/14
 *
 * 全排列II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * */
public class _47_PermuteUnique {
    public HashSet<List<Integer>> set ;
    public List<List<Integer>> res ;
    public Deque<Integer> queue ;

    public List<List<Integer>> permuteUnique_set(int[] nums) {
        set = new HashSet<>() ;
        res = new ArrayList<>() ;
        queue = new ArrayDeque<>() ;

        int len = nums.length ;

        if (len == 0){
            return res ;
        }
        boolean[] used = new boolean[len] ;

        dfs_set(nums , len , 0 , used) ;

        res.addAll(set) ;
        return res ;
    }

    private void dfs_set(int[] nums, int len, int depth, boolean[] used) {
        if (len == depth){
            set.add(new ArrayList<>(queue)) ;
            return;
        }

        for (int i = 0 ; i < len ; i++){
            if (!used[i]){
                used[i] = true ;
                queue.addLast(nums[i]);

                dfs(nums , len , depth + 1 , used);

                queue.removeLast() ;
                used[i] = false ;
            }
        }
    }

    // 在遍历的过程中，一边遍历一边检测，在一定会产生重复结果集的地方剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>() ;
        queue = new ArrayDeque<>() ;

        int len = nums.length ;

        if (len == 0){
            return res ;
        }
        boolean[] used = new boolean[len] ;
        Arrays.sort(nums);

        dfs(nums , len , 0 , used) ;

        return res ;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used) {
        if (depth == len){
            res.add(new ArrayList<>(queue)) ;
            return;
        }

        for (int i = 0 ; i < len ; i++){
            if (used[i]){
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            used[i] = true ;
            queue.addLast(nums[i]);

            dfs(nums , len , depth + 1 , used);

            queue.removeLast() ;
            used[i] = false ;
        }
    }

    public static void main(String[] args) {
        _47_PermuteUnique obj = new _47_PermuteUnique() ;
        int[] nums = {1,1,2} ;

        List<List<Integer>> res = obj.permuteUnique(nums) ;

        for (int i = 0 ; i < res.size() ; i++){
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }


}
