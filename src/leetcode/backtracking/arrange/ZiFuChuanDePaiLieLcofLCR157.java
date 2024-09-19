package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ZiFuChuanDePaiLieLcofLCR157 {
    //这个问题就是一个排列问题
    //你把排列都排好了就完事了
    String[] res;
    List<String> list = new ArrayList<>();
    Stack<Character> stack = new Stack<>();
    int index = 0;
    public String[] goodsOrder(String goods) {
        char[] charArray = goods.toCharArray();
        Arrays.sort(charArray);
        //goods排序
        goods = new String(charArray);
        backTracking(goods);
        res = new String[list.size()];
        int i = 0;
        for(String str : list){
            res[i++] = str;
        }
        return res;
    }
    private void backTracking(String goods){
        //退出条件
        if(goods.isEmpty()){
            //将char添加成String
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < stack.size(); i ++){
                sb.append(stack.get(i));
            }
            list.add(sb.toString());
            return;
        }
        //单层逻辑
        //减枝，考虑让输入有序，重复的字符产生的回溯是一样的。
        //如果后面的一个字符等于前面的字符，那么跳过前面面一个
        for(int i = 0; i < goods.length(); i++){
            //选取
            char c = goods.charAt(i);
            if(i + 1 < goods.length() && goods.charAt(i) == goods.charAt(i + 1)){
                continue;
            }
            stack.push(c);
            //回溯
            backTracking(goods.substring(0,i)+goods.substring(i+1));
            //清理
            stack.pop();
        }
    }

    public static void main(String[] args) {
        ZiFuChuanDePaiLieLcofLCR157 ins = new ZiFuChuanDePaiLieLcofLCR157();
//        Arrays.stream(ins.goodsOrder("aab")).forEach(x -> System.out.println(x));
        Arrays.stream(ins.goodsOrder("aab")).forEach(x -> System.out.println(x));
    }
}
