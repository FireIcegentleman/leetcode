package All;

import java.util.*;

/**
 * 2021/11/16
 *
 * 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * */
public class _56_Merge {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length ;

        List<int[]> res = new ArrayList<>() ;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1] ;
                }
            }
        });

        // 更新末尾的值
        // 判断是否开启新的值，如果left是新的范围，则新建一个
        // 如果不是新的范围，则更新最后一个值的内容
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
        _56_Merge obj = new _56_Merge() ;
        int[][] intervals = {{1,3} , {2,6} , {8,10} , {15,18}} ;

        int[][] res = obj.merge(intervals) ;

        for (int i = 0 ; i < res.length ; i++){
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }
}
