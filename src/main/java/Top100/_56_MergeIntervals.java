import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2021/09/08
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 方法一：排序，[1,4][5,6]这样的无法解决，因为都看作是位置上有东西，45之间没有区别的内容
 * */

public class _56_MergeIntervals {

    public int[][] merge_path(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> tmp = new ArrayList<>() ;

        int[] path = new int[10002] ;
        // 铺路，不为零的全部输出
        for(int i = 0 ; i < 10002 ; i++){
            path[i] = 0 ;
        }

        for(int i = 0 ; i < intervals.length ; i++){
            for(int start = intervals[i][0] ; start <= intervals[i][1] ; start++){
                path[start] ++ ;
            }
        }

        for(int i = 1 ; i < path.length ; i++){
            if(path[i - 1] == 0 && path[i] > 0){
                tmp.add(i) ;
            }else if(path[i] > 0 && path[i + 1] == 0){
                tmp.add(i);
                res.add(tmp) ;
                tmp = new ArrayList<>() ;
            }
        }
        // List<List> --> int[][]
        int[][] res_end = new int[res.size()][res.get(0).size()] ;
        for(int i = 0 ; i < res.size() ; i++){
            res_end[i] = res.get(i).stream().mapToInt(Integer::valueOf).toArray() ;
        }

        return res_end ;
    }
    // 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
    // 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
    //
    //否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2] ;
        }
        // 先基于左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // merged数组中存的是当前被处理完的范围
        List<int[]> merged = new ArrayList<>() ;
        for(int i = 0 ; i < intervals.length ; i++){
            int l = intervals[i][0] , r = intervals[i][1] ;
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < l){
                merged.add(new int[]{l , r}) ;
            }else{
                merged.get(merged.size() - 1)[l] = Math.max(merged.get(merged.size() - 1)[1] , r) ;
            }
        }
        return merged.toArray(new int[merged.size()][]) ;
    }

    public static void main(String[] args) {
        _56_MergeIntervals obj = new _56_MergeIntervals() ;
        int[][] intervals = {{1,4},{5,6}} ;
        int[][] res = obj.merge(intervals);

        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
