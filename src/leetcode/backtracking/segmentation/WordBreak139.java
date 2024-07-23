package leetcode.backtracking.segmentation;

import java.util.*;

public class WordBreak139 {

  private HashMap<String, Boolean> map = new HashMap();
  public boolean wordBreak(String s, List<String> wordDict) {
    return backTracking(s,wordDict);
  }

  private boolean backTracking(String s, List<String> wordDict){
    //退出条件
    if(s.length() == 0)
      return true;

    //单层逻辑
    //剪枝:树层去重
    for(int i = 0; i < s.length(); i ++){
      //选取
      String newStr = s.substring(0,i+1);
      if(!wordDict.contains(newStr))
        continue;
      //回溯
      if(!map.containsKey(s.substring(i+1)) && backTracking(s.substring(i+1),wordDict))
        return true;
      //清理
    }
    map.put(s,false);
    return false;
  }

  public static void main(String[] args) {
    WordBreak139 ins = new WordBreak139();
    System.out.println(ins.wordBreak("leetcode", Arrays.asList("leet", "code")));
  }
}
