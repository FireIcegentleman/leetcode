package ByteDance;

import java.util.Stack;

/**
 * 2021/10/29
 *
 * 简化路径
 *
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *      1. 始终以斜杠 '/' 开头。
 *      2. 两个目录名之间必须只有一个斜杠 '/' 。
 *      3. 最后一个目录名（如果存在）不能 以 '/' 结尾。
 *      4. 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 **/
public class _6_SimplifyPath {
    // 一定是倒着算的
    public String simplifyPath(String path) {
        String[] path_Unit = path.split("/") ;

        int len = path_Unit.length ;
        StringBuilder res = new StringBuilder() ;

        Stack<String> stack = new Stack<>() ;
        for (int i = 0 ; i < len ; i++){
            if (path_Unit[i].equals("")){
                continue;
            }else if(path_Unit[i].equals(".")){// 处于当前目录
                continue;
            }else if(path_Unit[i].equals("..")){// 返回上一级目录
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(path_Unit[i]) ;
            }
        }

        while (!stack.isEmpty()){
            res.insert(0 , stack.pop()) ;
            res.insert(0 , "/") ;
        }
        return res.toString().length() == 0 ? "/" : res.toString();
    }
    public static void main(String[] args) {
        _6_SimplifyPath obj = new _6_SimplifyPath() ;
        String path =  "/a/./b/../../c/" ;
        System.out.println(obj.simplifyPath(path));
    }
}
