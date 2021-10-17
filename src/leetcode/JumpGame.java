package leetcode;

/**
 * @author Chen Lin
 * @date 2021-04-05
 */

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] nums = new int[] {2,3,1,1,4};
//		int [] nums = new int[] {3,2,1,0,4};
		int [] nums = new int[] {0,2,3};
		JumpGame jg = new JumpGame();
		System.out.print(jg.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
		
		boolean [] reachAble = new boolean[nums.length];
		reachAble[0] = true;
		for(int i = 1; i < nums.length; i ++) {
			for(int pos = 0; pos < i; pos ++) {
				if(true == reachAble[pos] && pos + nums[pos] >= i) {
					reachAble[i] = true;
					break;
				}
			}
		}
		return reachAble[nums.length-1];
    }

}
