package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {

  private List<Integer> result = new ArrayList<>();
  private Queue<TreeNode> queue = new LinkedList<>();

  public List<Integer> rightSideView(TreeNode root) {
    if(null == root) return result;

    bfs(root);
    return result;
  }

  private void bfs(TreeNode root){
    queue.add(root);
    while(!queue.isEmpty()){
      int count = queue.size();
      for(int i = 0; i < count; i++){

        TreeNode curNode = queue.remove();
        if(i == count - 1)
          result.add(curNode.val);

        if(curNode.left != null)
          queue.add(curNode.left);

        if(curNode.right != null)
          queue.add(curNode.right);
      }
    }
  }


}
