import java.util.ArrayList;
import java.util.List;

/**
 * https://codetop.cc/home 企业高频题目
 * */
public class test {
    public static void main(String[] args) {
        /*List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<Integer>();
        tem.add(5);
        ans.add(new ArrayList<>(tem));
        tem.add(6);*/

        int[][] num = {{3,78},{3,96},{1,88},{3,90},{3,96},{2,95},{3,96},{3,90},{2,93}} ;
        int mom = 0, child = 0 ;

        for (int i = 0 ; i < num.length ; i++){
            mom += num[i][1] * num[i][0];
            child += num[i][0] ;
        }
        double res = 1.0 * mom / (1.0 * child) ;
        System.out.println(res);
    }
}
