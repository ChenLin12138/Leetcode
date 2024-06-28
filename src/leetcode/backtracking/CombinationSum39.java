package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSum39 {
  List<List<Integer>> result = new ArrayList<List<Integer>>();
  List<Integer> subSet = new ArrayList<Integer>();

  //既然是组合问题就用回溯
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //先排一个序，方便后面剪枝
    Arrays.sort(candidates);
    backTracking(candidates, target);
    return result;
  }

  public void backTracking(int[] candidates, int target){

    // System.out.println("当前的candidates:");
    // for(int i = 0; i < candidates.length; i ++){
    //     System.out.print(","+candidates[i]);
    // }
    // System.out.println("");

    // System.out.println("当前的subSet:");
    // subSet.forEach(x -> System.out.print(x));
    // System.out.println("");
    // System.out.println("当前的target:"+target);

    //退出条件
    //既然都大于了，那就完犊子了。结束
    if(0 >target){
      return;
    }
    //既然等于，那就添加答案结束
    if(0 == target){
      // System.out.println("Are you ok");
      //需要保证这里存储的是副本，因为在清理阶段这个subSet会被清理掉
      result.add(new ArrayList(subSet));
      return;
    }

    //单层逻辑
    //减枝的逻辑，应该在调用回溯的地方思考，我们现在是有序集合，如果target已经<0了，那么应该不需要后续的循环
    for(int i = 0; i < candidates.length  && target >= 0; i ++){
      //选择一个数
      subSet.add(candidates[i]);
      target -= candidates[i];
      //新的candidates应该是从当前candidates[i]开始的集合
      int [] nextCandidates = Arrays.copyOfRange(candidates,i, candidates.length);
      //开始回溯
      backTracking(nextCandidates, target);
      //清理逻辑，保持subSet干净，保证target正确
      subSet.remove(subSet.size() - 1);
      target += candidates[i];
    }
  }
  public static void main(String[] args) {
    CombinationSum39 ins = new CombinationSum39();
    List<List<Integer>> res = ins.combinationSum(new int[] {2,3,6,7},7);
    res.forEach(x -> System.out.println(x));
  }
}
