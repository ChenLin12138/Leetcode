package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BeautifulArrangement526 {

  //这不就是一个全排列的问题吗，当然所有的数据都是要用完的
  Stack<Integer> subResult = new Stack<>();
  int count = 0;
  public int countArrangement(int n) {
    List<Integer> list = new ArrayList<>();

    for(int i = 1; i <= n; i ++){
      list.add(i);
    }
    backTracking(list);

    return count;
  }

  //尝试全排列，然后一个一个确认他们是否合法
  private void backTracking(List<Integer> list){
    //退出条件
    if(list.isEmpty()){
      count ++;
      return;
    }
    //单层逻辑
    //剪枝
    //注意这里的index
    for(int i = 0; i < list.size(); i ++){
      //选取
      subResult.push(list.get(i));
        //我们这里的index是从1开始的
      if(isValid(subResult.size(), list.get(i))){
        //回溯的逻辑是当前的数字不要
        List<Integer> newList = new ArrayList<>(list);
        newList.remove(i);
        backTracking(newList);
      }
      //清理
      subResult.pop();
    }
  }

  private boolean isValid(int index, int val){
    if(index % val == 0 || val % index == 0)
      return true;
    return false;
  }

  public static void main(String[] args) {
    BeautifulArrangement526 ins = new BeautifulArrangement526();
    System.out.println(ins.countArrangement(3));
    System.out.println("sff");
  }
}
