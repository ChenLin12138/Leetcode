package leetcode.backtracking.combinations;

import java.util.Arrays;

public class ClosestDessertCost1774 {
    //如果不能等于target,那么选择价格较低的方案
    //计算所有方案，一旦超过了那个超过target的最小值的方案，那么我们就终止
    //每种辅料都可以选择，而且可以选2种
    //这样的流程，选择基料
    //选择第一种辅料，也可以不选择
    //选择第二种辅料，也可以不选择
    //最接近target的最少的钱

    //配料的价格
    private int[] toppingCosts;
    private int result = Integer.MAX_VALUE;
    private int target = 0;


    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        this.toppingCosts = toppingCosts;
//        this.toppingSelected = new int[toppingCosts.length];

        //每一种基料的选择
        int cost = 0;
        for(int i = 0; i < baseCosts.length; i++){
            cost = baseCosts[i];
            backTracking(0,cost);
        }
        return result;
    }

    //这个函数用来处理配料的选择，每一种类配料都能选择
    //除了选择，还可以不选
    private void backTracking(int x, int cost){

        //这里需要不断刷新minVal.
        int deltaA = Math.abs(this.target - cost);
        int deltaB = Math.abs(this.target - result);

        if(deltaB > deltaA)
            this.result = cost;

        if(deltaB == deltaA && cost < result)
            this.result = cost;

        //退出条件
        if(cost >= this.target){
            return;
        }
        //单层逻辑
        //选择一种配料
        for(int i = x; i < toppingCosts.length; i ++){
            //每种配料选1次
            //回溯
            backTracking(i + 1,cost + toppingCosts[i]);
            //每种配料选2次
            //回溯
            backTracking(i + 1,cost + (2 * toppingCosts[i]));
        }
    }

    public static void main(String[] args) {
        ClosestDessertCost1774 ins = new ClosestDessertCost1774();
//        System.out.println(ins.closestCost(new int[]{1,7}, new int[]{3,4}, 10));
//        System.out.println(ins.closestCost(new int[]{2,3}, new int[]{4,5,100}, 18));
//        System.out.println(ins.closestCost(new int[]{3,10}, new int[]{2,5}, 9));
//        System.out.println(ins.closestCost(new int[]{10}, new int[]{1}, 1));
        System.out.println(ins.closestCost(new int[]{716,4707}, new int[]{399,7161,1043,8560,527,8067,117,1176,334,400}, 7371));
    }
}
