package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Lin
 * @date 2021-09-15
 */

public class GenerateParenthesis {
	static List<String> res= new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis instance = new GenerateParenthesis();
		System.out.println(instance.generateParenthesis(3));
	}
	 public List<String> generateParenthesis(int n) {
		 res.clear();
		 dfs(n,0,0,"");
		 return res;
		 
	    }
	 public void dfs(int n, int lc, int rc, String str) {
		 
		 if(lc==n && rc==n) {
			 res.add(str);
		 }else {
			 if(lc<n)  dfs(n,lc+1,rc,str+"(");
		 
		     if(rc<n && lc>rc) dfs(n,lc,rc+1,str+")");
		 }
	 
	 }
	
	 

}
