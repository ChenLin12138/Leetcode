package leetcode;

/**
 * @author Chen Lin
 * @date 2021-08-19
 */

public class JieCheng2 {

	public static void main(String[] args) {
		JieCheng2 instance= new JieCheng2();
		System.out.print(instance.function(6));
}
	public int function(int n) {
		System.out.println("n is :"+n);
		
		//退出条件
		if(n == 1) {
			return 1;
		}
		//传递函数 输入int，返回int
		//单层逻辑
		int result = n * function(n-1);
		return result;
		
	}

}
