package leetcode;

/**
 * @author Chen Lin
 * @date 2021-09-01
 */

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonPrefix instance = new LongestCommonPrefix();
		String[] strss = {"flower","flow","flowdd"};
		System.out.print(instance.longestCommonPrefix(strss));

	}
	 public String longestCommonPrefix(String[] strs) {
		 if(strs == null || strs.length == 0) {
			 return "";
		 }
		 
		 for(int i = 0; i< strs[0].length(); i++) { 
			 
			 char c = strs[0].charAt(i);
			 
			 for(int j = 1; j<strs.length; j ++) {
				 
			if(i==strs[j].length()||strs[j].charAt(i) != c) {
				
				return strs[0].substring(0, i);
			}	 
			 } 
		 }
		 return strs[0];
		 
	    } 

}
