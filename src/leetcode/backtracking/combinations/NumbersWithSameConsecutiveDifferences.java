package leetcode.backtracking.combinations;

import java.util.*;

public class NumbersWithSameConsecutiveDifferences {
    //各位从1开始向上累计
    Set<Integer> results = new HashSet<>();
    //Stack中最先放入的是高位
    Stack<Integer> stack = new Stack<>();
    private int diff = 0;

    public int[] numsSameConsecDiff(int n, int k) {
        this.diff = k;

        for(int i = 1; i < 10; i ++){
            //选取
            stack.add(i);
            //回溯
            backTracking(n-1);
            //清理
            stack.pop();
        }
        return results.stream().mapToInt(Integer::intValue).toArray();
    }

    private void backTracking(int n){
        //退出条件
        if (n == 0){
            int sum = stack.get(0);
            for(int i = 1; i < stack.size(); i ++){
                sum *= 10;
                sum += stack.get(i);
            }
            results.add(sum);
            return;
        }
        //单层逻辑
        //尝试生成下一位，下一位和当前这一位的差距为k
        //-的尝试
        int cur = stack.peek() - this.diff;
        if (cur >= 0){
            //选取
            stack.add(cur);
            //回溯
            backTracking(n - 1);
            //清理
            stack.pop();
        }

        //+的尝试
        cur = stack.peek() + this.diff;
        if (cur < 10){
            //选取
            stack.add(cur);
            //回溯
            backTracking(n - 1);
            //清理
            stack.pop();
        }
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences ins = new NumbersWithSameConsecutiveDifferences();
//        int[] array = ins.numsSameConsecDiff(2,1);
//        int[] array = ins.numsSameConsecDiff(3,7);
        int[] array = ins.numsSameConsecDiff(2,0);
        Arrays.stream(array).forEach(x -> System.out.println(x));
    }
}
