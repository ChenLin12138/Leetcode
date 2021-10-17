package leetcode;

import java.util.Stack;

/**
 * @author Chen Lin
 * @date 2021-10-17
 */

public class DailyTemperatures {
	//维护一个由index构成的栈
	//这个栈中index指向的数组temperatures[index]是单调递减的
	
	public int[] dailyTemperatures(int[] temperatures) {
		int[] res = new int[temperatures.length];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int index = 0; index < temperatures.length ; index++) {
			
			if(stack.isEmpty()) {
				stack.push(index);
			}
			
			//维护一个temperatures[index]单调递减的栈stack
			if(temperatures[index] <= temperatures[stack.peek()]) {
				stack.push(index);
			}else {
				while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[index]) {
					int lowerestTempIndex = stack.pop();
					res[lowerestTempIndex] = index - lowerestTempIndex;
				}
				stack.push(index);
			}
		}
		
		//循环完成后，stack中剩余元素出栈，全部标志为0
		while(!stack.isEmpty()) {
			res[stack.pop()] = 0;
		}
		return res;
	}
	
}
