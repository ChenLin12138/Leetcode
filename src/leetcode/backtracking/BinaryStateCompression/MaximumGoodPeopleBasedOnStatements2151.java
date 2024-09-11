package leetcode.backtracking.BinaryStateCompression;

public class MaximumGoodPeopleBasedOnStatements2151 {

  //statements[i][j]表示i对j的评价
//    0 表示 i 的陈述认为 j 是 坏人 。
//    1 表示 i 的陈述认为 j 是 好人 。
//    2 表示 i 没有对 j 作出陈述。
//  根据这 n 个玩家的陈述，返回可以认为是 好人 的 最大 数目。
  //每一个人都可能是好人或者坏人，现在要求好人最多的情况。
  public int maximumGood(int[][] statements) {
    int result = 0;

    //statements[i][j]是一个n * n的矩阵,他始终是一个方阵
    //选1表示好人，不选表示坏人，要求好人最多，其实本质就是描述，好人和好人之间不能矛盾
    for(int i = 0; i < (1 << statements.length); i ++){
      //好人不够多就直接放弃
      int goodPersonNo = Integer.bitCount(i);
      if(goodPersonNo <= result) continue;
      //检查大家的论调是否有矛盾
      if(!isValid(i,statements)){
        continue;
      }
      result = Math.max(result, goodPersonNo);
    }
    return result;
  }

  private boolean isValid (int goodPerson, int[][] statements){
    //好人的描述与好人的描述之间不能矛盾
    //扫描goodPerson中的1的选项
    for(int i = 0; i < statements.length; i ++){
      //此时选中的是i为好人，那么我们需要看所有人对i的评价是否矛盾
      if(((goodPerson >> i) & 1) == 1){
        //找出矛盾之处,现在已经认定了i那一位是好人了
        for(int j = 0; j < statements.length; j ++){
          //这里表达的意思是
          //1.statements[i][j] < 2， i对j的描述一定是有一个好人或者坏人的描述
          //2.statements[i][j]表达了i对j的好坏人描述
          //3.(goodPerson << j) & 1表达这一个选择goodPerson中对j的描述
          //因为goodPerson中既对i也对j都进行了描述，那么i和j的好坏人描述不一致，则这个描述是矛盾的我们不采纳
          if(statements[i][j] < 2 && statements[i][j] != ((goodPerson >> j) & 1))
            return false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    MaximumGoodPeopleBasedOnStatements2151 ins = new MaximumGoodPeopleBasedOnStatements2151();
    System.out.println(ins.maximumGood(new int[][]{{2,1,2},{1,2,2},{2,0,2}}));
//    System.out.println(ins.maximumGood(new int[][]{{2,0},{0,2}}));
  }
}


