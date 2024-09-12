package leetcode.backtracking.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FairDistributionOfCookies2305 {
    private int k = 0;
    private List<Integer> cookieInKidsHand = new ArrayList<>();
    private int maxVal = Integer.MAX_VALUE;
    private int cookieSize;
    private int[] cookies;
    private int result = Integer.MAX_VALUE;

    //尽量平均分，返回不公平的最大的那个值是好多
    public int distributeCookies(int[] cookies, int k) {
        this.k = k;
        this.cookieSize = cookies.length;
        this.cookies = cookies;
        for(int i = 0; i < k; i ++){
            cookieInKidsHand.add(0);
        }
        //从大到小排序
        int[] sortedArr = Arrays.stream(cookies)
                .boxed()
                .sorted((num1, num2) -> num2.compareTo(num1))
                .mapToInt(Integer::intValue)
                .toArray();
        this.cookies = sortedArr;
        backTracking(0);
        return result;
    }

    //这个cookies是不断消耗的
    private void backTracking(int index){
        //退出条件
        if(index > cookieSize - 1){
            int currMax = cookieInKidsHand.get(0);
            for(Integer e : cookieInKidsHand){
                currMax = Math.max(e, currMax);
            }
            maxVal = Math.min(maxVal,currMax);
            result = maxVal;
            return;
        }
        //单层逻辑
        //减枝1
        //如果剩余的饼干包都不够给空手的小朋友，那么这绝对不是一个好的方案
        //计算空手的小朋友
//        int noCookieNo = 0;
//        for(int i = 0; i <cookieInKidsHand.size(); i ++){
//            if(cookieInKidsHand.get(i) == 0){
//                noCookieNo ++;
//            }
//        }
//
//        if(cookies.length - index < noCookieNo)
//            return;
//
//        //减枝2，因为之前的答案是不断的被算出来和更新的，如果现在某个小朋友分的饼干
//        //已经比前面的计算结果还多了，那么这个方案肯定是不靠谱的
//        for(int i = 0; i < cookieInKidsHand.size(); i++){
//            if(cookieInKidsHand.get(i) > result){
//                return;
//            }
//        }

        //当前这一块饼干是可以分给任意一个小朋友的
        for(int i = 0; i < k; i ++){
            //分配第一个饼干包的时候分配给谁都一样
            //index表达的是第一个饼干包,i表达的是第几个小朋友
            //这里是一个重要的剪枝
            if(index == 0 && i > 0 )
                return;
            //选取
            int backupCookieNo = cookieInKidsHand.get(i);
            cookieInKidsHand.set(i ,cookieInKidsHand.get(i) + cookies[index]);
            //回溯
            backTracking(index + 1);
            //清理
            cookieInKidsHand.set(i ,backupCookieNo);
        }
    }

    public static void main(String[] args) {
        FairDistributionOfCookies2305 ins = new FairDistributionOfCookies2305();
//        System.out.println(ins.distributeCookies(new int[]{8,15,10,20,8}, 2));
        System.out.println(ins.distributeCookies(new int[]{6,1,3,2,2,4,1,2}, 3));
    }

}

