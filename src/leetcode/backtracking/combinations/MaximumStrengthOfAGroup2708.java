package leetcode.backtracking.combinations;

import java.util.Arrays;

//其实这题的本质就是对数组中的数字，选和不选的问题
//我发现自己还很喜欢做这类问题
public class MaximumStrengthOfAGroup2708 {
    private long res = Long.MIN_VALUE;
    private long max = 0;
    public long maxStrength(int[] nums) {
        if(nums.length == 1){
           return nums[0];
        }

        backTracking(nums);
        return res;
    }

    private void backTracking(int[] nums){
        //退出条件
        if(nums.length == 0){
            res = Math.max(max, res);
            return;
        }
        //单层逻辑
        //当前第一个数组选或者不选
        //思考一下减枝，结果不用剪
        //选
        long backMax = max;
        if(max == 0){
            max = nums[0];
        }else{
            max *= nums[0];
        }
        //回溯
        backTracking(Arrays.copyOfRange(nums,1, nums.length));
        //清理
        max = backMax;

        //不选
        backTracking(Arrays.copyOfRange(nums,1, nums.length));
    }

    public static void main(String[] args) {
        MaximumStrengthOfAGroup2708 ins = new MaximumStrengthOfAGroup2708();
//        System.out.println(ins.maxStrength(new int[]{3,-1,-5,2,5,-9}));
//        System.out.println(ins.maxStrength(new int[]{-4,-5,-4}));
//        System.out.println(ins.maxStrength(new int[]{0,-1}));
//        System.out.println(ins.maxStrength(new int[]{-9}));
        System.out.println(ins.maxStrength(new int[]{6,-3,-4,8,4,7,6,4,7,7,-3,-6,9}));

    }
}
