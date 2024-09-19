package leetcode.backtracking.combinations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PatternMatchingLcci1618 {
//    单词之间没有可分隔的东西，靠遍历去枚举 pattern 字母对应的单词
//    递归函数是求 pattern (子)串和 value (子)串是否匹配，递归入口是完整的两个串
//    问题分解为：开头的匹配问题 + 剩余子串的匹配问题
//    递归向下会遇到不符合条件的情况，需要撤销选择，回到原来的状态，进入到别的分支
//    递归树如下图，注意的是，a 和 b 可以为空字符串，所以 for 循环从 -1 开始(但是Java是不支持从-1开始subString的)

    //map存放pattern字母和他的单词
    //例如保存的是题目中的key=a,value=dog, key=b,value=dog
    private Map<Character, String> map = new HashMap<>();
    //存放pattern存放则字母对应的单词，确保不回重复
    private Set<String> set = new HashSet<>();



    public boolean patternMatching(String pattern, String value) {
        return backTracking(pattern,value);
    }

    private boolean backTracking(String pattern, String value){
        //退出条件
        //当pattern为空的时候,value也需要为空才是true
        if(pattern.isEmpty()){
            return value.isEmpty();
        }

        //单层逻辑
        Character mapKey = pattern.charAt(0);
        //这里讨论map已经设置了mapKey了，检查这个map中设置的规则是否和value中开头的字符串匹配
        if(map.containsKey(mapKey)){
            //不匹配那就返回false
            if(!value.startsWith(map.get(mapKey)))
                return false;
            //匹配就继续，一下个pattern和剩下的value
            //回溯
            return backTracking(pattern.substring(1), value.substring(map.get(mapKey).length()));
        }
        //这里讨论map中不包含mapKey的情况
        //因为其实patterna和patternb是可以为空的，所以我们还要考虑str为空的情况
        String str = "";
        if(!set.contains(str)){
            //选取
            map.put(mapKey,str);
            set.add(str);
            //回溯
            if(backTracking(pattern.substring(1),value))
                return true;
            //清理
            map.remove(mapKey);
            set.remove(str);
        }

        for(int i = 0; i < value.length(); i ++){
            //选取
            str = value.substring(0,i+1);
            //str已经是一个模式对应的value，那么我们跳过这个分支
            if(set.contains(str)){
                continue;
            }
            map.put(mapKey,str);
            set.add(str);
            //回溯
            if(backTracking(pattern.substring(1),value.substring(i+1))){
                return true;
            }
            //清理
            map.remove(mapKey);
            set.remove(str);
        }
        //如果匹配不到结果，我们就返回false
        return false;
    }

    public static void main(String[] args) {
        PatternMatchingLcci1618 ins = new PatternMatchingLcci1618();
//        System.out.println(ins.patternMatching("abba", "dogcatcatdog"));
//        System.out.println(ins.patternMatching("abba", "dogcatcatfish"));
//        System.out.println(ins.patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(ins.patternMatching("abba", "dogdogdogdog"));
    }
}
