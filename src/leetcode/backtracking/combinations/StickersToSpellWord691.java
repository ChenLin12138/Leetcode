package leetcode.backtracking.combinations;

import java.util.Arrays;

public class StickersToSpellWord691 {

  //这个题真的很复杂
  //这个需要动态规划和压缩状态来完成
  //这种压缩状态的，说实话我真的不懂
  public int minStickers(String[] stickers, String target) {

    //target的长度只有15位，那么我们每一位选与不选用dp来表示
    int maxTargetSize = 15;
    int[] dp = new int[1 << target.length()];
    //这个用来初始化dp的值,这个20我是有疑问的，为啥是20
    int initValue = 20;
    Arrays.fill(dp,initValue);
    dp[0] = 0;
    int targetPositionLength = 1 << target.length();
    //遍历所有的位置
    for(int i = 0; i < targetPositionLength; i ++){
      //这里有个剪枝的操作
      if(dp[i] == initValue)
        continue;
      //遍历字典里的所有单词
      for(int j = 0; j < stickers.length; j ++){
        int dpPosition = i;
        //遍历字典中的某一个字符
        for(int k = 0; k < stickers[j].length(); k++){
          //字典中的字符和target的字符比较
          for(int tPos = 0; tPos < target.length(); tPos++ ){
            //target的字符和字典中的字符匹配了，并且这个位置没有被处理过
            if(target.charAt(tPos) == stickers[j].charAt(k) && (((dpPosition >> tPos) & 1) == 0)){
              dpPosition |= (1<<tPos);
              break;
            }
          }
        }
        dp[dpPosition] = Math.min(dp[dpPosition],dp[i]+1);
      }
    }
    return dp[targetPositionLength - 1] == initValue ? -1 : dp[targetPositionLength - 1];
  }

  public static void main(String[] args) {
    StickersToSpellWord691 ins = new StickersToSpellWord691();
    System.out.println(ins.minStickers(new String[]{"with","example","science"},"thehat"));
  }
}
