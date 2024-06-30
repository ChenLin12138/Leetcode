package leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Subsets78 {

  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> subResult = new Stack<>();

  public List<List<Integer>> subsets(int[] nums) {
    backTracking(nums);
    return result;
  }

  private void backTracking(int[] nums) {

    //收集结果
    result.add(new ArrayList<>(subResult));

    //终止条件
    if(nums.length == 0){
      return;
    }

    //单层逻辑
    //每个节点我们都需要取数
    for(int i = 0; i < nums.length; i ++){
      //选取
      subResult.add(nums[i]);
      //回溯
      backTracking(Arrays.copyOfRange(nums, i + 1, nums.length));
      //清理
      subResult.pop();
    }
    //减枝
  }

  public static void main(String[] args) {
    Subsets78 ins = new Subsets78();
    List<List<Integer>> res = ins.subsets(new int[]{1,2,3});
    res.forEach(x -> System.out.println(x));
  }

}
