import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2021/09/21
 *
 * 删除无效的括号
 *
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * * */
public class _301_RemoveInvalidParentheses {

    public int length ;
    public Set<String> set ;
    public char[] cha ;

    // 因为会不断尝试并返回所有可能结果，所以使用的是回溯算法
    // 如果当前遍历到的左括号的数目严格小于有括号的数目则无效
    public List<String> removeInvalidParentheses(String s) {
        length = s.length() ;
        set = new HashSet<>() ;
        cha = s.toCharArray() ;

        int leftRemove = 0 ;
        int rightRemove = 0 ;

        for (char c : cha){
            if (c == '('){
                leftRemove++ ;
            }else if (c == ')'){
                if (leftRemove > 0){
                    leftRemove --;
                }else{
                    rightRemove ++ ;
                }
            }
        }

        StringBuilder path = new StringBuilder() ;
        dfs(0 , 0 , 0 , leftRemove , rightRemove , path) ;
        return new ArrayList<>(this.set) ;
    }

    private void dfs(int index , int leftCount , int rightCount , int leftRemove, int rightRemove, StringBuilder path) {
        // 此时字符串合法
        if (index == length){
            if (leftRemove == 0 && rightRemove == 0){
                set.add(path.toString()) ;
            }
            return;
        }

        char character = cha[index] ;

        // 可能的操作1：删除当前的括号，并继续递归
        if (character == '(' && leftRemove > 0){
            dfs(index + 1 , leftCount , rightCount , leftRemove - 1 , rightRemove , path);
        }
        if (character == ')' && rightRemove > 0){
            dfs(index + 1, leftCount , rightCount , leftRemove , rightRemove - 1 , path);
        }

        // 路径添加当前字符
        path.append(character) ;

        // 可能的操作2：保留当前的括号，并继续递归
        if (character != '(' && character != ')'){
            dfs(index + 1 , leftCount , rightCount , leftRemove , rightRemove , path);
        } else if (character == '('){
            // 保留当前左括号
            dfs(index + 1 , leftCount + 1 , rightCount , leftRemove , rightRemove , path) ;
        } else if (rightCount < leftCount){
            // 保留当前右括号
            dfs(index + 1 , leftCount , rightCount + 1 , leftRemove , rightRemove , path) ;
        }

        path.deleteCharAt(path.length() - 1) ;
    }

    public static void main(String[] args) {
        _301_RemoveInvalidParentheses obj = new _301_RemoveInvalidParentheses() ;
        String s = "(a)())()" ;
        List<String> res = obj.removeInvalidParentheses(s) ;
        for (int i = 0 ; i < res.size() ; i++){
            System.out.println(res.get(i));
        }
    }
}
