package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
  Queue<TreeNode> queue = new LinkedList();
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {
    if(null == root)
      return result;

    bfs(root);
    return result;
  }

  private void bfs(TreeNode root){
    queue.add(root);
    while(!queue.isEmpty()){
      int count = queue.size();
      List<Integer> subResult = new ArrayList<>();
      for(int i = 0; i < count; i ++){
        TreeNode node = queue.remove();

        subResult.add(node.val);

        if (node.left != null){
          queue.add(node.left);
        }
        if (node.right != null){
          queue.add(node.right);
        }
      }
      result.add(subResult);
    }
  }
}
