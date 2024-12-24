package leetcode.backtracking.arrange;

import java.util.*;

/**
 * @author Chen Lin
 * @date 2021-09-12
 */

public class Permutations47 {

	List<List<Integer>> res = new ArrayList<>();
	Stack<Integer> stack = new Stack<>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		backTracking(nums);
		return res;
	}

	private void backTracking(int[] nums){
		//退出条件
		if (nums.length == 0) {
			res.add(new ArrayList<>(stack));
			return;
		}

		//单层逻辑
		for(int i = 0; i < nums.length; i++){
			//减枝
			if(i > 0 && nums[i] == nums[i-1]){
				continue;
			}
			stack.add(nums[i]);
			//回溯
			int[] subSet = new int[nums.length - 1];
			System.arraycopy(nums,0,subSet,0,i);
			System.arraycopy(nums,i+1,subSet,i,nums.length - 1 - i);
			backTracking(subSet);
			//清理
			stack.pop();
		}
	}


	//测试使用
	public static void main(String[] args) {
		Permutations47 ins = new Permutations47();
//		List<List<Integer>> res = ins.permuteUnique(new int[]{1,1,2});
//		List<List<Integer>> res = ins.permuteUnique(new int[]{1,2,3});
		List<List<Integer>> res = ins.permuteUnique(new int[]{1,2,3});
		System.out.print("dsfsdf");

	}

}
