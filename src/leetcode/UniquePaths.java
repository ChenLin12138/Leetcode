package leetcode;

/**
 * @author Chen Lin
 * @date 2021-03-28
 */

public class UniquePaths {

	public static void main(String[] args) {
		
		UniquePaths uniquePaths = new UniquePaths();
		System.out.println(uniquePaths.solution(7, 3));
		
	}
	
	private int solution (int m, int n){
		
		int f[][] = new int [m][n];
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j ++) {
				if(i == 0 || j == 0) {
					f[i][j]=1;
					
				}else {
					f[i][j]=f[i][j-1]+f[i-1][j];
				}
			}
		}
		
		return f[m-1][n-1];
	}

}
