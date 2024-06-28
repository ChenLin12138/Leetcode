package leetcode;

public class DetectCapital520 {
  public boolean detectCapitalUse(String word) {

    if(word.length() < 2)
      return true;

    //第一个字母如果是小写，那么第二个字母必须是小写
    if (Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))){
      return false;
    }

    //第一个字母无论大小写，从第二个开始的字母的大小写必须和第二个字母保持一致。
    for(int i = 2; i < word.length(); i ++){
      if(Character.isLowerCase(word.charAt(1)) && Character.isUpperCase(word.charAt(i))
      || Character.isUpperCase(word.charAt(1)) && Character.isLowerCase(word.charAt(i)))  {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

  }
}
