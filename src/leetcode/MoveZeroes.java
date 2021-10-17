package leetcode;

import java.util.Arrays;

/**
 * @author Chen Lin
 * @date 2021-09-29
 */

public class MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeroes instance = new MoveZeroes();
		int[] Array = instance.moveZeroes(new int[] {0,1,0,3,12});
		System.out.println(Arrays.toString(Array));
	}
    public int[] moveZeroes(int[] nums) {
         int j=0;
          if(nums==null) return nums;
          for(int i=0;i<nums.length;i++){
              if(nums[i]!=0){
                  int tmp=nums[i];
                  nums[i]=nums[j];
                  nums[j++]=tmp;
              }
              
          }
          return nums;
      }

}
