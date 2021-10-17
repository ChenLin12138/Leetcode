package leetcode;

/**
 * @author Chen Lin
 * @date 2020-06-29
 */

public class TwoSum2 {

	public static void main(String[] args) {
		TwoSum2 instance = new TwoSum2();
		System.out.println(instance.twoSum(new int[] {3,2,4}, 6));
	}
	
	 public int[] twoSum(int[] nums, int target) {
	        int len = nums.length;
	        for(int i=0; i<len; i++){
	          for(int j =i+1; j<len;j++){
	             int sum = target-nums[i]-nums[j];
	              if(sum == 0){
	               return new int[]{i,j};   
	              };  
	          }
	        }
	        return new int[0];
	}
}
