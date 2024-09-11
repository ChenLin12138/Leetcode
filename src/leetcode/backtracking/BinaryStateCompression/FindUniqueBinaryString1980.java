package leetcode.backtracking.BinaryStateCompression;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString1980 {

    //我的想法很粗暴，就是生成数字，然后检查是否在nums中存在
    public String findDifferentBinaryString(String[] nums) {

        if(nums.length == 0)
            return "";

        Set<String> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            set.add(nums[i]);
        }

        for(int i = 0; i < (1 << nums[0].length()); i++){
            String strNum = intConvert2BinaryString(i,nums[0].length());
            if(!set.contains(strNum)){
                return strNum;
            }
        }
        return "";
    }

    private String intConvert2BinaryString(int num, int length){
        String strNum;
        strNum = Integer.toBinaryString(num);
        //如果位数不够，那么我们就在前面加0
        StringBuffer sb = new StringBuffer();
        int count = strNum.length();
        while(count < length){
            sb.append("0");
            count ++;
        }
        sb.append(strNum);
        return sb.toString();
    }

    public static void main(String[] args) {
        FindUniqueBinaryString1980 ins = new FindUniqueBinaryString1980();
//        String[] nums = new String[]{"01","10"};
        String[] nums = new String[]{"0"};
        System.out.println(ins.findDifferentBinaryString(nums));
    }
}
