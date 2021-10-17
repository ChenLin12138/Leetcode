package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chen Lin
 * @date 2021-09-07
 */

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<List<Integer>> fourSum(int[] nums, int target) {
		 List<List<Integer>> foursum = new ArrayList<List<Integer>>();
		 if(nums == null || nums.length<4) return foursum;
		
		 Arrays.sort(nums);
		 int length = nums.length;
		 for(int i = 0; i < length; i++) {
			 
			 if(i>0&& nums[i] == nums[i-1]) continue;
			 
			 for(int j = i+1; j<length-1;j++) {
				 if(j> i+1 && nums[j] == nums[j-1]) continue;
				 
				 int left = j+1, right = length-1;
				 while(left<right) {
					 int sum = nums[i]+nums[j]+nums[left]+nums[right];
					 if(sum<target) {
						 left++;
						 }else if(sum>target) {
							 right--;
						 }else if(sum == target) {
							 foursum.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
							 while (left < right && nums[left] == nums[left + 1]) {
		                            left++;
		                        }
		                        left++;
		                        while (left < right && nums[right] == nums[right - 1]) {
		                            right--;
		                        }
		                        right--;
						 }
				 }
			 }
		 }
		 return foursum;
		 
	    }

}
