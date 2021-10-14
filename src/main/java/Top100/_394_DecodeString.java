import javax.print.DocFlavor;
import java.util.*;

/**
 * 2021/09/23
 *
 * 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * */

public class _394_DecodeString {
    public String decodeString(String s) {
        int n = s.length() ;
        if (n == 0){
            return "" ;
        }

        StringBuilder str = new StringBuilder() ;
        Stack<Integer> stack = new Stack<>() ;
        Deque<String> queue = new ArrayDeque<>() ;

        int num_tmp = 0 ;
        boolean num_flag = false ;
        boolean flag = false ;

        for (int i = 0 ; i < n ; i++){
            char t = s.charAt(i) ;
            if (t - '0' >= 0 && t - '0' <= 9){// 遇到数字
                if (!num_flag){
                    num_tmp = 0 ;
                    num_tmp += t - '0' ;
                    if (s.charAt(i + 1) - '0' >= 0 && s.charAt(i + 1) - '0' <= 9){// 数字序列还未完结
                        num_flag = true ;
                        continue;
                    }
                }else{// 当前数字序列还未完结
                    num_tmp = num_tmp * 10 + t - '0' ;
                    if (!(s.charAt(i + 1) - '0' >= 0 && s.charAt(i + 1) - '0' <= 9)){// 数字序列还未完结
                        num_flag = false ;
                    }
                }
                stack.push(num_tmp) ;
            }else if (t == '['){// 遇到左括号
                flag = true ;
                queue.addLast(t + "");
            }else if (t == ']'){// 遇到右括号
                // 找到最后一个左括号，然后将遍历经过的值存起来
                StringBuilder tmp = new StringBuilder() ;
                Stack<String> stack_tmp = new Stack<>() ;
                while(!queue.peekLast().equals("[")){
                    stack_tmp.push(queue.pollLast());
                }
                // 不能简单颠倒，因为可能一个位置的字符串是整体
                while(!stack_tmp.empty()){
                    tmp.append(stack_tmp.pop()) ;
                }
                // 弹出这个左括号
                queue.pollLast() ;
                int count = stack.pop() ;
                StringBuilder tmp_res = new StringBuilder() ;
                for (int k = 0 ; k < count ; k++){
                    tmp_res.append(tmp) ;
                }
                // 得到的结果放回双向队列
                queue.addLast(tmp_res.toString());
                if (!queue.peekFirst().equals("[")){// 当前没有未完成的左括号了
                    flag = false ;
                    while(!queue.isEmpty()){
                        str.append(queue.pollFirst()) ;
                    }
                }
            }else{// 普通字符串
                if (flag == true){
                    queue.addLast(t + "");
                }else{
                    str.append(t) ;
                }
            }
        }
        return str.toString() ;
    }

    public static void main(String[] args) {
        _394_DecodeString obj = new _394_DecodeString() ;
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef" ;
        System.out.println(obj.decodeString(s));
    }
}
