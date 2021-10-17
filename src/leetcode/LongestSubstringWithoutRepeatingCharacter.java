package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chen Lin
 * @date 2020-06-30
 */

public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacter test = new LongestSubstringWithoutRepeatingCharacter();
		System.out.println(test.lengthOfLongestSubstring(new String("pwwkew")));
	}
	
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        int count = 0;
        int startPos = 0;
        int scanPos = 0;
        if(s.isEmpty()) return 0;

        //代码有两个终止条件
        //1.startPos到结束的距离都不会比当前的max大了
        //2.scanPos扫描到了字符串的末尾
        for(startPos = 0; startPos + max <= s.length() && scanPos <= s.length(); startPos++){
            for(scanPos = startPos; scanPos < s.length(); scanPos++){
                if(set.add(s.charAt(scanPos))){
                    count ++;
                }else{
                    //如过找到重复的char,应该记录重复的记录位置，从它的后一位重新开始
                    //遇到重复字段count都应该重置为0
                    //如过count>max则，max应该被更新
                    //set也应该被清空,然后将当前的char放入set
                    if(count > max){
                        max = count;  
                    }
                    set.clear();
                    count = 0;
                    break;
                } 
            }
        }
        //循环结束后，检查count是否大于max
        if(count > max){
            max = count;
        }
        //max最少是个1
        return max == 0 ? 1 : max;
    }
}
