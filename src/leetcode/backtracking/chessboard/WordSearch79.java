package leetcode.backtracking.chessboard;

import java.util.ArrayList;
import java.util.List;

public class WordSearch79 {

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

  //标记元素是否使用过的数据
  private boolean[][] usedMap;

  public boolean exist(char[][] board, String word) {
    //初始化标记元素是否使用过的数组
    this.usedMap = new boolean[board.length][board[0].length];
    for (int i = 0; i < this.usedMap.length; i++) {
      for (int j = 0; j < this.usedMap[i].length; j++) {
        this.usedMap[i][j] = false;
      }
    }

    //扫描到可以作为开头的单元格
    List<Pair> pairs = findBeginCell(board, word.charAt(0));
    for(Pair pair: pairs){
      this.usedMap[pair.x][pair.y] = true;
      if(backtracking(board, word, pair.x, pair.y))
        return true;
      this.usedMap[pair.x][pair.y] = false;
    }
    return false;
  }

  private List<Pair> findBeginCell(char[][] board, char target){
    List<Pair> list = new ArrayList<>();
    for(int i = 0; i < board.length; i ++){
      for(int j = 0; j < board[0].length; j ++){
        if(board[i][j] == target){
          list.add(new Pair(i,j));
        }
      }
    }
    return list;
  }

  private boolean backtracking(char[][] board, String word, int x, int y){

    //退出条件
    if(word.length() == 1 && word.charAt(0) == board[x][y])
        return true;

    //单层逻辑
    //试探邻居是否有合适的值
    //上边
    if(x - 1 >= 0 && !this.usedMap[x - 1][y] && board[x - 1][y] == word.charAt(1)){
      this.usedMap[x - 1][y] = true;
      if(backtracking(board, word.substring(1),  x - 1,  y))
        return true;
      this.usedMap[x - 1][y] = false;
    }

    //下边
    if(x + 1 < board.length && !this.usedMap[x + 1][y] && board[x + 1][y] == word.charAt(1)){
      this.usedMap[x + 1][y] = true;
      if(backtracking(board, word.substring(1),  x + 1,  y))
        return true;
      this.usedMap[x + 1][y] = false;
    }

    //左边
    if(y - 1 >= 0 && !this.usedMap[x][y - 1] && board[x][y - 1] == word.charAt(1)){
      //选取元素
      this.usedMap[x][y - 1] = true;
      if(backtracking(board, word.substring(1),  x,  y - 1))
        return true;
      //清理
      this.usedMap[x][y - 1] = false;
    }

    //右边
    if(y + 1 < board[0].length && !this.usedMap[x][y + 1] && board[x][y + 1] == word.charAt(1)){
      this.usedMap[x][y + 1] = true;
      if(backtracking(board, word.substring(1),  x,  y + 1))
        return true;
      this.usedMap[x][y + 1] = false;
    }

    return false;
  }

  public static void main(String[] args) {
    WordSearch79 ins = new WordSearch79();
//    boolean  result = ins.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
//    boolean  result = ins.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
//    boolean  result = ins.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
//    boolean  result = ins.exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB");
    boolean  result = ins.exist(new char[][]{{'A', 'A', 'A','A','A','A'}, {'A', 'A', 'A','A','A','A'}, {'A', 'A', 'A','A','A','A'},{'A', 'A', 'A','A','A','A'},{'A', 'A', 'A','A','A','A'},{'A', 'A', 'A','A','A','A'}}, "BAAAAAAAAAAAAAA");
    System.out.println(result);
  }
}
