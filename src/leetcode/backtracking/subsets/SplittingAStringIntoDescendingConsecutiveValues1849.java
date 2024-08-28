package leetcode.backtracking.subsets;

import java.util.Stack;

public class SplittingAStringIntoDescendingConsecutiveValues1849 {
    //递减序列相邻差为1
    //因为是单调递减的序列，那么第一个字符的长度不能超过10
    //题目中1 <= s.length <= 20,那么最大的一个数字就不能超过20一半，因为是递减
    //要注意超出Integer的最大的数字2147483647.
    private Stack<Long> stack = new Stack<>();

    public boolean splitString(String s) {
        //有一个逻辑如果s全是0，那么我们就把他转换成0
        s = numFormat(s);
        return backTracking(s);
    }

    private String numFormat(String s){
        //有一个逻辑如果s全是0，那么我们就把他转换成0
        boolean allZero = true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '0') {
                allZero = false;
                break;
            }
        }

        if(allZero){
            s = "0";
        }

        //因为要维护递减序列，我觉得可以先把前面的0都删除了
        if(!s.equals("0")){
            s = s.replaceFirst("^(0+)","");
        }
        return s;
    }
    private boolean backTracking(String s){
        //退出条件
        if(s.isEmpty()){
            if (stack.size() > 1)
                return true;
            else
                return false;
        }
        //单层逻辑
        //减枝
        //前导0是可以移除的
        s = numFormat(s);
        //遍历每一种拆分方案
        for(int i = 0; i < 10 && i < s.length(); i ++){
            //产生新的数字
            String str = s.substring(0,i+1);
            Long intVal = Long.parseLong(str);

            if(stack.isEmpty()){
                //选取
                stack.add(intVal);
                //回溯
                if(backTracking(s.substring(i+1)))
                    return true;
                //清理
                stack.pop();
            }else {
                //减枝
                //后面的数字更大，那么继续查找下去已经没有意义了
                if(intVal >= stack.peek()){
                    return  false;
                }
                //判断是否是前面一个元素减一，否则继续
                if(intVal == stack.peek() - 1){
                    //选取
                    stack.add(intVal);
                    //回溯
                    if(backTracking(s.substring(i+1))){
                        return true;
                    }
                    //清理
                    stack.pop();
                    //如果现在的数字依旧是小于的，那么还又继续该层循环的意义
                }else if(intVal < stack.peek()){
                    continue;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SplittingAStringIntoDescendingConsecutiveValues1849 ins = new SplittingAStringIntoDescendingConsecutiveValues1849();
//        System.out.print(ins.splitString("1234"));
//        System.out.print(ins.splitString("050043"));
//        System.out.print(ins.splitString("9080701"));
//        System.out.print(ins.splitString("10009998"));
//        System.out.print(ins.splitString("4771447713"));
//        System.out.print(ins.splitString("3202872336"));
//        System.out.print(ins.splitString("10"));
        System.out.print(ins.splitString("200100"));
    }
}
