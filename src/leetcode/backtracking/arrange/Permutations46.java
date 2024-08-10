package leetcode.backtracking.arrange;

/**
 * @author Chen Lin
 * @date 2021-09-12
 */

public class Permutations46 {


	//输入[1,2],[a,b],[A,B]
	//输出全排列[
	//[1,a,A],[1,a,B],[1,b,A],[1,b,B],
	//[2,a,A],[2,a,B],[2,b,A],[2,b,B]
	//]
	public char[][] solution(char[] array1, char[] array2, char[] array3) {

		//这里的3表示的传入多少个数组
		int inputArgs = 3;
		char [][] res = new char[array1.length * array2.length * array3.length][inputArgs];

		int i = 0;
		for(char e1 : array1) {
			for(char e2 : array2) {
				char[] temp = null;
				for(char e3 : array3) {
					temp = new char[] {e1,e2,e3};
					res[i] = temp;
					i ++;
				}

			}
		}

		return res;
	}

	//此方法用于测试
	public static void main(String[] args) {
		Permutations46 ins = new Permutations46();
		char[][] res = ins.solution(new char[] {'1','2'}, new char[] {'a','b'},new char[] {'A','B'});
		System.out.print("[");
		for(int i = 0; i < res.length; i ++) {
			System.out.print("[");
			for(int j = 0; j < 3; j ++) {
				if(j == 2) {
					System.out.print(res[i][j]);
				}else {
					System.out.print(res[i][j]+",");
				}
			}
			if(i == res.length -1) {
				System.out.print("]");
			}else {
				System.out.print("],");
			}

		}
		System.out.print("]");
	}

}
