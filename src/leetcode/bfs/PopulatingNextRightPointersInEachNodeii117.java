package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeii117 {

  Queue<Node> queue = new LinkedList<>();
  public Node connect(Node root) {
    if(null == root){
      return null;
    }
    bfs(root);
    return root;
  }

  private void bfs(Node root){
    queue.add(root);
    while(!queue.isEmpty()){
      Node prev = null;
      int count = queue.size();

      for(int i = 0; i < count; i ++){
        Node node = queue.remove();
        if(prev != null)
          prev.next = node;
        prev = node;
        if(null != node.left){
          queue.add(node.left);
        }
        if(null != node.right){
          queue.add(node.right);
        }
      }
    }
  }
}
