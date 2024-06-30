package leetcode.backtracking.subsets;

import java.util.*;

public class NonDecreasingSubsequences491 {
  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> subSet = new Stack<>();
  public List<List<Integer>> findSubsequences(int[] nums) {
    backTracking(nums);
    return result;
  }

  private void backTracking(int[] nums) {

    //递增，至少2个元素,收集结果
    if(subSet.size() >= 2){
      result.add(new ArrayList<>(subSet));
    }

    //退出条件
    if(0 == nums.length){
      return;
    }
    //单层逻辑
    Set<Integer> used = new HashSet<>();
    for(int i = 0; i < nums.length; i++){
      //剪枝：
      //1.因为现在不能对输入序列排序了，以前的subSet.size != 0 && nums[i] == nums[i-1]的continue不在适用
      //应该修改为used.contains(nums[i])
      //2.如果现在的数字比前一个小，那么我们不选他
      //3.前面出现过的开头的数字，再次作为开头数字不应该加入计算
      if((used.contains(nums[i]) || (subSet.size() > 0 && nums[i] < subSet.peek()))){
        continue;
      }
      //选取
      subSet.push(nums[i]);
      //回溯
      backTracking(Arrays.copyOfRange(nums, i + 1, nums.length));
      //清理
      subSet.pop();
      used.add(nums[i]);
    }
  }

  public static void main(String[] args) {
    NonDecreasingSubsequences491 ins = new NonDecreasingSubsequences491();
//    List<List<Integer>> res = ins.findSubsequences(new int[]{4,6,7,7});
//    List<List<Integer>> res = ins.findSubsequences(new int[]{4,4,3,2,1});
    List<List<Integer>> res = ins.findSubsequences(new int[]{1,2,1,1,1});
    res.forEach(x -> System.out.println(x));
  }
}
