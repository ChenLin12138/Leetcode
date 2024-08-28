package leetcode.backtracking.chessboard;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MaximumCompatibilityScoreSum1947 {

    int result = 0;
    Stack<Integer> usedMentors = new Stack<>();
    //意见是否相同又点按位与的意思
    //学生和老师可以相互匹配与一个最大值不就完了，不需要回溯啊
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int markNum = students[0].length;
        Set<Integer> mentorsSelected = new HashSet<>();
        //先把大家的意见转换成位,其实是求同或操作，相同则为1.
        int[] sArray = convert2Bit(students);
        int[] mArray = convert2Bit(mentors);
        //这个一数组表达第i个学生和第j个导师之间问卷相同的结果
        int[][] stuendMentorsArray = new int[students.length][students.length];

        //sArray和mArray同或
        for(int i = 0; i < sArray.length; i ++){
            int count = 0;
            for(int j = 0; j < mArray.length; j ++){
                //异或运算
                //这里就计算出了大家有多少不同,因为是异或，所以1的个数就表达了不同
                int xnorRequest =  (sArray[i] ^ mArray[j]);
                //那么问答总数 - 不同的总数 = 相同的总数
                count = markNum - Integer.bitCount(xnorRequest);
                stuendMentorsArray[i][j] = count;
            }
        }

        backTracking(stuendMentorsArray,0,0);

        return result;
    }

    //选出行列各不相同的组合的最大值
    //这其实是和n皇后非常类似的问题，我们可以把他认为是n个车的问题
    //行数不断的下层，然后记录列，列不能重复
    private void backTracking(int[][] stuendMentorsArray, int sIndex, int sum){
        //退出条件
        if(sIndex == stuendMentorsArray.length){
            result = Math.max(result,sum);
            return;
        }
        //单层逻辑
        //选择每一个老师,这其实和n皇后一样的，相当于是n车
        for(int i = 0; i < stuendMentorsArray[0].length; i++){
            //导师是否被选中过,则跳过
            if(usedMentors.contains(i)){
                continue;
            }
            //选取
            usedMentors.add(i);
            //回溯
            backTracking(stuendMentorsArray, sIndex + 1, sum + stuendMentorsArray[sIndex][i]);
            //清理
            usedMentors.pop();
        }

    }

    //将二维数组转成一维
    private int[] convert2Bit(int[][] input){
        int[] result = new int[input.length];
        for(int i = 0; i < input.length; i ++){
            int e = 0;
            for(int j = 0; j < input[0].length ; j++){
                e += input[i][j] << (input[0].length - j - 1);
            }
            result[i] = e;
        }
        return result;
    }


    public static void main(String[] args) {
        MaximumCompatibilityScoreSum1947 ins = new MaximumCompatibilityScoreSum1947();
        int[][] students = new int[][]{{1,1,0},{1,0,1},{0,0,1}};
        int[][] mentors = new int[][]{{1,0,0},{0,0,1},{1,1,0}};
//        int[][] students = new int[][]{{0,0},{0,0},{0,0}};
//        int[][] mentors = new int[][]{{1,1},{1,1},{1,1}};
        System.out.print(ins.maxCompatibilitySum(students,mentors));
    }
}
