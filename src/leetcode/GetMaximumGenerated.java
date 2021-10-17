package leetcode;

/**
 * @author Chen Lin
 * @date 2021-08-23
 */

public class GetMaximumGenerated {

	public int getMaximumGenerated(int n) {

		if(n == 0) {
			return 0;
		}

        if(n == 1) {
			return 1;
		}
		
		int[] nums = new int[n+1];
		nums[0] = 0;
		nums[1] = 1;
		int i = 1;
		int res = 0;
		
		for(int index = 2; index < nums.length ; index ++ ) {
			
			if(2 * i >=2 && 2 * i <= n) {
				nums[2 * i] = nums[i];
				res = Math.max(res, nums[i]);
			}
			
			if(2 * i + 1 >=2 && 2 * i + 1 <= n) {
				nums[2 * i + 1] = nums[i] + nums[i + 1];
				res = Math.max(res, nums[2 * i + 1]);
			}
			
			i ++;
		}
		
		return res;		
	}
}
