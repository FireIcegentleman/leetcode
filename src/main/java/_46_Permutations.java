/**
 * 2021/09/07
 * 全排列，广度优先遍历，返回所有可能的全排列
 * https://zhuanlan.zhihu.com/p/350219671
 * 涉及到java的深拷贝
 * */
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    private void dfs(List<List<Integer>> res, int[] nums, int level , List<Integer> out, int[] visited) {
        if(level == nums.length){// out是一个引用，删除具有传递性
            res.add(new ArrayList<>(out)) ;
        }else{
            for(int i = 0 ; i < nums.length ; i++){
                if(visited[i] == 0){
                    visited[i] = 1 ;
                    out.add(nums[i]) ;
                    dfs(res , nums , level + 1 , out , visited) ;
                    out.remove(out.size() - 1) ;
                    visited[i] = 0 ;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> out = new ArrayList<>() ;
        int[] visited = new int[nums.length] ;
        for(int i = 0 ; i < nums.length ; i++){
            visited[i] = 0;
        }

        dfs(res , nums , 0 , out , visited) ;

        return res ;
    }



    public static void main(String[] args) {
        _46_Permutations obj = new _46_Permutations() ;
        int[] nums = {1,2,3} ;
        System.out.println(obj.permute(nums));
    }
}
