package leetcode;

import java.util.Stack;

/**
 * @author Chen Lin
 * @date 2021-09-09
 */

public class IsValid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsValid instance = new IsValid();
		System.out.println(instance.isValid("{([]})"));
	}
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
		if (s.length() % 2 == 1) return false;
		char[] c = s.toCharArray();
		for(int i =0; i<c.length; i++) {
			if(c[i]=='(' || c[i]=='{' || c[i]=='[') {
				stack.push(c[i]);			
			}else if(c[i] == ')') {
				if(!stack.isEmpty() && stack.peek()=='(') {
					stack.pop();
				}else{
					return false;
                    }
			}else if(c[i] == '}') {
				if(!stack.isEmpty() && stack.peek()=='{') {
					stack.pop();
				}else{
						return false;
					}		
			}else if(c[i] == ']') {
				if(!stack.isEmpty() && stack.peek()=='[') {
					stack.pop();
				}else{
					return false;
				}
		
	}
		}
		return stack.isEmpty();
		}
	 
}
