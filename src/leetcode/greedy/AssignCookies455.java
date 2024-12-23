package leetcode.greedy;

import java.util.Arrays;

public class AssignCookies455 {
    int res = 0;
    public int findContentChildren(int[] g, int[] s) {
        //饼干投递那么我们考虑最小的饼干投递胃口最小的小朋友。
        //小朋友胃口升序排列
        Arrays.sort(g);
        //饼干升序排列
        Arrays.sort(s);
        //那么我们现在开始小饼干开始投递胃口小的小朋友，饼干完毕就结束
        int gIndex = 0;
        int sIndex = 0;
        while(sIndex < s.length && gIndex < g.length){
            //饼干能满足小朋友
            if(s[sIndex] >= g[gIndex]){
                res ++;
                gIndex ++;
                sIndex ++;
                continue;
            }
            //这里是饼干不能满足小朋友的情况
            //那么换一个大饼干
            sIndex ++;
        }

        return res;
    }

    public static void main(String[] args) {
        AssignCookies455 ins = new AssignCookies455();
//        int[] g = new int[]{1,3,2};
//        int[] s = new int[]{1,1};
        int[] g = new int[]{1,2};
//        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{1,2,3};
//        int[] s = new int[]{5,6,7,8};
        System.out.println(ins.findContentChildren(g,s));
    }
}
