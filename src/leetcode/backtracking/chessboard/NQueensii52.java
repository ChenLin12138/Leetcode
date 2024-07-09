package leetcode.backtracking.chessboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NQueensii52 {

  class Pair{
    private int x;
    private int y;

    public Pair (int x, int y){
      this.x = x;
      this.y = y;
    }

    public Pair (Pair pair){
      this.x = pair.getX();
      this.y = pair.getY();
    }

    private int getX() {
      return this.x;
    }

    private int getY() {
      return this.y;
    }
  }

  Stack<Pair> subSet = new Stack<>();
  int n = 0;
  int result = 0;

  public int totalNQueens(int n) {
    this.n = n;
    backTracking(new Pair(0,0));
    return result;
  }

  private void backTracking(Pair pair){
    //退出条件
    //完成棋盘的每一个格子的遍历
    //结果在叶子节点收集
    if(pair.getX() >= n){
      result ++;
      return;
    }
    //单层逻辑
    //在所在层遍历列
    for(int col = 0; col < this.n ; col ++){
      //剪枝
      //新添加的节点不能与选中的元素中的任何一个在同一列。
      //新添加的加点不能与选中元素中的任何一个在
      if(!isValidPosition(pair.getX(), col)){
        continue;
      }
      //选取
      subSet.push(new Pair(pair.getX(), col));
      //回溯
      backTracking(new Pair(pair.getX() + 1, 0));
      //清理
      subSet.pop();
    }
  }

  //合法性判断就是验证当前元素是否在选中元素中
  //垂直方向
  //左斜线，右斜线方向是否存在元素
  private boolean isValidPosition(int x, int y){
    //棋盘选中元素为空那么直接true
    if(subSet.isEmpty()){
      return true;
    }
    List<Pair> list = new ArrayList<>(subSet);
    //垂直方向
    for(int i = list.size() - 1; i >= 0; i --){
      if (list.get(i).getY() == y)
        return false;
    }
    //斜线方向
    int delta = 1;
    for(int i = list.size() - 1; i >= 0; i --){
      if (y + delta == list.get(i).getY() || y - delta == list.get(i).getY()){
        return false;
      }
      delta ++;
    }
    return true;
  }

  public static void main(String[] args) {
    NQueensii52 ins = new NQueensii52();
    int res = ins.totalNQueens(4);
    System.out.println(res);
  }
}
