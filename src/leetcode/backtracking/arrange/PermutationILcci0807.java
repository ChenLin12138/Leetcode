package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PermutationILcci0807 {

    List<String> reslut = new ArrayList<>();
    Stack<Character> stack = new Stack<>();

    public String[] permutation(String s) {
        backTracking(s);
        return reslut.toArray(new String[reslut.size()]);
    }

    private void backTracking(String s){
        //退出条件
        if(s.isEmpty()){
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < stack.size(); i ++){
                sb.append(stack.get(i));
            }
            reslut.add(sb.toString());
            return;
        }
        //单层逻辑
        for(int i = 0; i < s.length(); i ++){
            //选取
            stack.add(s.charAt(i));
            //回溯
            backTracking(s.substring(0,i)+s.substring(i+1));
            //清理
            stack.pop();
        }
    }

    public static void main(String[] args) {
        PermutationILcci0807 ins = new PermutationILcci0807();
        String[] re = ins.permutation("qwe");
        Arrays.stream(re).forEach(x -> System.out.println(x));
    }
}
