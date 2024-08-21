package leetcode.backtracking.segmentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SplitArrayIntoFibonacciSequence842 {

    //总体上面是f1+f2=f3,
    //数字的总长度位200
    List<Integer> result = new ArrayList<>();
    Stack<Integer> subResult = new Stack<>();

    public List<Integer> splitIntoFibonacci(String num) {
        backTracking(num);
        return result;
    }
    private boolean backTracking(String num){
        //退出条件
        if(num.isEmpty()){
            if(subResult.size() > 2){
                result.addAll(new ArrayList<>(subResult));
                return true;
            }
            return false;
        }

        //单层逻辑
        for(int i = 0; i < num.length(); i ++){
            //选取
            //其实在做前面的值填充的时候我们要明白第一个数和第二数相加 = 第三个数。任何一个数极端情况下，都不应该位数 > 总长度的二分之一
            if(subResult.size() < 2){
                //选取
                String subString = num.substring(0,i+1);
                if(!isValidNumber(subString)) return false;

                long long_cur = Long.parseLong(subString);
                if(long_cur > Integer.MAX_VALUE)
                    break;

                int cur = Integer.parseInt(subString);
                subResult.add(cur);
                //回溯
                if(backTracking(num.substring(i+1)))
                    return true;
                //清理
                subResult.pop();
            }else {
                //选取
                String subString = num.substring(0,i+1);
                if(!isValidNumber(subString)) return false;

                long long_cur = Long.parseLong(subString);
                if(long_cur > Integer.MAX_VALUE)
                    break;
                int cur = Integer.parseInt(subString);

                if(cur < subResult.get(subResult.size() - 1) + subResult.get(subResult.size() - 2)){
                    continue;
                }else if(cur > subResult.get(subResult.size() - 1) + subResult.get(subResult.size() - 2)){
                    //因为cur会越来越来，所以没有必要比较下去了
                    break;
                }

                subResult.add(cur);
                //回溯
                if(backTracking(num.substring(i+1)))
                    return true;
                //清理
                subResult.pop();
            }
        }
        return false;
    }

    //不合法针对得就是以0开头得数字组合
    private boolean isValidNumber(String str){
        if (str.length() > 1 && str.charAt(0) == '0')
            return false;
        return true;
    }

    public static void main(String[] args) {
        SplitArrayIntoFibonacciSequence842 ins = new SplitArrayIntoFibonacciSequence842();
//        System.out.println(ins.splitIntoFibonacci("1101111"));
//        System.out.println(ins.splitIntoFibonacci("5511816597"));
//        System.out.println(ins.splitIntoFibonacci("14748364221"));
//        System.out.println(ins.splitIntoFibonacci("214748364721474836422147483641"));
        System.out.println(ins.splitIntoFibonacci("1320581321313221264343965566089105744171833277577"));
    }
}
