/**
 * 2021/09/26
 *
 * 任务调度器
 *
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 * */
public class _621_TaskScheduler {
    // 把不同种的任务尽可能放在一起
    // 因为可能要调整顺序，所以动态规划算法是不能用的
    // 桶思想
    // 总排队时间 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数
    public int leastInterval(char[] tasks, int n) {
        int[] tmp = new int[26] ;
        int countMaxTask = 0 ;
        int maxTask = 0 ;

        for (char c : tasks){
            tmp[c - 'A']++ ;
            maxTask = Math.max(maxTask , tmp[c-'A']) ;
        }

        // 最后一个桶里有几个数字
        for (int i = 0 ; i < 26 ; i++){
            if (tmp[i] == maxTask){
                countMaxTask++ ;
            }
        }

        return Math.max(tasks.length , (maxTask - 1) * (n + 1) + countMaxTask) ;
    }

    public static void main(String[] args) {
        _621_TaskScheduler obj = new _621_TaskScheduler() ;
        char[] tasks = {'A','A','A','B','B','B'} ;
        int n = 2 ;
        System.out.println(obj.leastInterval(tasks , n));
    }
}
