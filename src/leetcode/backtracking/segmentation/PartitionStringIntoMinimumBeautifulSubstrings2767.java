package leetcode.backtracking.segmentation;

import java.util.*;

public class PartitionStringIntoMinimumBeautifulSubstrings2767 {

    //这是一个子集问题，在路径上收集
    //要求切割出的数字没有前导0
    //要求切割的数字是5的幂集
    Set<String> pow5 = new HashSet();

    int res = Integer.MAX_VALUE;
    boolean isUpdate = false;
    Stack<String> stack = new Stack<>();
    public int minimumBeautifulSubstrings(String s) {
        fillPow5();
        backTracking(s);
        return isUpdate == true ? res : -1;
    }

    private void fillPow5() {
        pow5.add("1");
        pow5.add("101");
        pow5.add("11001");
        pow5.add("1111101");
        pow5.add("1001110001");
        pow5.add("110000110101");
        pow5.add("11110100001001");
    }

    private void backTracking(String s){
        //退出条件
        if(s.length() == 0){
            if(stack.size() < res){
                res = stack.size();
                isUpdate = true;
            }
            return;
        }
        //单层逻辑
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(0,i+1);

            //选取
            //有前导0的要排除
            if (str.length() > 1 && str.charAt(0) == '0')
                return;

            if(isBeautifulString(str)){
                stack.add(str);
                //回溯
                backTracking(s.substring(i+1));
                //清理
                stack.pop();
            }
        }
    }

    private boolean isBeautifulString(String str){
        //判断str是5的幂
        if(pow5.contains(str))
            return true;

        return false;
    }

    public static void main(String[] args) {
        PartitionStringIntoMinimumBeautifulSubstrings2767 ins = new PartitionStringIntoMinimumBeautifulSubstrings2767();
        System.out.println(ins.minimumBeautifulSubstrings("1011"));
//        System.out.println(ins.minimumBeautifulSubstrings("0"));
    }
}
