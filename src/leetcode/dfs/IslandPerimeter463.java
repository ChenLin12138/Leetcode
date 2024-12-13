package leetcode.dfs;

public class IslandPerimeter463 {
    int res = 0;
    public int islandPerimeter(int[][] grid) {
        return  res;
    }

    public static void main(String[] args) {
        IslandPerimeter463 ins = new IslandPerimeter463();

        int[][] grid =
                {
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,1,0,0},
                    {1,1,0,0}
                };
        System.out.println(ins.islandPerimeter(grid));
    }
}
