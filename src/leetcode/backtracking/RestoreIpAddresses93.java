package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.Stack;

public class RestoreIpAddresses93 {

  List<String> result = new ArrayList<>();
  Stack<String> subSet = new Stack<>();

  public List<String> restoreIpAddresses(String s) {
    backTracking(s);
    return result;
  }

  public void backTracking(String s){
    //退出条件
    if(0 == s.length() && 4 == subSet.size()){
      StringBuffer sb = new StringBuffer();
      for(int i = 0; i < subSet.size(); i++){
        sb.append(subSet.get(i));
        if(i < subSet.size() - 1){
          sb.append(".");
        }
      }
      result.add(sb.toString());
      return;
    }

    //当前子串以0开始，那么就不能进行循环

    //单层逻辑
    for(int i = 0; i < s.length(); i ++){
      //减枝
      //ip已经分为4段了需要终止，当前一段ip>255需要终止
      if(subSet.size() == 4 || Integer.valueOf(s.substring(0,i + 1)) > 255){
        break;
      }

      //选取字段
      subSet.push(s.substring(0,i + 1));

      //回溯
      backTracking(s.substring(i + 1));

      //清理
      subSet.pop();

      //当前子串以0开始，那么就不能进行循环
      if(s.substring(0,1).equals("0")){
        break;
      }

    }
  }

  public static void main(String[] args) {
    RestoreIpAddresses93 ins = new RestoreIpAddresses93();
    List<String> res = ins.restoreIpAddresses("101023");
//    List<String> res = ins.restoreIpAddresses("0000");
//    List<String> res = ins.restoreIpAddresses("25525511135");

    res.forEach(x -> System.out.println(x));
  }
}
