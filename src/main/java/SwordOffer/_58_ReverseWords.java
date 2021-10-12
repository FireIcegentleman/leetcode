package SwordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2021/10/10
 *
 * 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * */
public class _58_ReverseWords {
    // 标点符号和普通字符一样考虑的的意思是将标点符号算到某个单词之后
    public String reverseWords_(String s) {
        if (s.equals("")){
            return "" ;
        }
        String[] word = s.split(" ") ;
        List<String> words_list = new ArrayList<>() ;

        for (int i = 0 ; i < word.length ; i++){
            if (!word[i].equals("")){
                words_list.add(word[i]) ;
            }
        }
        Collections.reverse(words_list);

        StringBuilder res = new StringBuilder() ;
        if (words_list.size() == 0){
            return res.toString() ;
        }
        for (int i = 0 ; i < words_list.size() - 1 ; i++){
            res.append(words_list.get(i)) ;
            res.append(" ") ;
        }
        res.append(words_list.get(words_list.size() - 1)) ;

        return res.toString() ;
    }

    public String reverseWords(String s) {
        // Returns a string whose value is this string, with any leading and trailing whitespace removed.
        s = s.trim();
        StringBuilder res = new StringBuilder() ;
        int j = s.length() - 1 , i = j ;

        while (i >= 0){
            while(i >= 0 && s.charAt(i) != ' '){
                i-- ;
            }
            res.append(s.substring(i + 1 , j + 1)) ;
            res.append(" ") ;
            while (i >= 0 && s.charAt(i) == ' '){
                i-- ;
            }
            j = i ;
        }
        return res.toString().trim() ;
    }
    public static void main(String[] args) {
        _58_ReverseWords obj = new _58_ReverseWords() ;
        String s = "I am a student. ";
        System.out.print(obj.reverseWords(s));
    }
}
