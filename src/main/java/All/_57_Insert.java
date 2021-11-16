package All;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 2021/11/16
 *
 * 插入区间
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * */
public class _57_Insert {
    // 给你一个 无重叠的 ，按照区间起始端点排序的区间列表
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0] ;
        int right = newInterval[1] ;

        boolean placed = false ;

        List<int[]> ansList = new ArrayList<>() ;

        for (int[] interval : intervals){
            if (interval[0] > right){
                // 在插入区间的右侧且无交集
                if (!placed){
                    ansList.add(new int[]{left , right}) ;
                    placed = true ;
                }
                ansList.add(interval) ;
            }else if(interval[1] < left){
                // 在插入区间的左侧且无交集
                ansList.add(interval) ;
            }else{
                // 交集的计算方案
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left , interval[0]) ;
                right = Math.max(right , interval[1]) ;
            }
        }
        if (!placed){
            ansList.add(new int[]{left , right}) ;
        }

        return ansList.toArray(new int[ansList.size()][]) ;
    }

    public static void main(String[] args) {
        _57_Insert obj = new _57_Insert() ;
        int[][] intervals = {{1,2} , {3,5} , {6,7} , {8,10} , {12,16}} ;
        int[] newIntervals = {4,8} ;

        int[][] res = obj.insert(intervals , newIntervals) ;

        for (int i = 0 ; i < res.length ; i++){
            System.out.println(res[i][0] + "," + res[i][1]);
        }    }
}
