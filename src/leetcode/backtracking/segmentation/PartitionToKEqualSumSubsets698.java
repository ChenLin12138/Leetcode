package leetcode.backtracking.segmentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionToKEqualSumSubsets698 {

  private int avg = 0;
  private int kSize = 0;
  private List<Integer> subSetSum = new ArrayList<>();

  public boolean canPartitionKSubsets(int[] nums, int k) {
    this.kSize = k;
    int sum = Arrays.stream(nums).sum();
    //不能整除那肯定不行
    if(sum % k != 0) return false;
    //这就是我们要凑的数
    this.avg = sum / k;

    //从大到小排序
    int[] sortedArr = Arrays.stream(nums)
      .boxed()
      .sorted((num1, num2) -> num2.compareTo(num1))
      .mapToInt(Integer::intValue)
      .toArray();

    //subSetSum的初始化
    for(int i = 0; i < k; i ++){
      subSetSum.add(0);
    }

    return backTracking(sortedArr);
  }

  private boolean backTracking(int[] nums){
    //退出条件
    //退出条件必然是子弹打完了遍历每一个桶的和是等于avg的
    if(nums.length == 0){
      for(Integer subSum : subSetSum){
        if(!subSum.equals(this.avg)){
          return false;
        }
      }
      return true;
    }

    //单层逻辑
    //桶最多只有16个桶，那么我们必然是遍历桶了
    //就选取第一个元素进入组合中
    //尝试把数据网桶里装
    //剪枝
    //相同的元素数层剪枝
    for(int i = 0; i < this.kSize; i ++){
      //选取
      //减枝： 当元素放入桶中已经超过了平均値了，那么就是没意义的
      if(subSetSum.get(i) + nums[0] > this.avg)
        continue;
      //如果现在这个桶和上一个桶的sum一致，而且不为0，那么上个桶放过的事情和这个桶放是没区别的
      if(i > 0 && subSetSum.get(i).equals(subSetSum.get(i - 1)))
        continue;
      subSetSum.set(i,subSetSum.get(i) + nums[0]);
      //回溯
      if(backTracking(Arrays.copyOfRange(nums,1,nums.length)))
        return true;

      //清理
      subSetSum.set(i,subSetSum.get(i) - nums[0]);
    }
    return false;
  }

  public static void main(String[] args) {
    PartitionToKEqualSumSubsets698 ins = new PartitionToKEqualSumSubsets698();
//    System.out.println(ins.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//    System.out.println(ins.canPartitionKSubsets(new int[]{1,2,3,4}, 3));
    System.out.println(ins.canPartitionKSubsets(new int[]{10,5,5,4,3,6,6,7,6,8,6,3,4,5,3,7}, 8));
  }
}
