package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations77 {

  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer>subSet = new Stack<>();
  int size = 0;

  public List<List<Integer>> combine(int n, int k) {
    size = k;
    backTracking(1, n);
    return result;
  }

  public void backTracking(int begin, int end) {
    //退出条件:当size == k的时候退出
    if(subSet.size() == size){
      result.add(new ArrayList<Integer>(subSet));
      return ;
    }

    //单层逻辑
    //思考一下减枝还需要选取的元素个数<=剩余可选元素个数
    for(int i = begin; end - i + 1 > size - subSet.size(); i ++ ){
      //选择一个数
      subSet.push(i);
      //回溯
      backTracking(i + 1, end);
      //清理逻辑，保证subSet里面的数据回退
      subSet.pop();
    }
  }

  public static void main(String[] args) {
    Combinations77 ins = new Combinations77();
    List<List<Integer>> res = ins.combine(4,2);
    res.forEach(x -> System.out.println(x));
  }
}
