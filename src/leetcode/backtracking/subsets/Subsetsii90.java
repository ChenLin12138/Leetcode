package leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsetsii90 {

  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> subResult = new Stack<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    backTracking(nums);
    return result;
  }

  private void backTracking(int[] nums) {
    //收集结果,结果的收集是在每一个节点上的
    result.add(new ArrayList(subResult));

    //退出条件
    if(nums.length == 0){
      return;
    }
    //单层逻辑
    for(int i = 0; i < nums.length; i++){
      //剪枝:在树层上的重复元素，做一个分支的回溯就行。树层去重
      if(i > 0 && nums[i] == nums[i - 1]){
        continue;
      }
      //选取
      subResult.push(nums[i]);
      //回溯
      backTracking(Arrays.copyOfRange(nums, i + 1, nums.length));
      //清理
      subResult.pop();
    }

  }

  public static void main(String[] args) {
    Subsetsii90 ins = new Subsetsii90();
    ins.subsetsWithDup(new int[]{1,2,2});
  }

}
