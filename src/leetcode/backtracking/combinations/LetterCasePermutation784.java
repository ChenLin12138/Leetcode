package leetcode.backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
  //字母可以变化大小，数字不行，这不就是一个组合问题吗
  List<String> result = new ArrayList<>();
  public List<String> letterCasePermutation(String s) {
    backTracking(s,"");
    return result;
  }

  private void backTracking(String s, String path){
    //退出条件
    if(s.length() == 0){
      result.add(path);
      return;
    }

    //单层逻辑
    //选取
    char curr = s.charAt(0);
    //还有其他剪枝逻辑
    //剪枝 : 数字跳过,但是我们把这个数字添加到path中
    if(Character.isDigit(s.charAt(0))){
      StringBuffer sb = new StringBuffer(path);
      sb.append(curr);
      path = sb.toString();
      backTracking(s.substring(1,s.length()),path.toString());
      return;
    }

    //添加为小写
    StringBuffer sbLower = new StringBuffer(path);
    sbLower.append(Character.toLowerCase(curr));
    //回溯
    backTracking(s.substring(1,s.length()),sbLower.toString());

    //添加为大写
    StringBuffer sbUpper = new StringBuffer(path);
    sbUpper.append(Character.toUpperCase(curr));
    //回溯
    backTracking(s.substring(1,s.length()),sbUpper.toString());

  }
  public static void main(String[] args) {
    LetterCasePermutation784 ins = new LetterCasePermutation784();
    System.out.println(ins.letterCasePermutation("3z4"));
  }
}
