package leetcode.backtracking.combinations;

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 {

    //这个问题，我们要的只是放和不放。
    private int max = 0;
    //只有小写字母，我们搞一个单词表吧
    private boolean[] dict = new boolean[26];
    //用位来表示字符是否使用
    Stack<String> stack = new Stack<>();
    //两个字符串没有交集那么就可以拼接
    int totalVal = 0;
    public int maxLength(List<String> arr) {
        List<String> list =  removeInvalidElement(arr);
        this.totalVal  = getTotalVal(list);
        backTracking(list);
        return max;
    }

    private int getTotalVal(List<String> arr){
        int sum = 0;
        for(String str : arr){
            sum += str.length();
        }
        return sum;
    }

    //这个用来删除同一个String中包含两个或以上的字符
    private List<String> removeInvalidElement(List<String> arr){
        List<String> list = new ArrayList<>();
        for(String str : arr){
            boolean valid = true;
            Set<Character> charSet = new HashSet<>();
            for(int i = 0; i < str.length(); i ++){
                if(!charSet.contains(str.charAt(i))){
                    charSet.add(str.charAt(i));
                }else {
                    valid = false;
                }
            }
            if (valid)
                list.add(str);
        }
        return list;
    }

    private void backTracking(List<String> arr){
        //退出条件
        if(arr.isEmpty()){
            int currSize = 0;
            for(int i = 0; i < stack.size(); i++){
                currSize += stack.get(i).length();
            }
            max = Math.max(max,currSize);
            return;
        }
        //单层逻辑
        if (this.totalVal == max)
            return;

        //选取的情况
        if(isConcatAble(arr.get(0))){
            stack.add(arr.get(0));
            List<String> newArray = new ArrayList<>(arr);
            newArray.remove(0);
            markDict(arr.get(0), true);
            //回溯
            backTracking(newArray);
            //清理
            markDict(arr.get(0), false);
            stack.pop();
        }

        //但是无论如何我们都可以不选
        List<String> newArray = new ArrayList<>(arr);
        newArray.remove(0);
        backTracking(newArray);
    }

    private boolean isConcatAble(String str){
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(dict[index]){
                return false;
            }
        }
        return true;
    }

    private void markDict(String str, boolean mark){
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            dict[index] = mark;
        }
    }

    public static void main(String[] args) {
        MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 ins = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239();
        List<String> input = new ArrayList<>();
//        String[] array = new String[]{"un","iq","ue"};
//        String[] array = new String[]{"cha","r","act","ers"};
//        String[] array = new String[]{"abcdefghijklmnopqrstuvwxyz"};
        String[] array = new String[]{"aa","bb"};
//        String[] array = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
//        String[] array = new String[]{"ab","ba","cd","dc","ef","fe","gh","hg","ij","ji","kl","lk","mn","nm","op","po"};
        for(int i = 0; i < array.length; i ++){
            input.add(array[i]);
        }
        System.out.print(ins.maxLength(input));
    }
}
