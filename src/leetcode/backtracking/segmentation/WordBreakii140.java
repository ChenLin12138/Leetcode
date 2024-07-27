package leetcode.backtracking.segmentation;

import java.util.*;

public class WordBreakii140 {

  private HashMap<String, String> map = new HashMap();
  private List<String> result = new ArrayList<>();
  private Stack<String> subResult = new Stack<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    backTracking(s,wordDict);
    return result;
  }

  private void backTracking(String s, List<String> wordDict){
    //退出条件
    if(s.length() == 0){
      StringBuffer sb = new StringBuffer();
      for(int i = 0; i < subResult.size(); i ++){
        sb.append(subResult.get(i));
        if(i < subResult.size() - 1)
          sb.append(" ");
      }
      result.add(sb.toString());
      map.put(s, sb.toString());
      return;
    }

    //单层逻辑
    //剪枝:树层去重
    for(int i = 0; i < s.length(); i ++){
      String newStr = s.substring(0,i+1);
      if(!wordDict.contains(newStr))
        continue;

      //选取
      subResult.push(newStr);
      //回溯
      if(map.containsKey(newStr)){

      }
      backTracking(s.substring(i+1),wordDict);
      //清理
      subResult.pop();
    }
    return;
  }

  public static void main(String[] args) {
    WordBreakii140 ins = new WordBreakii140();
//    String[] ArrayString =  {"cat","cats","and","sand","dog"};
    String[] ArrayString =  {"apple","pen","applepen","pine","pineapple"};
    List<String> wordDict = new ArrayList<>();
    for(int i = 0; i < ArrayString.length; i++){
      wordDict.add(ArrayString[i]);
    }
//    System.out.println(ins.wordBreak("catsanddog", wordDict));
    System.out.println(ins.wordBreak("pineapplepenapple", wordDict));
  }
}
