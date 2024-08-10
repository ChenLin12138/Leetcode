package leetcode.dp;

import java.util.Arrays;

public class TargetSum494 {

  private int[] dp;
  public int findTargetSumWays(int[] nums, int target) {
    //需要把这个问题转换成在0-i范围内的nums，通过加法的方式凑成target的问题。
    int sum = getNumsSum(nums, target);
    //不能整除意味着没有符合条件的结果
    if ((sum + target) % 2 != 0) return 0;

    if(Math.abs(target) > sum) return 0;

    target = (sum + target) / 2;
    //问题已经转变
    //新问题是dp放到+的筒子里的目标为4的问题
    dp = new int[target + 1];
    Arrays.fill(dp,0);
    //背包容量为0的时候，始终只有一种方案。
    dp[0] = 1;
    //i 表示 0 - i的范围
    //j 表示 背包的容量
    for(int i =0; i < nums.length; i++){
      for(int j = target; j >= nums[i]; j --){
        dp[j] += dp[j - nums[i]];
      }
    }
    return dp[target];
  }

  private int getNumsSum(int[] nums, int target){
    int sum = 0;
    for(int i = 0; i < nums.length; i ++){
      sum += nums[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    TargetSum494 ins = new TargetSum494();
    int res = ins.findTargetSumWays(new int[]{100}, -200);
//    int res = ins.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    System.out.println(res);
  }

}
