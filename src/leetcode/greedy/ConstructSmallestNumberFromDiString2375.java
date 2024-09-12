package leetcode.greedy;

public class ConstructSmallestNumberFromDiString2375 {

    //因为要求最小，那么前面的数字尽量用小的填写
    //对输入的数字排个序
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        //先生成一个递增序列
        char[] c = new char[n + 1];
        for(int i = 0; i < n + 1; i ++){
            c[i] = (char) ('1' + i);
        }
        int i = 0;
        int j = 0;
        while (j < n){
            //计算出连续递增的位置
            while (j < n && pattern.charAt(j) == 'I')
                j++;
            //标记连续升序的位置
            i = j;
            //计算出连续递减的位置
            while (j < n && pattern.charAt(j) == 'D')
                j++;
            reverse(c,i,j);
        }
        return new String(c);
    }

    //这个不仅仅交换了i和j的位置，还维护了交换数据的单调递减的性质
    private void reverse(char[] c, int i, int j) {
        int n = c.length;
        if (j == n)
            j = n - 1;

        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }

    public static void main(String[] args) {
        ConstructSmallestNumberFromDiString2375 ins = new ConstructSmallestNumberFromDiString2375();
        System.out.println(ins.smallestNumber("IIIDIDDD"));
    }


}
