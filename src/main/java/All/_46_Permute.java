package All;

import java.util.*;

/**
 * 2021/11/14
 *
 * 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * */
public class _46_Permute {
    public List<List<Integer>> res ;
    public Deque<Integer> tmp ;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        tmp = new ArrayDeque<>() ;

        int len = nums.length;
        if (len == 0){
            return res ;
        }

        boolean[] used = new boolean[len] ;

        dfs(nums, len, 0, used) ;

        return res ;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used) {
        if (depth == len){
            res.add(new ArrayList<>(tmp)) ;
            return ;
        }

        for (int i = 0 ; i < len ; i++){
            // 未被访问过
            if (!used[i]){
                used[i] = true ;
                tmp.addLast(nums[i]) ;

                //System.out.println("  递归之前 => " + tmp);
                dfs(nums, len , depth + 1 , used);

                tmp.removeLast() ;
                used[i] = false ;
                //System.out.println("递归之后 => " + tmp);

            }
        }
    }


    public static void main(String[] args) {
        _46_Permute obj = new _46_Permute() ;
        int[] nums = {1,2,3} ;

        List<List<Integer>> res = obj.permute(nums) ;

        for (int i = 0 ; i < res.size() ; i++){
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
