package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning131 {

  List<List<String>> result = new ArrayList<>();
  Stack<String> subSet = new Stack<>();

  public List<List<String>> partition(String s) {
    backTracking(s);
    return result;
  }

  public void backTracking(String s){
    //退出条件
    if (0 == s.length()){
      result.add(new ArrayList<>(subSet));
      return;
    }

    //单层逻辑
    for(int i = 0; i < s.length(); i ++){
      //选取
      //如果当前元素已经不是回文了，那么退出整个树层,退出树层的方式是不再回溯
      if(!isPalindrome(s.substring(0,i + 1))){
        continue;
      }
      subSet.push(s.substring(0,i + 1));
      //回溯
      backTracking(s.substring(i + 1));
      //清理
      subSet.pop();
    }
    //去重逻辑
  }

  private boolean isPalindrome(String s){
    //回文用双指针判断
    int left = 0;
    int right = s.length() - 1;
    while(left < right){
      if(s.charAt(left) != s.charAt(right))
        return false;
      left ++;
      right --;
    }
    return true;
  }

  public static void main(String[] args) {
    PalindromePartitioning131 ins = new PalindromePartitioning131();
    List<List<String>> res = ins.partition("efe");
    res.forEach(x -> System.out.println(x));
  }
}
