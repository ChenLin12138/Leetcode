package leetcode.backtracking.combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IteratorForCombination1286 {

    private List<String> container = new ArrayList<>();
    private Stack<Character> stack = new Stack<>();

    private int targetSize;

    private int index;
    private int size;

    public IteratorForCombination1286 (String characters, int combinationLength) {
        //因为character中的每一个字符都不同，那么我们不用考虑排序
        //我们是按照字典顺序输出，不需要"ba"这样的组合
        this.targetSize = combinationLength;
        backTracking(characters, combinationLength);
        this.size = container.size();
        this.index = -1;
    }

    private void backTracking(String characters, int combinationLength){
        //退出条件
        if(combinationLength == 0 || characters.isEmpty()){
            StringBuffer sb = new StringBuffer();
            if(stack.size() == this.targetSize){
                for(int i = 0 ; i < stack.size(); i++){
                    sb.append(stack.get(i));
                }
                container.add(sb.toString());
            }
        }
        //单层逻辑
        for(int i = 0; i < characters.length(); i ++){
            //减枝:因为character中的每一个字符都不同，那么我们不用考虑排序
            //选取
            char newChar = characters.charAt(i);
            stack.add(newChar);
            //回溯
            backTracking(characters.substring(i+1),combinationLength - 1);
            //清理
            stack.pop();
        }
    }

    public String next() {
        if(hasNext()){
            index ++;
            return container.get(index);
        }else{
            return "";
        }
    }

    public boolean hasNext(){
        return index + 1 <=  this.size - 1 ? true : false;
    }

    public static void main(String[] args) {
        //表达返回"abc"的有2个位置的组合
        //构造函数是关键，构造函数生成所有的2个位置的组合
        IteratorForCombination1286 ins = new IteratorForCombination1286("abc",2);
//        IteratorForCombination1286 ins = new IteratorForCombination1286("chp",1);
    }
}
