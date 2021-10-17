package leetcode;

/**
 * @author Chen Lin
 * @date 2021-08-25
 */

public class IsPalindrome2 {
	
	public static void main(String[] args) {
		IsPalindrome2 instance = new IsPalindrome2();
		System.out.print(instance.isPalindrome(12210));

	}
	public boolean isPalindrome(int x) {
		
		if(x<0 || (x%10 == 0&& x !=0)) {
			return false;
		}
		
		int res = 0;
		
		while(x > res) {
			int tmp = x%10;
			res = res * 10 + tmp;
		
			x /= 10;
		}
		return x == res || x == res/10;
    }

}
