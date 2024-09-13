package leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TheNumberOfBeautifulSubsets2597 {
    //现在就是所有组合都搞嘛，然后排除那些不美丽的
    int res = 0;
    Stack<Integer> stack = new Stack<>();
    public int beautifulSubsets(int[] nums, int k) {
        backTracking(nums, k);
        return res;
    }

    private void backTracking(int[] nums, int k){
        //需要在路径上收集结果
        if(!stack.isEmpty()){
            res ++;
        }
        //退出条件
        if(nums.length == 0){
            return;
        }

        //单层逻辑
        for(int i = 0; i < nums.length; i++){
            //如果stack中任意一个元素和当前元素的差距是k，那么我们放弃
            if(!isBeautiful(nums[i],k)){
                continue;
            }
            //选取
            stack.push(nums[i]);
            //回溯
            //考虑下减枝
            backTracking(Arrays.copyOfRange(nums,i+1, nums.length),k);
            //清理
            stack.pop();
        }
    }

    private boolean isBeautiful(int num, int k){
        for(int i = 0; i < stack.size(); i++){
            if(Math.abs(stack.get(i) - num) == k){
                //当前nums[i]不美丽
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TheNumberOfBeautifulSubsets2597 ins = new TheNumberOfBeautifulSubsets2597();
//        System.out.println(ins.beautifulSubsets(new int[]{2,4,6},2));
        System.out.println(ins.beautifulSubsets(new int[]{1},1));
    }
}
