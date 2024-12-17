package leetcode.dfs;

public class NumberOfClosedIslands1254 {
    private int res = 0;
    private boolean[][] countedLand;
    //因为要求的是封闭岛屿。
    //所有边界上的值都不需要遍历。
    public int closedIsland(int[][] grid) {
        countedLand = new boolean[grid.length][grid[0].length];
        for(int i = 1; i < grid.length - 1; i ++){
            for(int j = 1; j < grid[0].length - 1; j ++){
                //只有陆地才有检查的必要
                if(!countedLand[i][j] && grid[i][j] == 0){
                    if(dfs(grid,i,j))
                        res ++;
                }

            }
        }
        return res;
    }

    private boolean dfs (int[][] grid, int row, int col){
        //退出条件
        //如果是计算过的土地也需要退出
        if(countedLand[row][col]){
            return true;
        }

        //是水就要退出
        if(grid[row][col] == 1){
            countedLand[row][col] = true;
            return true;
        }

        //标记这块土地已经被计算过了，其实走到这里已经暗自包含了这个土地不是水，一定是一块陆地
        countedLand[row][col] = true;

        //是边界了并且是陆地也要退出，而且他就不应该统计。
        if(row == 0 || row == grid.length - 1|| col == 0 || col == grid[0].length - 1){
            return false;
        }

        //单层逻辑
        boolean flag = true;
        //现在需要对上下左右进行检查
        //向上
        if(!dfs(grid,row -1, col)){
            flag = false;
        }

        //向下
        if(!dfs(grid,row + 1, col)){
            flag = false;
        }

        //向左
        if(!dfs(grid,row, col - 1)){
            flag = false;
        }

        //向右
        if(!dfs(grid,row, col + 1)){
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        NumberOfClosedIslands1254 ins = new NumberOfClosedIslands1254();
//        int[][] grid =
//                {
//                        {1,1,1,1,1,1,1,0},
//                        {1,0,0,0,0,1,1,0},
//                        {1,0,1,0,1,1,1,0},
//                        {1,0,0,0,0,1,0,1},
//                        {1,1,1,1,1,1,1,0}
//                };

//        int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        int[][] grid = {{1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}};
        System.out.println(ins.closedIsland(grid));
    }
}
