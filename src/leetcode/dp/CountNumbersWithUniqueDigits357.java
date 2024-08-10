package leetcode.dp;

import java.util.Arrays;

public class CountNumbersWithUniqueDigits357 {

  //n = 0, 1
  //n = 1, 10
  //n = 2, 9 * 9 + f(1)
  //n = 3, 9 * 9 * 8 + f(2)
  int[] result;
  public int countNumbersWithUniqueDigits(int n) {
    result = new int[n + 1];
    Arrays.fill(result, 0);
    result[0] = 1;

    if(n >= 1)
      result[1] = 10;

    for(int i = 2; i <= n; i ++){
      int val = 9;
      for(int j = 9; j > 9 - i + 1; j --){
        val *= j;
      }
      result[i] = result[i - 1] + val;
    }

    return result[n];
  }

  public static void main(String[] args) {
    CountNumbersWithUniqueDigits357 ins = new CountNumbersWithUniqueDigits357();
    System.out.println(ins.countNumbersWithUniqueDigits(4));
  }
}
