package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSumiii216 {

  //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件
  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> subSet = new Stack<>();
  int end = 9;
  int totalSize = 0;

  public List<List<Integer>> combinationSum3(int k, int n) {
    totalSize = k;
    backTracking(1,n,k);
    return result;
  }

  public void backTracking(int begin, int target, int size){
    //退出条件
    //最终你想找到的都是一个值为确定target的数
    if(0 == target && 0 == size){
      result.add(new ArrayList<>(subSet));
      return;
    }

    //单层逻辑
    //剪枝：既然有和和数量两个维度的控制，那么剪枝也可以从这两个维度入手
    //1. 目前数字的和已经>目标
    //2. 当前剩余的元素已经无法凑够k个数组合的要求
    for(int i = begin; target - i >= 0 &&  end - i + 1 >= size; i ++){
      //选择一个数
      subSet.push(i);
      //回溯
      backTracking(i + 1, target - i, size - 1);
      //清理当前回溯
      subSet.pop();
    }
  }

  public static void main(String[] args) {
    CombinationSumiii216 ins = new CombinationSumiii216();
    List<List<Integer>> res = ins.combinationSum3(9,45);
    res.forEach(x -> System.out.println(x));
  }
}
