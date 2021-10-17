package leetcode;

/**
 * @author Chen Lin
 * @date 2021-08-25
 */

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reverse instance = new Reverse();
		System.out.print(instance.reverse(-321));
	}
	public int reverse(int x) {
		if(x==0) return 0;
		int res = 0;
		int last =0;
		while( x!=0 ) {
			int temp = x%10;
			 last =res; 
			res = res*10+ temp;
			
			 if(last!=res/10) {
				return 0; 
			 }
			 x /=10;
			 
		}
		return res;
			
		
		}
	
	

}
