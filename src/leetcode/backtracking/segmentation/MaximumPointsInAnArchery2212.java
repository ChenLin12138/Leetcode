package leetcode.backtracking.segmentation;

import java.util.Arrays;
import java.util.Stack;

public class MaximumPointsInAnArchery2212 {
    private int targetNumber = 12;
    private int[] aliceArrows;
    private int maxVal = 0;
    //当前的射箭情况，我们需要用这个stack保存起来
    private Stack<Integer> stack = new Stack<>();
    private int[] results = new int[targetNumber];

    //得到最大的得分
    //要想得分，那么bob必须射出比Alice多的箭
    //那么对于没有个靶子，bob只能选择射比Alice多的弓箭，或者选择不射
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        this.aliceArrows = aliceArrows;
        backTracking(numArrows,0,0);
        return results;
    }

    //numArrows表达还剩多少只箭
    //index表示现在在说哪个靶位的事情
    //curVal表示目前多少分了
    private void backTracking(int numArrows, int index, int curVal){
        //结束条件
        //已经遍历过所有的靶位了
        if(index > targetNumber - 1){
            //并且现在的值大于最大的值，那么我值得记录
            if(curVal > maxVal){
                for(int i = 0; i < targetNumber; i++){
                    results[i] = stack.get(i);
                    maxVal = Math.max(maxVal,curVal);
                }
                //还有一个要求，箭是要射完的，射不完，那么就放到0上面去当拖靶。
                if(numArrows > 0){
                    results[0] += numArrows;
                }
            }
            return;
        }
        //单层逻辑
        //要射这个靶位
        //那要检查你的弓箭还够不够，不够就减枝
        //要射这个靶位的前提是，我们要比Alice消耗更多的箭
        if(numArrows > aliceArrows[index]){
            //选取
            stack.push(aliceArrows[index] + 1);
            //回溯
            backTracking(numArrows - aliceArrows[index] - 1, index + 1, curVal + index);
            //清理
            stack.pop();
        }
        //不射这个靶位
        stack.push(0);
        backTracking(numArrows, index + 1, curVal);
        stack.pop();
    }

    public static void main(String[] args) {
        MaximumPointsInAnArchery2212 ins = new MaximumPointsInAnArchery2212();
//        int[] res = ins.maximumBobPoints(9, new int[]{1,1,0,1,0,0,2,1,0,1,2,0});
//        int[] res = ins.maximumBobPoints(3, new int[]{0,0,1,0,0,0,0,0,0,0,0,2});
        int[] res = ins.maximumBobPoints(89, new int[]{3,2,28,1,7,1,16,7,3,13,3,5});
        Arrays.stream(res).forEach(x -> System.out.print(x));
    }
}
