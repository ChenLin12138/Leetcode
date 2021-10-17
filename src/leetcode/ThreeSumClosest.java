package leetcode;

import java.util.Arrays;

/**
 * @author Chen Lin
 * @date 2021-09-03
 */

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest instance = new ThreeSumClosest();
		System.out.println(instance.threeSumClosest(new int[] {-1,0,1,2,-1,-4},3));

	}
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int len = nums.length;
		int best = nums[0] + nums[1] + nums[2];
		

		for(int i = 0; i < len; i++) {
			if(i>0 && nums[i] == nums[i-1]) continue;
			
			int j = i + 1;
			int k = len-1;
			while(j<k) {
				int sum = nums[i] + nums[j] + nums[k];
				
				if (sum == target) {
					return target;
				}
				if(Math.abs(sum-target)<Math.abs(best-target)) {
					best = sum;
					
				}
				if(sum > target) {
					k--;
				}else if(sum< target){
					j++;
				}else {
					return best;
				}
			}
		}
		return best;
		
    }

}
