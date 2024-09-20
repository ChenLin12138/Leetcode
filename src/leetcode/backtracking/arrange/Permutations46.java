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
  //此题求全排列，没有重复元素所以不用考虑剪枝
  List<List<Integer>> res = new ArrayList<>();
  Stack<Integer> stack = new Stack<>();

  public List<List<Integer>> permute(int[] nums) {
    backTracking(nums);
    return res;
  }

  private void backTracking(int[] nums){
    //退出条件
    if(nums.length == 0){
      //收集结果
      res.add(new ArrayList<>(stack));
      return;
    }

    //单层逻辑
    for(int i = 0 ; i < nums.length; i ++){
      //选取
      stack.add(nums[i]);
      //回溯
      int[] newArray = new int[nums.length - 1];
      System.arraycopy(nums,0,newArray,0,i);
      System.arraycopy(nums,i+1,newArray,i,nums.length - i - 1);
      backTracking(newArray);
      //清理
      stack.pop();
    }
  }

	//此方法用于测试
	public static void main(String[] args) {
    Permutations46 ins = new Permutations46();
    List<List<Integer>> list = ins.permute(new int[] {1,2,3});
    System.out.println(list);
	}

}
