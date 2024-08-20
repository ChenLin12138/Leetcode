package leetcode.backtracking.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourceToTarget797 {

  //尝试每一个点，然后计算最后是否可以达到目标
  //有向无环图(DAG
  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> subResult = new Stack<>();

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    subResult.add(0);
    backTracking(graph,0);
    return result;
  }

  private void backTracking(int[][] graph, int rowPos){
    //退出条件
    //走到目的地
    if(rowPos == graph.length - 1){
      result.add(new ArrayList<>(subResult));
      return;
    }

    //单层逻辑
    //我们需要尝试走当前节点可以去的每一个节点
    int row = rowPos;
    for(int i = 0; i < graph[row].length; i++){
      //选取
      subResult.add(graph[row][i]);
      rowPos = graph[row][i];
      //回溯
      backTracking(graph,rowPos);
      //清理
      subResult.pop();
    }
  }

  public static void main(String[] args) {
    AllPathsFromSourceToTarget797 ins = new AllPathsFromSourceToTarget797();
    System.out.println(ins.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
//    System.out.println(ins.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
  }
}
