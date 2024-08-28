package leetcode.backtracking.subsets;

import java.util.*;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings1593 {

    //拆分的字符串的子串不能重复
    //拼接后还可以还原以前的字符串
    //需要一些判断，拆分后字符的长度和原来相同
    //每一个元素不能重复
    //因为求最大，所以要最大拆分

//    private List<String> result = new ArrayList<>();
    private Stack<String> subResult = new Stack<>();
    private Set<String> set = new HashSet<>();
    private int max = 0;

    public int maxUniqueSplit(String s) {
        backTracking(s);
        return max;
    }

    private void backTracking(String s){
        //退出条件
        if(s.isEmpty() || s.length() == 0){
            max = Math.max(max,subResult.size());
            return;
        }
        //单层逻辑
        for(int i = 0; i < s.length(); i++){
            //减枝
            //已经包含的就不要
            //选取
            String str = s.substring(0,i+1);
            if(set.contains(str)) {
                continue;
            }
            set.add(str);
            subResult.add(str);
            //回溯
            backTracking(s.substring(i+1));
            //清理
            subResult.pop();
            set.remove(str);
        }
    }

    public static void main(String[] args) {
        SplitAStringIntoTheMaxNumberOfUniqueSubstrings1593 ins = new SplitAStringIntoTheMaxNumberOfUniqueSubstrings1593();
//        System.out.print(ins.maxUniqueSplit("ababccc"));
        System.out.print(ins.maxUniqueSplit("wwwzfvedwfvhsww"));
    }
}
