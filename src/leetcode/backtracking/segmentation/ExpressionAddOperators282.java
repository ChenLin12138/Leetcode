package leetcode.backtracking.segmentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators282 {
  private List<String> result = new ArrayList<>();
  private Stack<String> operationStack = new Stack<>();
  private Stack<Long> numberStack = new Stack<>();
  int sum = 0;
  public List<String> addOperators(String num, int target) {
    backTracking(num,target, 0, 0);
    return result;
  }

  private void backTracking(String num, long target, long sum, long prev){
    //退出条件
    if("".equals(num) && target == sum && !numberStack.isEmpty()){
      StringBuffer sb = new StringBuffer();
      sb.append(numberStack.get(0));
      for(int i = 0; i < operationStack.size(); i ++){
        sb.append(operationStack.get(i));
        sb.append(numberStack.get(i+1));
      }
      result.add(sb.toString());
      return;
    }
    if(null == num || "".equals(num))
      return;

    //单层逻辑
    //有一种情况我没考虑，105可以理解为10-5这样的逻辑
    for(int i = 0; i < num.length(); i ++){
      //0可以参与计算，但是05不能参与计算
      if (i > 0 && num.charAt(0) == '0') {
        break;
      }
      //获取当前要计算的数字
      long cur = Long.parseLong(num.substring(0, i + 1));

      if(numberStack.isEmpty()){
        numberStack.push(cur);
        sum = cur;
        backTracking(num.substring(i+1),target, sum, cur);
        numberStack.pop();
      }else{
        //这里你不过是遍历+，-，*
        //处理加法
        sum = sum + cur;
        numberStack.push(cur);
        operationStack.push("+");
        backTracking(num.substring(i+1),target, sum, cur);
        //清理
        sum = sum - cur;
        numberStack.pop();
        operationStack.pop();

        //处理减法
        sum = sum - cur;
        numberStack.push(cur);
        operationStack.push("-");
        backTracking(num.substring(i+1),target, sum, -cur);
        //清理
        sum = sum + cur;
        numberStack.pop();
        operationStack.pop();

        //处理乘法
        long tempSum = sum;
        if(!numberStack.isEmpty())
          sum = (sum - prev) + (prev * cur);

        numberStack.push(cur);
        operationStack.push("*");
        backTracking(num.substring(i+1),target, sum, prev * cur);
        //清理
        sum = tempSum;
        numberStack.pop();
        operationStack.pop();
      }
    }
  }

  public static void main(String[] args) {

    ExpressionAddOperators282 ins = new ExpressionAddOperators282();
//    List<String>  result =  ins.addOperators("232",8);
//    List<String>  result =  ins.addOperators("123",6);
//    List<String>  result =  ins.addOperators("105",5);
//    List<String>  result =  ins.addOperators("3456237490",9191);
//    List<String>  result =  ins.addOperators("00",0);
//    List<String>  result =  ins.addOperators("123456789",45);
//    List<String>  result =  ins.addOperators("1234",3);
//    List<String>  result =  ins.addOperators("2147483647",2147483647);
    List<String>  result =  ins.addOperators("23",23);
//    System.out.println(result);
    result.forEach(x -> System.out.println(x));
  }
}
