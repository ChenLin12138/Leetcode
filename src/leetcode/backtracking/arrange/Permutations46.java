package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Chen Lin
 * @date 2021-09-12
 */

public class Permutations46 {

  List<List<Integer>> res = new ArrayList<>();
  Stack<Integer> stack = new Stack<>();

  public List<List<Integer>> permute(int[] nums) {
    backTracking(nums);
    return res;
  }

  private void backTracking(int[] nums) {
    //退出条件
    if(nums.length == 0){
      res.add(new ArrayList<>(stack));
      return;
    }

    //单层逻辑
    for(int i = 0; i < nums.length; i ++){
      //选取
      stack.add(nums[i]);
      //回溯
      int[] subSet = new int[nums.length - 1];
      System.arraycopy(nums,0,subSet,0,i);
      System.arraycopy(nums,i+1,subSet,i,nums.length - 1 - i);
      backTracking(subSet);
      //清理
      stack.pop();
    }
  }
}
