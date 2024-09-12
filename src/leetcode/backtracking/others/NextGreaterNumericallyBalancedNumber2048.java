package leetcode.backtracking.others;

public class NextGreaterNumericallyBalancedNumber2048 {
    public int nextBeautifulNumber(int n) {
        for(int i = n + 1; i <= 1224444; i ++){
            if(isBalance(i)){
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance(int d){
        int[] bucket = new int[10];
        while(d > 0){
            bucket[d % 10]++;
            d/=10;
        }

        for(int i = 0; i < 10; i ++){
            if(bucket[i] != 0 && bucket[i] != i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NextGreaterNumericallyBalancedNumber2048 ins = new NextGreaterNumericallyBalancedNumber2048();
//        System.out.println(ins.nextBeautifulNumber(1));
//        System.out.println(ins.nextBeautifulNumber(0));
        System.out.println(ins.nextBeautifulNumber(748601));
    }
}
