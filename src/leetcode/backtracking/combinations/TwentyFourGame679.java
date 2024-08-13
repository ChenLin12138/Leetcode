package leetcode.backtracking.combinations;

import java.util.Arrays;

public class TwentyFourGame679 {

  private static final double TARGET = 24;
  private static final double EPISLON = 1e-6;
  private double target = 0;

  public boolean judgePoint24(int[] cards) {
    double[] doubles = Arrays.stream(cards).asDoubleStream().toArray();
    return backTracking(doubles);
  }

  private boolean backTracking(double[] cards){
    //退出条件
    if (cards.length == 1){
      if(Math.abs(TARGET - cards[0]) < EPISLON){
        return true;
      }
      return false;
    }

    //单层逻辑
    //任意挑选两个数的组合，然后把他们四则元素了,这是一个组合问题
    for(int i = 0; i < cards.length; i ++){
      for(int j = i + 1; j < cards.length; j ++){
        boolean isValid = false;
        double[] newArray = new double[cards.length - 1];
        //这是是把j的位置删除了，然后把i的位置替换掉
        //拷贝j前面的元素
        System.arraycopy(cards, 0, newArray, 0,j);
        //拷贝j后面的元素
        System.arraycopy(cards, j+1, newArray, j,newArray.length - j);

        //接下来进行+ - * /
        //因为我们有true就返回了，那么我们不需要继续下面的事情了
        //+
        newArray[i] = cards[i] + cards[j];
        isValid = isValid || backTracking(newArray);

        // - 与被 -
        newArray[i] = cards[i] - cards[j];
        isValid = isValid || backTracking(newArray);

        newArray[i] = cards[j] - cards[i];
        isValid = isValid || backTracking(newArray);

        // *
        newArray[i] = cards[i] * cards[j];
        isValid = isValid || backTracking(newArray);

        // /与被/
        if(0 != cards[j]){
          newArray[i] = cards[i] / cards[j];
          isValid = isValid || backTracking(newArray);
        }

        if(0 != cards[i]){
          newArray[i] = cards[j] / cards[i];
          isValid = isValid || backTracking(newArray);
        }

        if(isValid)
          return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    TwentyFourGame679 ins = new TwentyFourGame679();
    System.out.println(ins.judgePoint24(new int[]{4,1,2,3}));
  }
}
