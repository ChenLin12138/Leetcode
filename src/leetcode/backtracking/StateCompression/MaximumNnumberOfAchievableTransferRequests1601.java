package leetcode.backtracking.StateCompression;

import java.util.Arrays;

public class MaximumNnumberOfAchievableTransferRequests1601 {

  private static int OUT = 0;
  private static int IN = 1;

  public int maximumRequests(int n, int[][] requests) {
    int result = 0;
    //状态压缩的暴力扫描
    //请求16个 1 <= requests.length <= 16，那么有2^16次方种可能，看到这种应该就需要去联想状态压缩
    //1 <= n <= 20 房子20间
    //requests[i].length == 2 标注in和out的请求
    //暴力扫描2^16次方的选和不选的可能性，选择为0，不选为1
    for(int selectedBit = 0; selectedBit < (1<< requests.length); selectedBit ++){
      int selectedRequestNumber = Integer.bitCount(selectedBit);
      //减枝
      //如果选择的1的数量还没有当前的结果多，那么我们还搞个毛
      if(selectedRequestNumber <= result) continue;
      //现在开始判断这个request的选择方案是否合理
      if(isValideSolution(selectedBit,n,requests)){
        result = Math.max(result, selectedRequestNumber);
      }
    }

    return result;
  }

  //这个方法检查选择是否合理，合理的意思就是每一栋房子搬入的人的数量和搬出的人的数量是一致的
  private boolean isValideSolution(int selectedRequest, int n, int[][] requests) {
    boolean inOutBalance = true;
    //这里的balance表示的是第几个房子他的余额
    int[] balance = new int[n];
    Arrays.fill(balance,0);

    //遍历每一个请求
    for(int i = 0; i < requests.length; i ++){
      //i==0的时候，是从selectedRequest的最右边开始检查的,最右边就是第0位置
      //这里的i遍历的是选择，选择，选择，也就是文中的请求
      if(((selectedRequest >> i) & 1) == 1){
        //对应请求i里面需要在第几个房子里面搬出
        balance[requests[i][OUT]] --;
        balance[requests[i][IN]] ++;
      }
    }

    //搬入搬出后，balance的值应该为0
    for(int i = 0; i < balance.length; i ++){
      if(balance[i] != 0)
        return false;
    }

    return true;
  }

  public static void main(String[] args) {
    MaximumNnumberOfAchievableTransferRequests1601 ins = new MaximumNnumberOfAchievableTransferRequests1601();
//    System.out.println(ins.maximumRequests(5, new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}}));
//    System.out.println(ins.maximumRequests(3, new int[][]{{0,0},{1,2},{2,1}}));
    System.out.println(ins.maximumRequests(4, new int[][]{{0,3},{3,1},{1,2},{2,0}}));
  }
}
