package leetcode;

/**
 * @author Chen Lin
 * @date 2021-09-30
 */

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWords instance = new ReverseWords();
		System.out.println(instance.reverseWords("Let's take LeetCode contest"));

	}
	public String reverseWords(String s) {
		StringBuffer ans = new StringBuffer();
		int n=s.length();
		int i=0;
		while(i<n) {
			int start =i;
				while(i<n&& s.charAt(i)!=' ') {
					i++;
				}
			for(int p=start;p<i;p++) {
				ans.append(s.charAt(start+i-1-p));
			}	
			while(i<n&& s.charAt(i)==' ') {
				i++;
				ans.append(' ');
			}
		}
	    return ans.toString();
	}
}
