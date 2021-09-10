import java.util.ArrayList;
import java.util.List;


public class test {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<Integer>();
        tem.add(5);
        ans.add(new ArrayList<>(tem));
        tem.add(6);
    }
}
