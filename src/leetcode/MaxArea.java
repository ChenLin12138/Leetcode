package leetcode;

import java.util.Arrays;

/**
 * @author Chen Lin
 * @date 2021-09-08
 */

public class MaxArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxArea instance = new MaxArea();
		 int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(instance.maxArea(height));
	}
	 public int maxArea(int[] height) {
		 int res = 0;
		 int i = 0;
			 int j = height.length - 1;
			 while(i<j) {
			 res =Math.max(res, Math.min(height[i],height[j])*(j-i));
			 
			 if(height[i]<height[j]) {
				 i++;
			 }else {
				j--; 
			 }
			
			 }
			 return res;
		 }
		 
	    }


