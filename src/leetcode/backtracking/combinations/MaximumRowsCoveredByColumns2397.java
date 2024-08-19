package leetcode.backtracking.combinations;

import java.util.*;

public class MaximumRowsCoveredByColumns2397 {

  public int maximumRows(int[][] matrix, int numSelect) {
    int result = 0;
    //matrix 每行转成一个二进制int[]
    int [] rowbitArray = new int[matrix.length];
    for(int i = 0 ; i < matrix.length; i ++){
      for(int j = 0; j < matrix[0].length; j ++){
        //将数组matrix中的每一行转成一个数组
        rowbitArray[i] |= matrix[i][j] << (matrix[0].length - j - 1);
      }
    }

    //在matrix的列长度中，生成numSelect个1
    for(int i = 0 ; i <  (1 <<matrix[0].length); i ++){
      //这里是选任意的数字。
      int count = 0;
      //到这里选中的数字中有了numSelect个1
      if(Integer.bitCount(i) == numSelect){
        //这里就是一个新的列选择项
        for(int j = 0; j < rowbitArray.length; j ++){
          //如果一行中所有的 1 都被你选中的列所覆盖，则认为这一行被覆盖了
          //那么意味着行里数据rowbitArray里的1都被当前的i覆盖,
          //那么rowbitArray是i的子集
          if ((rowbitArray[j] | i) == i)
            count ++;
        }
      }
      result = Math.max(count,result);
    }
    return result;
  }

  public static void main(String[] args) {
    MaximumRowsCoveredByColumns2397 ins = new MaximumRowsCoveredByColumns2397();
//    System.out.println(ins.maximumRows(new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,0,1}},2));
//    System.out.println(ins.maximumRows(new int[][]{{1},{0}},1));
//    Set<Integer> set = new HashSet();
//    set.add(0);
//    set.add(1);
//    set.add(3);
//    set.add(4);
//    set.add(5);
//    ins.getCoveredCount(new int[][]{{1,0,0,0,0,0,0},{0,1,0,1,1,1,1},{0,0,0,1,0,0,1}},set);
//    System.out.println(ins.maximumRows(new int[][]{{1,0,0,0,0,0,0},{0,1,0,1,1,1,1},{0,0,0,1,0,0,1}},5));
    System.out.println(ins.maximumRows(new int[][]{
      {1,0,1,1,0,1,0,1,1,1,0,0},
      {1,0,1,0,0,1,0,0,1,1,0,0},
      {0,1,0,1,0,1,1,0,0,0,1,0},
      {1,0,0,1,0,1,1,0,0,0,1,0},
      {1,1,0,0,1,1,1,0,0,1,1,0},
      {0,1,1,1,1,0,1,0,0,0,1,1},
      {1,0,1,1,1,1,1,0,0,0,0,0},
      {0,0,0,0,1,0,0,1,1,0,1,0},
      {0,0,1,0,0,0,0,1,1,1,1,1}},8));
  }
}
