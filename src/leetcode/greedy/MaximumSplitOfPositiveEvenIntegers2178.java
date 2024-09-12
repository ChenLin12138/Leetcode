package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers2178 {
    //拆分最多的正偶数之和
    //1.偶数多
    //2.偶数互不相同
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        //偶数+偶数必然是偶数，那么我们要求finalSum必然位偶数
        if(finalSum % 2 != 0){
            return result;
        }
        //开始拆分
        long evenStage = 2L;
        while(finalSum >= evenStage){
            result.add(evenStage);
            finalSum -= evenStage;
            evenStage+= 2;
        }
        //最后添加剩余的不能拆分的数到result的末尾
        long lastVal = result.get(result.size() - 1) + finalSum;
        result.set(result.size() - 1, lastVal);
        return result;
    }

    public static void main(String[] args) {
        MaximumSplitOfPositiveEvenIntegers2178 ins = new MaximumSplitOfPositiveEvenIntegers2178();
//        System.out.println(ins.maximumEvenSplit(12));
//        System.out.println(ins.maximumEvenSplit(7));
        System.out.println(ins.maximumEvenSplit(28));
    }
}
