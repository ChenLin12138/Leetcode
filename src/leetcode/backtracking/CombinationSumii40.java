package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumii40 {

  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> subSet = new Stack<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    backtracking(candidates,target);
    return result;
  }

  public void backtracking(int[] candidates, int target){
    //退出条件
    if (target < 0)
      return;

    if(target == 0){
      result.add(new ArrayList<>(subSet));
      return;
    }

    //单层逻辑
    //去重逻辑,在排序后的树形结构中例如[1,1,2,5,6,7,10]
    //两个重复的1开头的数字，在同一层的时候，选择2次1是会导致重复的，所以在同层中可以去掉重复的数字。树层去重
    for(int i = 0; i < candidates.length; i++){
      //当前遍历元素和之前的元素相同，那么我们剪枝
      if(i > 0 && candidates[i] == candidates[i-1])
        continue;
      //选中一个选中一个元素
      subSet.push(candidates[i]);
      //回溯
      backtracking(Arrays.copyOfRange(candidates, i + 1 ,candidates.length), target - candidates[i]);
      //清理选中元素
      subSet.pop();
    }
  }


  public static void main(String[] args) {
    CombinationSumii40 ins = new CombinationSumii40();
    List<List<Integer>> res = ins.combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    res.forEach(x -> System.out.println(x));
  }
}
