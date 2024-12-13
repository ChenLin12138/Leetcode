package leetcode.dfs;

public class CountSubIslands1905 {

    //初始化的默认值为false，表示么有被计算过
    private boolean[][] countedLand;
    private int res = 0;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        countedLand = new boolean[grid2.length][grid2[0].length];
        //遍历岛屿
        //检查grid2是否是1的子岛屿
        for(int row = 0; row < countedLand.length; row++){
            for(int col = 0; col < countedLand[0].length; col++){
                //参与计算过的土地不再计算，直接跳到下一个地块
                //当前是海洋也不应该计算
                if(countedLand[row][col] || grid2[row][col] == 0){
                    continue;
                }
                //没有参与计算的土地可以继续计算
                if(dfs(grid1,grid2,row,col))
                    res ++;
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int row, int col){
        //退出条件
        //如果grid2是陆地，儿grid1不是陆地，那么我们应该返回false,并终止所有递归
        if(grid2[row][col] == 1 && grid1[row][col] == 0){
            return false;
        }

        //当前土地被检查过的，那么应该退出
        if(countedLand[row][col]){
            return true;
        }

        //当前是海洋也应该退出
        if(grid2[row][col] == 0){
            countedLand[row][col] = true;
            return true;
        }

        //单层逻辑
        //能到到这里的都是没有计算过的地块，那么我们可以标记地块
        //当我们发现现在找的这个grid2的岛不是grid1的子岛的时候，我们还是需要把grid2的所有地块标记起来。
        boolean flag = true;
        countedLand[row][col] = true;
        //并且上面的土地没有参与过计算

        //向上检查&保证不是已经在最上面
        if(row > 0){
            if(!dfs(grid1,grid2,row - 1,col))
                flag = false;
        }

        //向下检查&保证不是已经在最下面
        if(row < grid2.length - 1){
            if(!dfs(grid1,grid2,row + 1,col))
                flag = false;
        }

        //向左检查&保证不是已经在最左面
        if(col > 0){
            if(!dfs(grid1,grid2,row,col - 1))
                flag = false;
        }

        //向右检查&保证不是已经在最右面
        if(col < grid2[0].length - 1){
            if(!dfs(grid1,grid2,row,col + 1))
                flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };

        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

//        int[][] grid1 = {
//                {1,0,1,0,1},
//                {1,1,1,1,1},
//                {0,0,0,0,0},
//                {1,1,1,1,1},
//                {1,0,1,0,1}
//        };
//
//        int[][] grid2 = {
//                {0,0,0,0,0},
//                {1,1,1,1,1},
//                {0,1,0,1,0},
//                {0,1,0,1,0},
//                {1,0,0,0,1}
//        };

        CountSubIslands1905 ins = new CountSubIslands1905();
        System.out.println(ins.countSubIslands(grid1,grid2));
    }
}
