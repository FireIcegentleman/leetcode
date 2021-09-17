import java.util.ArrayList;
import java.util.List;

/**
 * 2021/09/16
 * 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 拓扑排序
 * */
public class _207_CourseSchedule {
    public List<List<Integer>> graph = new ArrayList<>() ;
    public int[] visited ;
    public boolean isvalid = true;


    private void dfs(int i) {
        visited[i] = 1 ;

        for (int neighbor : graph.get(i)){
            if (visited[neighbor] == 0){//有邻居节点未被访问过
                dfs(neighbor);
                if (!isvalid){
                    return ;
                }
            }else if (visited[neighbor] == 1){// 当前遍历是从本节点开始的，又回到了本节点
                isvalid = false ;
                return ;
            }
        }
        visited[i] = 2 ;
    }

    // 构造的有向图中是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 以邻接表的方式构造图
        int n = numCourses ;
        visited = new int[n] ;
        for (int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>()) ;
        }
        for (int i = 0 ; i < prerequisites.length ; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]) ;
        }

        // 判断连通图中是否有环
        for (int i = 0 ; i < n && isvalid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }
        return isvalid ;
    }



    public static void main(String[] args) {
        _207_CourseSchedule obj = new _207_CourseSchedule() ;
        int numCourses = 2 ;
        int[][] prerequisites = {{1,0} , {0,1}} ;
        System.out.println(obj.canFinish(numCourses , prerequisites));
    }
}
