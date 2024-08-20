package leetcode.backtracking.segmentation;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates816 {

  //首先去掉左右括号
  //用逗号拆分左右数字
  //在拆分后的数字中用小数点进行拆分。
  //不合法的狮子过滤，整数部分不允许以0开头。
  //小数部分不允许用0结尾
  //这个题目应该是很简单的，因为无论","和"."在一个数字中只能使用一次。是我自己想复杂了
  private static String COMMA = ", ";
  private static String DOT = ".";
  List<String> results = new ArrayList<>();

  public List<String> ambiguousCoordinates(String s) {
    //去掉头部和尾部的括号
    String trimedString = s.substring(1,s.length() - 1);

    //","拆分
    //因为在最后一个数字后面去加逗号是没有意义的，所以我们到trimedString.length() - 1截止
    for(int i = 0; i < trimedString.length(); i++){
      String left = trimedString.substring(0,i+1);
      String right = trimedString.substring(i+1,trimedString.length());
      String validLeft;
      String validRight;

      for(int j = 0; j < left.length(); j++){
        //生成一个逗号左边的新有效的数字

        if (left.length() < 2){
          validLeft = left;
        }else{
          String leftIntStr = left.substring(0,j+1);
          if(!isValidInteger(leftIntStr)) continue;

          String leftPointStr = left.substring(j+1,left.length());
          if(!isValidPoint(leftPointStr)) continue;

          if(leftPointStr.isEmpty()){
            validLeft = leftIntStr;
          }else {
            validLeft = leftIntStr + DOT + leftPointStr;
          }
        }

        for(int k = 0; k < right.length(); k ++){
          //生成一个逗号右边的新有效的数字
          if(right.length() < 2){
            validRight = right;
          }else{
            String rightIntStr = right.substring(0,k + 1);
            if(!isValidInteger(rightIntStr)) continue;

            String rightPointStr = right.substring(k + 1,right.length());
            if(!isValidPoint(rightPointStr)) continue;

            if(rightPointStr.isEmpty()){
              validRight = rightIntStr;
            }else {
              validRight = rightIntStr + DOT + rightPointStr;
            }
          }

          String result = "("+ validLeft + COMMA + validRight + ")";
          results.add(result);
        }
      }
    }
    return results;
  }

  //整数部分不以0开头
  private boolean isValidInteger(String str){
    //整数部分不能为空
    if(str.isEmpty()) return false;
    return str.charAt(0) == '0' && str.length() > 1 ? false : true;
  }
  //小数部分不以0结尾
  private boolean isValidPoint(String str){
    //小数部分可以以为空
    if(str.isEmpty()) return true;
    return str.charAt(str.length() - 1) == '0' ? false : true;
  }

  public static void main(String[] args) {
    AmbiguousCoordinates816 ins = new AmbiguousCoordinates816();
    System.out.println(ins.ambiguousCoordinates("(123)"));
//    System.out.println(ins.ambiguousCoordinates("(00011)"));
//    System.out.println(ins.ambiguousCoordinates("(0123)"));
//    System.out.println(ins.ambiguousCoordinates("(100)"));
  }
}
