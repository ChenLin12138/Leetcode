package leetcode.backtracking.others;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
  //n==0的情况
  //0

  //n==1的情况
  //0,1
  //0
  //1

  //n==2的情况，其实是复制n==1时候的前面做镜像，后面填充1和0
  //0,2,3,1
  //00
  //10
  /////////////////
  //11
  //01

  //这个不要去看，会打乱你的思绪
  //0,1,3,2
  //00
  //01
  ////////////
  //11
  //10

  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0);
    //控制做多少次
    for(int i = 0; i < n; i ++){
      for(int j = result.size()- 1; j >= 0; j --){
        //原来的数直接左移
        result.set(j, result.get(j) << 1);
        //镜像的数字需要+1
        result.add(result.get(j) + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    GrayCode89 ins = new GrayCode89();
    List<Integer> res = ins.grayCode(2);
    res.forEach(x -> System.out.println(x));
  }

}
