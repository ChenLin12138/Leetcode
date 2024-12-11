package leetcode.dfs;

public class MaxAreaOfIsland695 {
    //计算最大岛屿的面积
    int maxSize = 0;
    int curSize = 0;
    private boolean[][] countedLand;
    //初始化的默认值为false，表示么有被计算过
    public int maxAreaOfIsland(int[][] grid) {
        countedLand = new boolean[grid.length][grid[0].length];
        for(int row = 0; row < countedLand.length; row++){
            for(int col = 0; col < countedLand[0].length; col++){
                curSize = 0;
                //参与计算过的土地不再计算，直接跳到下一个地块
                //当前是海洋也不应该计算
                if(countedLand[row][col] || grid[row][col] == 0){
                    continue;
                }
                //没有参与计算的土地可以继续计算
                dfs(grid,row,col);
                //然后地块+1
                maxSize = Math.max(maxSize,curSize);
//                System.out.println("maxSize="+maxSize);
            }
        }
        return maxSize;
    }

    private void dfs(int[][] grid, int row, int col){
        //退出条件
        //当前土地被检查过的，那么应该退出
        //能做减枝优化吗
//        System.out.println("row"+row+",col:"+col);
        if(countedLand[row][col]){
            return;
        }

        //当前是海洋也应该退出
        if(grid[row][col] == 0){
            countedLand[row][col] = true;
            return;
        }

        //单层逻辑
        //能到到这里的都是没有计算过的地块，那么我们可以标记地块
        countedLand[row][col] = true;
        curSize++;
        //向上检查&保证不是已经在最上面
        if(row > 0){
            dfs(grid,row - 1,col);
        }

        //向下检查&保证不是已经在最下面
        if(row < grid.length - 1){
            dfs(grid,row + 1,col);
        }

        //向左检查&保证不是已经在最左面
        if(col > 0){
            dfs(grid,row,col - 1);
        }

        //向右检查&保证不是已经在最右面
        if(col < grid[0].length - 1){
            dfs(grid,row,col + 1);
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland695 ins = new MaxAreaOfIsland695();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
//
//        int[][] grid = {
//                {0,0,0,0,0,0,0,0}
//        };
        System.out.println(ins.maxAreaOfIsland(grid));
    }
}
