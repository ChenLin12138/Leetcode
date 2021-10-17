package leetcode;

/**
 * @author Chen Lin
 * @date 2021-08-31
 */

public class IntToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntToRoman instance = new IntToRoman();
		System.out.print(instance.intToRoman(123));
	}
	int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	public String intToRoman(int num) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<values.length; i ++){
			while(num >= values[i]) {
			stringBuilder.append(romans[i]);
			num -= values[i];
		}
		}
		return stringBuilder.toString();
		
    }	

}
