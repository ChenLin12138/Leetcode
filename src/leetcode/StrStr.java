package leetcode;

/**
 * @author Chen Lin
 * @date 2021-09-13
 */

public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrStr instance =new StrStr();
		System.out.println(instance.strStr("hello", "ll"));
	}
	public int strStr(String haystack, String needle) {
        int a= haystack.length();
        int b= needle.length();
        int head =0,tail= b-1;
        while(tail<a) {
        String ab = haystack.substring(head, head+b);	
        if(ab.contentEquals(needle)) {
        	return head;
        }
        head++;
        tail++;
        }
        return -1;
    }

}
