package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {

  List<List<Integer>> result = new ArrayList<>();
  List<Integer> subSet = new ArrayList<>();
  int size = 0;

  public List<List<Integer>> combine(int n, int k) {
    size = k;
    backTracking(1, n);
    return result;
  }

  public void backTracking(int begin, int end) {
    //退出条件:当size == 2的时候退出
    if(subSet.size() == size){
      result.add(new ArrayList<Integer>(subSet));
      return ;
    }

    //单层逻辑
    for(int i = begin; i <=end; i ++ ){
      //选择一个数
      subSet.add(i);
      //回溯
      backTracking(i + 1, end);
      //清理逻辑，保证subSet里面的数据回退
      subSet.remove(subSet.size() - 1);
    }
  }

  public static void main(String[] args) {
    Combinations77 ins = new Combinations77();
    List<List<Integer>> res = ins.combine(4,2);
    res.forEach(x -> System.out.println(x));
  }
}
