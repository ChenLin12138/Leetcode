package leetcode.backtracking.combinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers638 {
  //价格列表
  List<Integer> price = new ArrayList<>();
  //礼包列表
  List<List<Integer>> special = new ArrayList<>();

  //缓存
  Map<List<Integer>, Integer> cache = new HashMap<>();

  //商品价格
//  price = [2,5]，0号商品单价2元，1号商品单价5元
//  special = [[3,0,5],[1,2,10]]，大礼包，0号商品3个，1号商品2个，5元， 0号商品1个，1号商品2个，售价10元
//  needs = [3,2] 购物需求， 0号商品买3个，2号商品买2个
  //求最便宜的价格

  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    this.price = price;
    this.special = special;
    return backTracking(needs);
  }

  private int backTracking(List<Integer> needs){

    if(cache.containsKey(needs)){
      return cache.get(needs);
    }

    //单层逻辑
    //计算不用礼包的情况
    int result = 0;
    for(int i = 0; i < needs.size(); i++){
      result += price.get(i) * needs.get(i);
    }

    //必然是优先购买礼包,但是礼包也要比价格
    //遍历大礼包的方案
    int minPriceInSpecial = Integer.MAX_VALUE;
    for(int i = 0; i < special.size(); i ++){
      //选取
      List<Integer> currSpecial = special.get(i);

      if(!isValidSpecial(currSpecial, needs)){
        continue;
      }
      //回溯
      List<Integer> updatedNeeds = new ArrayList<>(needs);
      result = Math.min(result,currSpecial.get(currSpecial.size() - 1) + backTracking(updateNeeds(currSpecial,updatedNeeds)));
    }
    cache.put(needs,result);

    return result;
  }

  private boolean isValidSpecial(List<Integer> special, List<Integer> needs){
    //检查需要购买的是否比礼包中的货物多
    for(int i = 0; i < special.size() - 1; i ++){
      if(needs.get(i) < special.get(i))
        return false;
    }
    return true;
  }

  private List<Integer> updateNeeds(List<Integer> special, List<Integer> needs){
    for(int i = 0; i < special.size() - 1; i ++){
      needs.set(i,needs.get(i) - special.get(i));
    }
    return needs;
  }

  public static void main(String[] args) {
    ShoppingOffers638 ins = new ShoppingOffers638();
    List<Integer> price = new ArrayList<>();
//    int[] prices = new int[]{2,5};
//    int[][] specials = new int[][]{{3,0,5},{1,2,10}};
//    int[] needs = new int[]{3,2};

//    int[] prices = new int[]{2,3,4};
//    int[][] specials = new int[][]{{1,1,0,4},{2,2,1,9}};
//    int[] needs = new int[]{1,2,1};

//    int[] prices = new int[]{3,4};
//    int[][] specials = new int[][]{{1,2,3},{1,2,5}};
//    int[] needs = new int[]{2,2};

//    int[] prices = new int[]{2,2};
//    int[][] specials = new int[][]{{1,1,1},{1,1,2},{1,1,3},{1,1,4},{1,1,5},{1,1,6},{1,1,7},{1,1,8},{1,1,9},{1,1,10},{1,1,11},{1,1,12},{1,1,13},{1,1,14},{1,1,15}};
//    int[] needs = new int[]{10,10};

//    int[] prices = new int[]{9};
//    int[][] specials = new int[][]{{2,2},{1,10}};
//    int[] needs = new int[]{3};

    int[] prices = new int[]{9};
    int[][] specials = new int[][]{{1,10},{2,2}};
    int[] needs = new int[]{3};


    List<Integer> pc = new ArrayList<>();
    List<List<Integer>> special = new ArrayList<>();
    List<Integer> need = new ArrayList<>();

    for(int i = 0; i < prices.length; i ++){
      pc.add(prices[i]);
    }

    for(int i = 0; i < specials.length; i ++){
      List<Integer> list = new ArrayList<>();
      for(int j = 0; j < specials[0].length; j ++){
        list.add(specials[i][j]);
      }
      special.add(list);
    }

    for(int i = 0; i < needs.length; i ++){
      need.add(needs[i]);
    }
    System.out.println(ins.shoppingOffers(pc, special,need));
  }
}
