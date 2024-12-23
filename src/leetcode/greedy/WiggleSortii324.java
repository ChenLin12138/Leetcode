package leetcode.greedy;

import java.util.Arrays;

public class WiggleSortii324 {

    public void wiggleSort(int[] nums) {
        int[] res = new int[nums.length];
        //先把数组排序
        Arrays.sort(nums);
//        Arrays.stream(nums).forEach(x -> System.out.println(x));
        //然后从头部挑一个放第一个
        //从尾部挑一个放第二个
        //以次类推
        int headPickupIndex = 0;
        //这里使用一个小技巧，将数组拆分成2部分，一部分大，一部分小，然后从小到大区。就能避免
//      A= [1,1,2]
//      B= [2,2,3]
        //A和B都从小到大1取。这样避免从A的头部，B的尾部取到相同的值。影响结果。
        //这个取值应该从nums.length/2 + 1开始，不然前面的A数组的取值会到B数组的第一个。B数组没办法取到最后一个数字。
        //分组后逆序取值也是因为避免[1,2,2,3]这样的情况
        int tailPickupIndex = nums.length - 1;
        if(nums.length % 2 != 0){
            headPickupIndex = nums.length/2;
        }else{
            headPickupIndex = nums.length/2 - 1;
        }

        int i = 0;
        while(i < nums.length){
            res[i] = nums[headPickupIndex];
            headPickupIndex --;
            i++;
            if(i >= nums.length)
                break;
            res[i] = nums[tailPickupIndex];
            i++;
            tailPickupIndex --;
        }

        for(i = 0; i < res.length; i ++){
            nums[i] = res[i];
        }
        Arrays.stream(nums).forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) {
        WiggleSortii324 ins =  new WiggleSortii324();
//        int[] input = new int[] {1,5,1,1,6,4};
//        int[] input = new int[] {1,3,2,2,3,1};
//        int[] input = new int[] {1,1,2,2,2,3};
//        int[] input = new int[] {1,1,1,2,2,2,2};
//        int[] input = new int[] {1,1,1,1,2,2,2};
//        int[] input = new int[] {4,5,5,6};
        int[] input = new int[] {1,2,2,3};
        ins.wiggleSort(input);
    }
}
