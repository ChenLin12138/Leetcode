package leetcode.backtracking.combinations;

import java.util.*;

public class RemoveInvalidParentheses301 {

  List<String> result = new ArrayList<>();

  int rl = 0;
  int rr = 0;

  public List<String> removeInvalidParentheses(String s) {
    calBracket(s);
    backTracking(0, rl, rr, s);
    if(result.isEmpty())
      result.add("");
    return result;
  }

  //计算需要移除的左右括号的数量
  private void calBracket(String s){
    for(int i = 0; i < s.length(); i ++){
      if(s.charAt(i) == '(') rl ++;
      if(s.charAt(i) == ')'){
        if(rl > 0){
          rl --;
        }else{
          rr ++;
        }
      }
    }
  }

  private void backTracking(int begin, int rl, int rr, String s){
    //退出条件
    if(rl == 0 && rr == 0){
      if(isValid(s)){
        result.add(s);
      }
      return;
    }
    //单层逻辑
    //尝试去不断删除括号
    //begin其实是一个减枝的逻辑，删除过的括号只能向后，比如)(删除)成为(校验一次，然后删除(成为null
    //然后删除(成为)校验一次，然后再删除)成为null又校验一次。
    for(int i = begin; i < s.length(); i ++){
      //减枝：如果((),或者())的情况，那么删除前面和后面任何一个(和)都是一样的。
      //前后效果一样的时候，做前面的会简单一些
      if(i > 0 && s.charAt(i) == s.charAt(i-1)){
        continue;
      }
      //删除左括号的情况
      if(s.charAt(i) == '(' && rl > 0){
        String newString = s.substring(0,i) + s.substring(i+1);
        rl --;
        backTracking(i, rl, rr, newString);
        rl ++;
      }

      //删除右括号的情况
      if(s.charAt(i) == ')' && rr > 0){
        String newString = s.substring(0,i) + s.substring(i+1);
        rr --;
        backTracking(i, rl, rr, newString);
        rr ++;
      }
    }
  }
  //判断输出是否合法
  private boolean isValid(String s){
    //这个Stack为null则合法
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); i ++){
      char c = s.charAt(i);
      if(c != '(' && c != ')') continue;
      if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
        stack.pop();
        continue;
      }
      stack.push(c);
    }
    return stack.isEmpty();
  }

  //计算左右的括号数量
  public static void main(String[] args) {
    RemoveInvalidParentheses301 ins = new RemoveInvalidParentheses301();
    ins.isValid("(())()");
//    List<String> list = ins.removeInvalidParentheses("()())()");
//    List<String> list = ins.removeInvalidParentheses("(())(");
//    List<String> list = ins.removeInvalidParentheses(")()m)(((()((()((((");
//    List<String> list = ins.removeInvalidParentheses(")(");
    List<String> list = ins.removeInvalidParentheses("))");
//    System.out.println("");
    list.forEach(x -> System.out.println(x));
  }
}
