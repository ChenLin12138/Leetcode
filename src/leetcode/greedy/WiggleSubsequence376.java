package leetcode.greedy;

public class WiggleSubsequence376 {

    int firstNodeIndex = 0;
    int secondNodeIndex = 1;
    int thirdNodeIndex = 2;

    public int wiggleMaxLength(int[] nums) {
        int res = 0;
        if(nums.length == 0) return res;

        if(nums.length == 1) return 1;

        if(nums.length == 2 && nums[0] == nums[1]) return 1;

        if(nums.length == 2 && nums[0] != nums[1]) return 2;

        //检查是否全部都相等
        boolean allSame = true;

        for(int i = 1; i < nums.length; i ++){
            if(nums[i - 1] != nums[i]){
                allSame = false;
                break;
            }
        }

        if(allSame)
            return 1;

        while(thirdNodeIndex < nums.length){
            calNodeIndex(nums);
            if(thirdNodeIndex >= nums.length)
                break;

            if(nums[secondNodeIndex] < nums[firstNodeIndex] && nums[secondNodeIndex] < nums[thirdNodeIndex]){
                System.out.println("button="+secondNodeIndex);
                res ++;
            }

            if(nums[secondNodeIndex] > nums[firstNodeIndex] && nums[secondNodeIndex] > nums[thirdNodeIndex]){
                System.out.println("top="+secondNodeIndex);
                res ++;
            }

            firstNodeIndex =  secondNodeIndex;
            secondNodeIndex =  thirdNodeIndex;
            thirdNodeIndex ++;
        }

        res += 2;

        return res;
    }

    private void calNodeIndex(int[] nums){
        boolean exit = false;
        while(!exit && thirdNodeIndex < nums.length){
            if(nums[firstNodeIndex] == nums[secondNodeIndex]){
                firstNodeIndex ++;
                secondNodeIndex ++;
                thirdNodeIndex ++;
                continue;
            }
            if(thirdNodeIndex >= nums.length){
                break;
            }

            if(nums[secondNodeIndex] == nums[thirdNodeIndex]){
                secondNodeIndex ++;
                thirdNodeIndex++;
            }

            if(thirdNodeIndex >= nums.length){
                break;
            }

            if(nums[firstNodeIndex] != nums[secondNodeIndex] && nums[secondNodeIndex] != nums[thirdNodeIndex])
                exit = true;
        }
    }

    public static void main(String[] args) {
        WiggleSubsequence376 ins =  new WiggleSubsequence376();
//        int[] input = new int[] {1,7,4,9,2,5};
//        int[] input = new int[] {1,17,5,10,13,15,10,5,16,8};
//        int[] input = new int[] {1,2,3,4,5,6,7,8,9};
//        int[] input = new int[] {1,2,3,4,4,3,3,2,3};
//        int[] input = new int[] {84};
//        int[] input = new int[] {0,0,0};
//        int[] input = new int[] {1,1,7,4,9,2,5};
//        int[] input = new int[] {51,226,208,165,202,286,190,212,219,271,36,245,20,238,238,89,105,66,73,9,254,206,221,237,203,33,249,253};
        int[] input = new int[] {1,1,1,2,2,2,1,1,1,3,3,3,2,2,2};
        System.out.println(ins.wiggleMaxLength(input));
    }
}
