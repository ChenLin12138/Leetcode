package leetcode.backtracking.others;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationInBinaryRepresentation1238 {
    //这种循环码的本质就是格雷码
    //格雷码的生成规则
    //二进制码 -> 格雷码
    //1. 二进制码右移1位
    //2. 二进制码系和右移的二进制码做异或。
    //3. 异或的规则:数字相同则位假，数字不用同则位真
    public List<Integer> circularPermutation(int n, int start) {

        int[] grayCodeArray = new int[1 << n];
        int j = 0;
        for (int i = 0; i < 1 << n; ++i) {
            grayCodeArray[i] = i ^ (i >> 1);
            if (grayCodeArray[i] == start) {
                j = i;
            }
        }
        //从头开始加
        List<Integer> result = new ArrayList<>();
        for (int i = j; i < grayCodeArray.length; i++) {
            result.add(grayCodeArray[i]);
        }
        //剩下的添加到尾部
        for(int i = 0; i < j; i ++){
            result.add(grayCodeArray[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        CircularPermutationInBinaryRepresentation1238 ins = new CircularPermutationInBinaryRepresentation1238();
        ins.circularPermutation(2,3).stream().forEach(x -> System.out.print(x));
    }
}
