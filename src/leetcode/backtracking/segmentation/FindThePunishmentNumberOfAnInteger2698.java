package leetcode.backtracking.segmentation;

public class FindThePunishmentNumberOfAnInteger2698 {

  private int[] square;
  int sum = 0;
  public int punishmentNumber(int n) {
    square = new int[n + 1];
    square = fillSquare(square, n);

    for(int i = 1; i < square.length; i ++){
      if(isPunishmentNumber(square[i],i)){
        sum += square[i];
      }
    }
    return sum;
  }
  //squareNumber通过拆分相加可以得到index
  private boolean isPunishmentNumber(int squareNumber, int index){
    String str = String.valueOf(squareNumber);
    return backTracking(str, index);
  }

  private boolean backTracking(String squareNumber, int target){
    //退出条件
    if(squareNumber.length() == 0){
      if(target == 0)
        return true;

      return false;
    }

    //单层逻辑
    //遍历每一个元素的组合情况。
    for(int i = 0; i < squareNumber.length(); i ++){
      //选取
      String subStr = squareNumber.substring(0, i + 1);
      //回溯
      if(backTracking(squareNumber.substring(i+1,squareNumber.length()),target - Integer.valueOf(subStr)))
        return true;
      //清理
    }
    return false;
  }

  //判断一个数他经过拆分后是否能相加等于他的下标
  private int[] fillSquare(int[] square, int n) {
    for(int i = 0; i <= n; i ++){
      square[i] = i * i;
    }
    return square;
  }

  public static void main(String[] args) {
    FindThePunishmentNumberOfAnInteger2698 ins = new FindThePunishmentNumberOfAnInteger2698();
    System.out.println(ins.punishmentNumber(37));
  }
}
