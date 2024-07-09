package leetcode.backtracking.chessboard;

public class SudokuSolver {
  public void solveSudoku(char[][] board) {
    backTracking(board, 0, 0);
  }

  //找到了必定返回true
  private boolean backTracking(char[][] board, int row, int col){
    //退出条件
    //尝试到最后一个元素那么就应该退出,因为意思就是填完表格了
    if(col == board[0].length){
      row ++;
      col = 0;
      if(row == board.length){
        for(int i = 0; i < board.length; i ++){
          for(int j = 0; j < board[0].length; j ++){
            System.out.print(board[i][j]+",");
          }
          System.out.println("");
        }
        return true;
      }
    }

    if(board[row][col] != '.' ){
      return backTracking(board, row, col + 1);
    }

    //选择元素
    for(int x = 1; x <= 9; x++){
      if(!isValid(board, row, col, x)){
        //是最后一个尝试，9都不合适，那么表示没有合适的数，则退回这个情况
        if (x == 9){
          return false;
        }
        //1-8不合适那么遍历下一个数字
        continue;
      }
      //接受元素
      board[row][col] = (char) ('0' + x);
      if(backTracking(board, row, col + 1))
        return true;
      //清理
      board[row][col] = '.';
    }

    return false;
  }

  private boolean isValid(char[][] board, int row, int col, int x){
    //水平方向数字不能重复
    for(int j = 0; j < board.length; j ++){
      if(board[row][j]  == (char) ('0' + x)){
        return false;
      }
    }
    //垂直方向数字不能重复
    for(int i = 0; i < board[row].length; i ++){
      if(board[i][col]  == (char) ('0' + x)){
        return false;
      }
    }
    //3*3的小方格中数字不能重复
    int startRow = row / 3 * 3;
    int startCol = col / 3 * 3;
    for(int i = startRow; i < startRow + 3; i ++){
      for(int j = startCol; j < startCol + 3; j ++){
        if(board[i][j] == (char) ('0' + x)){
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    SudokuSolver ins = new SudokuSolver();
    char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
    ins.solveSudoku(board);
  }
}
