package leetcode.dp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumNumberOfWorkSessionsToFinishTheTasks1986 {
    //其实sessionTime就是一个筒，这是一个背包问题
    //然后我们要计算的是几个桶
    int count = 0;
    List<Integer> buckets = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    private int limit;
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        //m表示一共有多少种组合
        int m = 1 << n;
        //状态数组
        int[] dp = new int[m];
        //对所有的状态组合进行填充
        Arrays.fill(dp, Integer.MAX_VALUE);

        //填入每一个sessionTime时间内可以完成的组合
        for(int i = 0; i < m; i++){
            int selectStatus = i;
            int taksId = 0;
            int cost = 0;
            //保持还有选中些什么
            while (selectStatus > 0){
                int curSelected = selectStatus & 1;
                //当前任何被选中
                if(curSelected == 1){
                    cost += tasks[taksId];
                }
                //销毁一位
                selectStatus =  selectStatus >> 1;
                taksId ++;
            }
            if(cost <= sessionTime)
                dp[i] = 1;
        }
        //接下来扫描每一个任务组合
        //dp[0]是一个什么任务都不做的组合，遍历是没有意义的
        for(int i = 1; i < m; i++){
            //排除那些基础组合
            if(dp[i] == 1){
                continue;
            }
            int split = i >> 1;
            //转移是由子集和补集的来的
            for(int j = (i - 1) & i; j > 0; j = (j - 1) & i){
                //i 状态的最优解可能由当前子集 j 与子集 j 的补集得来
                //这里展示的是求解i被j和i^j的过程
                //dp[j] + dp[i^j] 和 d[i]就是补集关系
                //下面表达的就是i的二进制由于j 和 i 和 j的表达关系
                dp[i] = Math.min(dp[i], dp[j] + dp[i^j]);
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        MinimumNumberOfWorkSessionsToFinishTheTasks1986 ins = new MinimumNumberOfWorkSessionsToFinishTheTasks1986();
        int[] tasks = new int[]{1,2,3};
        int sessionTime = 3;
//        int[] tasks = new int[]{3,1,3,1,1};
//        int sessionTime = 8;
//        int[] tasks = new int[]{1,2,3,4,5};
//        int sessionTime = 15;
//        int[] tasks = new int[]{7,4,3,8,10};
//        int sessionTime = 12;
//        int[] tasks = new int[]{2,3,3,4,4,4,5,6,7,10};
//        int sessionTime = 12;
        System.out.println(ins.minSessions(tasks,sessionTime));
    }
}
