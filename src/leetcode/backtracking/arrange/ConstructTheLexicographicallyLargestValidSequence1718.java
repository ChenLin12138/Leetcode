package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructTheLexicographicallyLargestValidSequence1718 {
    //求最大的值
    //每个2到n之间的整数，他们的距离为n
    //有一个1，然后2个n，我们事要满足开头的字符大
//    集合里面有一些数组，他们从大到小排列。
//    每一次尝试在答案中放入最大的那个数字去尝试，如果不行，则在同样的位置去放入更小的数字去尝试。
//    用位置去完成尝试
    int[] result;
    List<Integer> pool = new ArrayList<>();
    public int[] constructDistancedSequence(int n) {
        result = new int[(2 * n) - 1];
        for(int i = n; i > 0; i --){
            pool.add(i);
        }
        backTracking(0, pool);
        return result;
    }

    private boolean backTracking(int pos, List<Integer> pool){
        //退出条件
        if(pos >= result.length){
            return true;
        }
        //单层逻辑
        //扫描位置
        //i表示的是pool这个单调递减队列的元素
        //i的变化表示替换一个小的值去同一个位置
        if(result[pos] != 0){
            if(backTracking(pos+1, pool))
                return true;
        }

        for(int i = 0; i < pool.size(); i ++){
            if(pool.get(i) == 1 && result[pos] == 0){
                result[pos] = 1;
                //选取
                List<Integer> newList = new ArrayList<>(pool);
                newList.remove(i);
                if(backTracking(pos + 1, newList))
                    return true;
                result[pos] = 0;
            }

            if(pool.get(i) > 1 && pos + pool.get(i) < result.length && result[pos] == 0 && result[pos + pool.get(i)] == 0){
                //选取
                int val = pool.get(i);
                result[pos] = val;
                result[pos + val] = val;
                //回溯
                List<Integer> newList = new ArrayList<>(pool);
                newList.remove(i);
                if(backTracking(pos + 1, newList))
                    return true;
                //清理
                result[pos] = 0;
                result[pos + pool.get(i)] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ConstructTheLexicographicallyLargestValidSequence1718 ins = new ConstructTheLexicographicallyLargestValidSequence1718();
        Arrays.stream(ins.constructDistancedSequence(16)).forEach(x -> System.out.print(x));
//        Arrays.stream(ins.constructDistancedSequence(16)).forEach(x -> System.out.print(x));
    }
}
