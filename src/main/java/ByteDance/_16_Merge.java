package ByteDance;

import org.springframework.beans.factory.support.ScopeNotActiveException;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2021/11/1
 *
 * 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * */
public class _16_Merge {
    // 填路法，无法处理[1,4][5,6]
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][2] ;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>() ;

        for (int i = 0 ; i < intervals.length ; i++){
            int left = intervals[i][0] , right = intervals[i][1] ;
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left){
                res.add(new int[]{left , right}) ;
            }else{
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1] , right) ;
            }
        }
        return res.toArray(new int[res.size()][]) ;
    }
    public static void main(String[] args) {
        _16_Merge obj = new _16_Merge() ;
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}} ;

        int[][] res = obj.merge(intervals) ;

        for (int i = 0 ; i < res.length ; i++){
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }
}
