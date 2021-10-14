import java.util.*;

/**
 * 2021/09/07
 * 全排列II，给定数组中可能有重复的数字，按任意顺序返回所有不重复的排列
 * 最简单的方法是
 * */
public class _47_PermutationsII {
    private void dfs(int[] nums, int level, int[] visited, List<Integer> out, List<List<Integer>> res) {
        if(level == nums.length){
            res.add(new ArrayList<>(out)) ;
        }else{
            for(int i = 0 ; i < nums.length ; i++){
                if(visited[i] == 0){
                    visited[i] = 1 ;
                    out.add(nums[i]) ;
                    dfs(nums , level + 1 , visited , out , res);
                    out.remove(out.size() - 1) ;
                    visited[i] = 0 ;
                }
            }
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> out = new ArrayList<>() ;
        int[] visited = new int[nums.length] ;

        for(int i = 0 ; i < nums.length ; i++){
            visited[i] = 0 ;
        }

        dfs(nums , 0 , visited , out , res) ;

        // res去重
        Set<List<Integer>> tmp = new HashSet<>() ;
        for(int i = 0 ; i < res.size() ; i++){
            tmp.add(res.get(i)) ;
        }
        List<List<Integer>> last = new ArrayList<>() ;
        Iterator<List<Integer>> it = tmp.iterator() ;
        while(it.hasNext()){
            last.add(it.next()) ;
        }

        return last ;
    }


    public static void main(String[] args) {
        _47_PermutationsII obj = new _47_PermutationsII() ;
        int[] nums = {1 , 1 , 2} ;
        System.out.println(obj.permuteUnique(nums));
    }
}
