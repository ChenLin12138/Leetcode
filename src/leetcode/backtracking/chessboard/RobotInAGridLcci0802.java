package leetcode.backtracking.chessboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RobotInAGridLcci0802 {
    //1代表不可通行
    //返回任意一条路径
    //找一条路，深度优先遍历更好
    List<List<Integer>> res = new ArrayList<>();
    Stack<List<Integer>> stack = new Stack<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return res;
        }
        List<Integer> pair = new ArrayList<>();
        pair.add(0);
        pair.add(0);
        stack.add(pair);
        backTracking(obstacleGrid, 0, 0);
        return res;
    }

    private boolean backTracking(int[][] obstacleGrid, int row, int col) {
        //退出条件
        //1.走到终点了
        if(row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1){
            for(int i = 0; i < stack.size(); i ++){
                res.add(stack.get(i));
            }
            return true;
        }
        //单层逻辑
        //1.走不动了
        //2.找到答案了都直接放弃
        //其实是有减枝的，一个节点如果他向右，或者向下走不动。那么其实应该标记起来。也把他设置成1.
        //向下
        if(downEnable(obstacleGrid, row, col)){
            row += 1;
            //选取
            List<Integer> pair = new ArrayList<>();
            pair.add(row);
            pair.add(col);
            stack.add(pair);
            //回溯
            if(backTracking(obstacleGrid, row, col)){
                return true;
            }
            //清理
            row -= 1;
            stack.pop();
        }

        //向右
        if(rightEnable(obstacleGrid, row, col)){
            col += 1;
            //选取
            List<Integer> pair = new ArrayList<>();
            pair.add(row);
            pair.add(col);
            stack.add(pair);
            //回溯
            if(backTracking(obstacleGrid,row,col)){
                return true;
            }
            //清理
            col -= 1;
            stack.pop();
        }

        //这里是已经尝试过向右和向下都走不通的情况了那么这个节点应该标记为走不通，为减枝用
        obstacleGrid[row][col] = 1;
        return false;
    }

    //检查是否能向下
    private boolean downEnable(int[][] obstacleGrid, int row, int col){
        if(row >= obstacleGrid.length - 1){
            return false;
        }
        row += 1;
        if(obstacleGrid[row][col] == 1)
            return false;
        return true;
    }

    //检查是否能向右
    private boolean rightEnable(int[][] obstacleGrid, int row, int col){
        if(col >= obstacleGrid[0].length - 1){
            return false;
        }
        col += 1;
        if(obstacleGrid[row][col] == 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        RobotInAGridLcci0802 ins = new RobotInAGridLcci0802();
//        List<List<Integer>> output = ins.pathWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
        List<List<Integer>> output = ins.pathWithObstacles(new int[][]{{1}});
        for(List<Integer> out : output){
            System.out.println(out);
        }
    }
}
