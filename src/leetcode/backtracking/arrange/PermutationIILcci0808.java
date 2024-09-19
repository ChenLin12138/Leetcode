package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PermutationIILcci0808 {
    List<String> reslut = new ArrayList<>();
    Stack<Character> stack = new Stack<>();
    public String[] permutation(String s) {
        //因为有重复，所以这里排序
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        s = new String(charArray);
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
            //减枝,重复元素树层去重
            char c = s.charAt(i);
            if(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                continue;
            }
            //选取
            stack.add(s.charAt(i));
            //回溯
            backTracking(s.substring(0,i)+s.substring(i+1));
            //清理
            stack.pop();
        }
    }

    public static void main(String[] args) {
        PermutationIILcci0808 ins = new PermutationIILcci0808();
        String[] arr = ins.permutation("qqe");
        Arrays.stream(arr).forEach(x -> System.out.println(x));
    }
}
