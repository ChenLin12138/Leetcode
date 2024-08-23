package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//a,b,c可以重复使用，更像一个排列的问题
public class TheKThLexicographicalStringOfAllHappyStringsOfLengthN1415 {

    //开心字符的意思就是s[i]!=s[i+1]
    //要求返回第k个开心字符,n控制开心字符长度，k控制第几个
    //仅包含小写字符a,b,c
    private List<String> result = new ArrayList<>();
    private Stack<Character> stack = new Stack<>();

    private static char[] array = new char[]{'a','b','c'};

    public String getHappyString(int n, int k) {
        backTracking(n);
        return  k - 1 >= result.size() ? "" : result.get(k - 1);
    }

    private void backTracking(int n){
        //退出条件
        if(n == 0){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < stack.size(); i ++){
                sb.append(stack.get(i));
            }
            result.add(sb.toString());
            return;
        }
        //单层逻辑
        for(int i = 0; i < array.length; i ++){
            if(!stack.isEmpty() && stack.peek().equals(array[i])){
                continue;
            }
            //选取
            stack.add(array[i]);
            //回溯
            backTracking(n-1);
            //清理
            stack.pop();
        }
    }

    public static void main(String[] args) {
        TheKThLexicographicalStringOfAllHappyStringsOfLengthN1415 ins = new TheKThLexicographicalStringOfAllHappyStringsOfLengthN1415();
        System.out.print(ins.getHappyString(10,100));
    }
}
