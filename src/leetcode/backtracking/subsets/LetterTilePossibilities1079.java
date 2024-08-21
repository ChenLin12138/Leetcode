package leetcode.backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LetterTilePossibilities1079 {
    //这是一个子集问题，每一个结果不是在叶子节点，而是在递归的路径上
    private int count = 0;
//    private Stack<Character> stack = new Stack<>();
    private List<String> res = new ArrayList<>();
    public int numTilePossibilities(String tiles) {
        //先对字符进行排序
        char[] charArray = tiles.toCharArray();
        Arrays.sort(charArray);
        backTracking(new String(charArray));
        //因为答案不要空集合，所以我们删除一个
        return count - 1;
    }

    private void backTracking(String tiles){
        count ++;
//        StringBuffer sb = new StringBuffer();
//        for (Character character : stack) {
//            sb.append(character);
//        }
//        res.add(sb.toString());
        //退出条件
        if(tiles.isEmpty()){
            return;
        }

        //单层逻辑
        for(int i = 0; i < tiles.length(); i++){
            //减枝
            //前后一个字符和后面的字符一样的情况那么这种情况可以减枝,我们当前情况可以跳过,不进行回溯
            if(i < tiles.length() - 1 && tiles.charAt(i) == tiles.charAt(i+1))
                continue;
            //选取
//            stack.add(tiles.charAt(i));
            //回溯
            backTracking(tiles.substring(0,i)+tiles.substring(i+1));
            //清理
//            stack.pop();
        }
    }

    public static void main(String[] args) {
        LetterTilePossibilities1079 ins = new LetterTilePossibilities1079();
//        System.out.println(ins.numTilePossibilities("AAB"));
        System.out.println(ins.numTilePossibilities("AAABBC"));
//        System.out.println(ins.numTilePossibilities("V"));
    }
}
