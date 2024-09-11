package leetcode.backtracking.BinaryStateCompression;

public class CountNumberOfMaximumBitwiseOrSubsets2044 {

    public int countMaxOrSubsets(int[] nums) {
        int result = 0;
        int maxVal = 0;
        int n = nums.length;
        //计算一下最大值
        for(int i = 0; i < nums.length; i++){
            maxVal |= nums[i];
        }

        //计算这16位运算中，值和maxVal相等的元素个数
        //遍历所有取和不取的值
        for(int mask = 0; mask < (1 << n); mask ++){
            int cur = 0;
            for(int i = 0; i < n; i ++){
                if(((mask >> i) & 1) == 1)
                    cur |= nums[i];
            }
            if (cur == maxVal){
                result ++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountNumberOfMaximumBitwiseOrSubsets2044 ins = new CountNumberOfMaximumBitwiseOrSubsets2044();
//        System.out.print(ins.countMaxOrSubsets(new int[]{3,1}));
        System.out.print(ins.countMaxOrSubsets(new int[]{2,2,2}));
    }
}
