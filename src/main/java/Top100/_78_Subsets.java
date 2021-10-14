/**
 * 2021/09/09
 * 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * */
import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    List<List<Integer>> res = new ArrayList<>() ;
    List<Integer> out = new ArrayList<>() ;

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0 , nums );
        return res ;
    }

    //cur是当前位置
    private void dfs(int cur, int[] nums) {
        if(cur == nums.length){
            res.add(new ArrayList(out)) ;
            return ;
        }

        // 加入当前位置的数 ，进行DFS
        out.add(nums[cur]) ;
        dfs(cur + 1 , nums) ;
        // 不加入当前位置的数，进行DFS
        out.remove(out.size() - 1) ;
        dfs(cur + 1 , nums) ;
    }


    public static void main(String[] args) {
        _78_Subsets obj = new _78_Subsets() ;
        int[] nums = {1 , 2 , 3} ;
        List<List<Integer>> res = obj.subsets(nums) ;
        return ;
    }
}
/**
 * 对于cur位置而言，[0,cur-1]是确定的，但是[cur,n]是不确定的，
 * 所以将nums[cur]拿进来进行DFS + 不加入nums[cur]进行DFS
 *
 *  这种当面对有很多种情况的时候，就需要考虑DFS和动态规划了
 * */
