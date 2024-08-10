package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber306 {
  List<Long> subResult = new ArrayList<>();

  //遍历各种数字组合
  //查询是否是累加
  //最终结果要分解到叶子结点才知道
  public boolean isAdditiveNumber(String num) {
    if(num.isEmpty())
      return false;

    return backTracking(num);
  }

  private boolean backTracking(String num){
    //退出条件,>2是防止不够2个时候的浑水摸鱼
    if(num.isEmpty() && subResult.size() > 2){
      return true;
    }

    //单层逻辑
    //减枝，如果p1+p2 < p3的开始，那么我们不用计算计算了
    //因为题目中谈论到数字长度<=35
    //那么我们只要包容这样的情况就行1999999999999999910000000000000000
    for(int i = 0; i < 18 && i < num.length(); i++){
      //生成一个新的数字
      //如果以0开头，那么我们应该break这个情况
      //这里要考虑02不能转变成2的问题
      if(num.substring(0,1).equals("0") && Long.parseLong(num.substring(0, i + 1)) > 0)
        break;

      Long selectedNum = Long.parseLong(num.substring(0, i + 1));

      if(subResult.size() < 2){
        //选取
        subResult.add(selectedNum);
        //回溯
        if(backTracking(num.substring(i + 1)))
          return true;
      }else{
        //选取
        subResult.add(selectedNum);

        //如果最近两个相加都<剩下的第一个数，那么就是没救了
        if(last2Sum() < selectedNum){
          subResult.remove(subResult.size() - 1);
          return false;
        }

        if(isValidNumber(selectedNum)){
          if(backTracking(num.substring(i + 1)))
            return true;
        }
      }
      //清理
      subResult.remove(subResult.size() - 1);
    }
    return false;
  }

  private Long last2Sum(){
    return subResult.get(subResult.size() - 2) + subResult.get(subResult.size() - 3);
  }

  private boolean isValidNumber(Long num){
    return num.equals(last2Sum());
  }


  public static void main(String[] args) {
//    System.out.println(Integer.parseInt("1991001199"));
    AdditiveNumber306 ins = new AdditiveNumber306();
//    System.out.println(ins.isAdditiveNumber("112358"));
//    System.out.println(ins.isAdditiveNumber("1023"));
//    System.out.println(ins.isAdditiveNumber("199100199"));
//    System.out.println(ins.isAdditiveNumber("19910011992"));
//    System.out.println(ins.isAdditiveNumber("11235813213455890144"));
    System.out.println(ins.isAdditiveNumber("1999999999999999910000000000000000"));
  }
}
