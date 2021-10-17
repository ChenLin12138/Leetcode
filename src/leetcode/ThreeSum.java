package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chen Lin
 * @date 2021-09-01
 */

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum instance = new ThreeSum();
		System.out.println(instance.threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums == null || nums.length<3) return ans;
        int len = nums.length;
		for(int i = 0; i < len; i++) {
			if(nums[i]>0) break;
			if(i > 0 && nums[i] == nums[i-1]) continue;
			int j = i+1;
			int k = len-1;
			while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
				if(sum == 0) {
					ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
					while(j<k && nums[j] == nums[j+1]) j++;
					while(j<k && nums[k] == nums[k-1]) k--;
					j++;
					k--;
				}
				else if(sum<0) j++;
				else if(sum>0) k--;
			}
		}
		return ans;
    }

}
