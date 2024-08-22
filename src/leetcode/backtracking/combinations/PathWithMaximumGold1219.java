package leetcode.backtracking.combinations;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PathWithMaximumGold1219 {

    private int max = 0;
    //测试路径
//    private Stack<Integer> stack = new Stack<>();
    public int getMaximumGold(int[][] grid) {
        //支持从任意一个点开始
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                backTracking(grid, i, j, 0);
            }
        }
        //测试代码
//        backTracking(grid,4,2,0);
        return max;
    }

    private void backTracking(int [][] grid, int row, int col, int curVal){
        //退出条件
        //无处可去
        if(!hasPlaceToMove(grid, row, col)){
            max = Math.max(max, curVal + grid[row][col]);
            return;
        }

        //单层逻辑
        //累计当前值
        curVal += grid[row][col];
        //测试路径
//        stack.push(grid[row][col]);
        //表示当前矿挖过了
        int backUpVal = grid[row][col];
        grid[row][col] = 0;

        //上
        if(isAbleMoveUp(grid, row, col)){
            //选择
            row -= 1;
            //回溯
            backTracking(grid, row, col, curVal);
            //清理
            row += 1;
        }
        //下
        if(isAbleMoveDown(grid, row, col)){
            //选择
            row += 1;
            //回溯
            backTracking(grid, row, col, curVal);
            //清理
            row -= 1;
        }
        //左
        if(isAbleMoveLeft(grid, row, col)){
            //选择
            col -= 1;
            //回溯
            backTracking(grid, row, col, curVal);
            //清理
            col += 1;
        }
        //右
        if(isAbleMoveRight(grid, row, col)){
            //选择
            col += 1;
            //回溯
            backTracking(grid, row, col, curVal);
            //清理
            col -= 1;
        }
        //清理
        //表示当前矿挖过了
        grid[row][col] = backUpVal;
        //测试路径
//        stack.pop();
    }

    private boolean hasPlaceToMove(int [][] grid, int row, int col){
        return isAbleMoveUp(grid, row, col) || isAbleMoveDown(grid, row, col)
                || isAbleMoveLeft(grid, row, col) || isAbleMoveRight(grid, row, col);
    }

    private boolean isAbleMoveUp(int [][] grid, int row, int col){
        row = row - 1;
        //已经是最高的位置了或者这个位置没有矿
        if(row < 0 || grid[row][col] == 0) return false;
        return true;
    }

    private boolean isAbleMoveDown(int [][] grid, int row, int col){
        row = row + 1;
        if(row >= grid.length || grid[row][col] == 0) return false;
        return true;
    }

    private boolean isAbleMoveLeft(int [][] grid, int row, int col){
        col = col - 1;
        if(col < 0 || grid[row][col] == 0) return false;
        return true;
    }

    private boolean isAbleMoveRight(int [][] grid, int row, int col){
        col = col + 1;
        if(col >= grid[0].length  || grid[row][col] == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        PathWithMaximumGold1219 ins = new PathWithMaximumGold1219();
//        System.out.println(ins.getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
//        System.out.println(ins.getMaximumGold(new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}));
        System.out.println(ins.getMaximumGold(new int[][]{{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}}));
    }

}
