package leetcode;

public class IslandPerimeter463 {
    //这是一个岛屿问题，但是不是dfs的问题。
    int res = 0;
    //岛屿的周长存在在这个特性，检查是土地的单元格
    //一面邻水那就+1，
    //一面领边界，那么也+1
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    //四边进行检查
                    //上边
                    if(i == 0 || grid[i-1][j] == 0){
                        res ++;
                    }
                    //左边
                    if(j == 0 || grid[i][j-1] == 0){
                        res ++;
                    }
                    //下边
                    if(i == grid.length - 1 || grid[i+1][j] == 0){
                        res ++;
                    }
                    //右边
                    if(j == grid[0].length - 1 || grid[i][j+1] == 0){
                        res ++;
                    }
                }

            }
        }
        return  res;
    }

    public static void main(String[] args) {
        IslandPerimeter463 ins = new IslandPerimeter463();

//        int[][] grid =
//                {
//                    {0,1,0,0},
//                    {1,1,1,0},
//                    {0,1,0,0},
//                    {1,1,0,0}
//                };
        int[][] grid =
                {{0,1}};
        System.out.println(ins.islandPerimeter(grid));
    }
}
