package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Lin
 * @date 2020-07-22
 */

public class HackerRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2,3,6,5,9,7
		List<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(4);
		input.add(4);
		input.add(2);
		input.add(2);
		input.add(2);
		input.add(4);
		input.add(2);
		input.add(2);
		input.add(4);

		
		System.out.println(HackerRank.function(input));
		
	}
	
	public static int function(List<Integer> arr) {
		int n = arr.size();
	     if (n <= 1) return 0;
	     int result = 0;
	     List<Integer> freqs = new ArrayList<Integer>();
	     int count = 1;
	     
	     for (int i = 1; i < n; ++i) {
	         if (arr.get(i) == arr.get(i-1)) {
	             count++;
	         } else {
	             freqs.add(count);
	             count = 1;
	         }
	     }
	     freqs.add(count);
	     n = freqs.size() - 1;
	     for (int i = 0; i < n; ++i) {
	         if(freqs.get(i)>freqs.get(i+1)) {
	        	 result +=  freqs.get(i+1);
	         }else {
	        	 result +=  freqs.get(i);
	         }
	     }
	     return result; 
	}

	 
	 
}
