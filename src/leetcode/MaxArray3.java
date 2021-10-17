package leetcode;

import java.util.Arrays;

/**
 * @author Chen Lin
 * @date 2021-08-19
 */

public class MaxArray3 {

	public static void main(String[] args) {
		MaxArray3 instance = new MaxArray3();
		System.out.print(instance.getMaximumGenerated(7));
		System.out.print(instance.getMaximumGenerated1(7));

	}

	// i 为偶数，nums[i]=nums[i/2]
	// i为奇数，nums[i]=nums[i/2]+nums[i/2+1]
	// nums[i]=nums[i/2]+(i mod 2)*nums[i/2+1]
	public int getMaximumGenerated(int n) {
		int[] nums = new int[n + 1];
		if (n == 0) {
			return 0;
		}
		nums[1] = 1;
		int i;
		int max = 0;

		for (i = 2; i <= n; i++) {
			nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1];
		}

		// return Arrays.stream(nums).max().getAsInt();

		// Arrays.sort(nums);
		// return nums[n];

		for (i = 2; i <= n; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;

	}

	public int getMaximumGenerated1(int n) {
		int[] nums = new int[n + 1];
		if (n == 0) {
			return 0;
		}
		nums[1] = 1;
		int i;
		for (i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				nums[i] = nums[i / 2];
			} else {
				nums[i] = nums[i / 2] + nums[i / 2 + 1];
			}
		}
		return Arrays.stream(nums).max().getAsInt();

	}

}
