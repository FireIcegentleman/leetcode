package All;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/21
 *
 * 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * */
public class _17_LetterCombinations {
    public String[] dict = {"!@#" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"} ;
    public List<String> res ;
    public List<String> letterCombinations(String digits) {
        int len = digits.length() ;
        res = new ArrayList<>() ;

        if (len == 0){
            return res ;
        }
        dfs(digits , 0 , new StringBuilder() ) ;
        return res ;
    }

    private void dfs(String digits , int index, StringBuilder cur) {
        if (index == digits.length()){
            res.add(cur.toString()) ;
        }else{
            String str = dict[digits.charAt(index) - '1'] ;

            // 处理每个位置上的每一个字符，使用for循环就行了
            for (int i = 0 ; i < str.length() ; i++){
                cur.append(str.charAt(i) );
                dfs(digits , index + 1 , cur) ;
                // 删除最后一个元素
                cur.deleteCharAt(cur.length() - 1) ;
            }
        }
    }

    public static void main(String[] args) {
        _17_LetterCombinations obj = new _17_LetterCombinations() ;
        String digits = "23" ;
        List<String> res = obj.letterCombinations(digits) ;
        for (int i = 0 ; i < res.size() ; i++){
            System.out.println(res.get(i));
        }
    }
}
