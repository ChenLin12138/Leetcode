package leetcode.backtracking.combinations;

import leetcode.dp.CountNumbersWithUniqueDigits;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MatchsticksToSquare {

  //如果长度不能被4整出，那么肯定是不行的。
  //需要计算出一个边长，长度不能超过这个平均边长。
  //需要从大到小排列火柴，这样回溯效率高
  int avg = 0;

  List<Stack<Integer>> sides = new ArrayList();
  List<Integer> sideLength = new ArrayList<>();
  public boolean makesquare(int[] matchsticks) {

    //边和边长的初始化
    for(int i = 0; i < 4; i++){
      sides.add(new Stack<>());
      sideLength.add(0);
    }

    int sum = getSum(matchsticks);
    if(!isDivideExactly(sum))
      return false;

    this.avg = getAvg(sum);

    //从大到小排序
    int[] sortedArr = Arrays.stream(matchsticks)
      .boxed()
      .sorted((num1, num2) -> num2.compareTo(num1))
      .mapToInt(Integer::intValue)
      .toArray();

    return backTracking(sortedArr);
  }

  private int getSum (int[] matchsticks){
    int sum = 0;
    for(Integer x : matchsticks){
      sum += x;
    }
    return sum;
  }

  private boolean isDivideExactly(int sum){
    return sum % 4 == 0;
  }

  private int getAvg(int sum){
    return sum / 4;
  }
  private boolean backTracking(int[] matchsticks){

    //退出条件
    if(matchsticks.length == 0){
      for(int i = 0; i < sideLength.size(); i ++){
        if(sideLength.get(i) != this.avg)
          return false;
      }
      return true;
    }
    //单层逻辑
    //每一个边放置的数是可以尝试的
    //我们回溯的把当前第一个火柴尝试放入每一条边。
    for(int i = 0; i < 4; i ++){
      //该边的长度
      if(sideLength.get(i) + matchsticks[0] <= avg){
        sides.get(i).push(matchsticks[0]);
        sideLength.set(i,sideLength.get(i) + matchsticks[0]);
        //回溯
        if(backTracking(Arrays.copyOfRange(matchsticks, 1, matchsticks.length))){
          return true;
        }
        //清理
        sides.get(i).pop();
        sideLength.set(i,sideLength.get(i) - matchsticks[0]);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    MatchsticksToSquare ins = new MatchsticksToSquare();
//    System.out.println(ins.makesquare(new int[]{1,1,2,2,2}));
//    System.out.println(ins.makesquare(new int[]{3,3,3,3,4}));
//    System.out.println(ins.makesquare(new int[]{2,2,2,2,2,6}));
//    System.out.println(ins.makesquare(new int[]{99,37,37,37,37,37,37,37,37,5}));
    System.out.println(ins.makesquare(new int[]{403,636,824,973,815,318,881,506,863,21,834,211,316,772,803}));
  }
}
