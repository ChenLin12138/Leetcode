package leetcode.backtracking.chessboard;

import java.util.*;

public class WordSearchii212 {

  //m*n的矩阵规模不大于规模 12*12
  //单个单词长度不<=10

  //标记元素是否使用过的数据
  private boolean[][] usedMap;

  private StringBuffer sb = new StringBuffer();
  private Set<String> wordsSet = new HashSet<>();

  private Set<String> result = new HashSet<>();

  public List<String> findWords(char[][] board, String[] words) {
    for(int i = 0; i < words.length; i ++){
      wordsSet.add(words[i]);
    }

    //初始化标记元素是否使用过的数组
    this.usedMap = new boolean[board.length][board[0].length];
    for (int i = 0; i < this.usedMap.length; i++) {
      for (int j = 0; j < this.usedMap[i].length; j++) {
        this.usedMap[i][j] = false;
      }
    }
    //这是一个可以从任何地方开始的回溯
    //所以我们扫描每一个单元格
    for(int i = 0; i < board.length; i ++){
      for(int j = 0; j < board[0].length; j ++){
        sb.append(board[i][j]);
        this.usedMap[i][j] = true;
        backtracking(board, i, j);
        sb.deleteCharAt(sb.length() - 1);
        this.usedMap[i][j] = false;
      }
    }

    return new ArrayList<>(result);
  }


  private void backtracking(char[][] board, int x, int y){

    //收集结果
    if(wordsSet.contains(sb.toString()))
      result.add(sb.toString());

    //退出条件
    if(sb.length() == 10)
      return;

    //单层逻辑
    //试探邻居是否有合适的值
    //上边
    if(x - 1 >= 0 && !this.usedMap[x - 1][y]){
      //选取元素
      sb.append(board[x - 1][y]);
      this.usedMap[x - 1][y] = true;
      //回溯
      backtracking(board,  x - 1,  y);

      //清理元素
      this.usedMap[x - 1][y] = false;
      sb.deleteCharAt(sb.length() - 1);
    }

    //下边
    if(x + 1 < board.length && !this.usedMap[x + 1][y]){
      this.usedMap[x + 1][y] = true;
      sb.append(board[x + 1][y]);
      backtracking(board,x + 1,  y);

      this.usedMap[x + 1][y] = false;
      sb.deleteCharAt(sb.length() - 1);
    }

    //左面
    if(y - 1 >= 0 && !this.usedMap[x][y - 1]){
      //选取元素
      this.usedMap[x][y - 1] = true;
      sb.append(board[x][y - 1]);
      backtracking(board,  x,  y - 1);

      //清理
      this.usedMap[x][y - 1] = false;
      sb.deleteCharAt(sb.length() - 1);
    }

    //右面
    if(y + 1 < board[0].length && !this.usedMap[x][y + 1]){
      this.usedMap[x][y + 1] = true;
      sb.append(board[x][y + 1]);

      backtracking(board,  x,  y + 1);

      this.usedMap[x][y + 1] = false;
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public static void main(String[] args) {
    WordSearchii212 ins = new WordSearchii212();
    List<String> result = ins.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},{'i', 'f', 'l', 'v'}}, new String[]{"oath","pea","eat","rain"});
//    List<String> result = ins.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abdc"});
//    List<String> result = ins.findWords(new char[][]{{'a'}}, new String[]{"a"});
    result.forEach(x -> System.out.println(x));
  }
}
