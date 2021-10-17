package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Lin
 * @date 2020-06-29
 */

public class TwoSum {

	public static void main(String[] args) {
		
		TwoSum instance = new TwoSum();
		int[] Array =instance.twoSum(new int[] {3,2,4}, 6);
		System.out.println(Arrays.toString(Array));

	}
	
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = {};
        
        //值作为key,index作为value
        for(int i = 0 ; i < nums.length ; i ++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < nums.length ; i ++){
            if(map.containsKey(target-nums[i])&&i!=map.get(target-nums[i])){
            int j = map.get(target-nums[i]);
               return result = new int[]{i,j};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

}
