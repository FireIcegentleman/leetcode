import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2021/09/24
 * 根据身高重排队列
 *
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * */

/**
 * 一般这种数对，还涉及排序的，根据第一个元素正向排序，根据第二个元素反向排序，或者根据第一个元素反向排序，根据第二个元素正向排序，往往能够简化解题过程。
 * */
public class _406_QueueReconstructionbyHeight {
    // 首先根据people[i][1]的元素1降序排序
    // 按照是对的元素2增序排序，希望K大的尽量在后面
    public int[][] reconstructQueue(int[][] people) {
        // 数组的第一个元素进行逆序,数组第二个元素正序
        Arrays.sort(people , (p1 , p2) -> {
           if (p1[0] != p2[0]){
               return p2[0] - p1[0] ;
           }else{
               return p1[1] - p2[1] ;
           }
        });

        List<int[]> res = new ArrayList<>() ;
        for (int[] person : people){
            // 将person插入到person[1]所对应的索引的位置
            res.add(person[1] , person) ;
        }
        return res.toArray(new int[res.size()][0]) ;
    }

    public static void main(String[] args) {
        _406_QueueReconstructionbyHeight obj = new _406_QueueReconstructionbyHeight() ;
        int[][] people = {{7,0} , {4,4} , {7,1} , {5,0} , {6,1} , {5,2} } ;
        System.out.println(Arrays.deepToString(obj.reconstructQueue(people)));
    }
}
