package leetcode.backtracking.segmentation;

public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences2002 {


    int result = 0;

    public int maxProduct(String s) {
        backTracking(s,new StringBuffer(),new StringBuffer(),0);
        return result;
    }

    //
    private void backTracking(String s,StringBuffer sb1, StringBuffer sb2, int index){
        //算计一波
        if(isPalindrome(sb1.toString()) && isPalindrome(sb2.toString())){
            result = Math.max(result,sb1.length() * sb2.length());
        }
        //退出条件
        //如果index走到了最后，那么就是结束
        if(index == s.length()){
            return;
        }
        //判断左右序列是否是回文
        //单层逻辑
        //单层逻辑，遍历一个位置，这个位置可以是:
        //左序列用
        backTracking(s, sb1.append(s.charAt(index)),sb2,index + 1);
        //长度还原
        sb1.setLength(sb1.length() - 1);
        //右序列用
        backTracking(s, sb1,sb2.append(s.charAt(index)),index + 1);
        //长度还原
        sb2.setLength(sb2.length() - 1);
        //都不用,不用的情况下，指针继续向下
        backTracking(s, sb1,sb2,index + 1);
    }

    //判断是否位回文
    //左右两个指针，左指针右移，右指针左移。然后他们的值一直相等
    private boolean isPalindrome(String s){
        //回文用双指针判断
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumProductOfTheLengthOfTwoPalindromicSubsequences2002 ins = new MaximumProductOfTheLengthOfTwoPalindromicSubsequences2002();
        System.out.print(ins.maxProduct("leetcodecom"));
    }
}
