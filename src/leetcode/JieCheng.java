package leetcode;

/**
 * @author Chen Lin
 * @date 2021-08-19
 */

public class JieCheng {

	public static void main(String[] args) {
		JieCheng instance= new JieCheng();
		System.out.print(instance.function(6));
}
	public int function(int a) {
		int result = 1;
		for(int b=a;b>0;b--) {
			result= result * b;
		}
		return result;
		
	}

}
