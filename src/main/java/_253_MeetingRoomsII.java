import java.util.*;

/**
 * 2021/09/18
 * 会议室II
 *
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 铺路法效率不高
 * */
public class _253_MeetingRoomsII {
    // 给定开始时间和结束时间，问至少需要多少件会议室
    public int minMeetingRooms_path(int[][] intervals) {
        // 铺路法，对于每一个序列，将路上的所有值+1，最后返回最大的
        int[] res = new int[1000001] ;
        for (int i = 0 ; i < 1000001 ; i++){
            res[i] = 0 ;
        }
        for (int i = 0 ; i < intervals.length ; i++){
            for (int j = intervals[i][0] ; j < intervals[i][1] ; j++){
                res[j] ++ ;
            }
        }
        Arrays.sort(res);
        return res[res.length - 1] ;
    }
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[][] data = new int[n * 2][2];

        int i = 0;
        for(int[] ary : intervals){
            data[i++] = new int[]{ary[0],1};
            data[i++] = new int[]{ary[1],-1};
        }

        //按时间升序
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                //当开始和结束时间相同，要保证先下车
                int x = a[0] - b[0];
                return (x == 0 ? a[1] - b[1] : x);
            }
        });

        int cur = 0;
        int max = 0;
        for(int[] a : data){
            cur = cur + a[1];
            max = Math.max(max, cur);
        }
        return max;
    }
    public static void main(String[] args) {
        _253_MeetingRoomsII obj = new _253_MeetingRoomsII() ;
        int[][] intervals = {{0,30} , {5,10} , {15,20}} ;
        System.out.print(obj.minMeetingRooms(intervals));
    }
}
