package leetcode;
class CoinChangeFix {
    public int coinChange(int amount) {
    
    int result = f(amount);
		if(Integer.MAX_VALUE -1 == result) {
			result = -1;
		}
		
		return result;

    }

	private int f(int amount) {		
//用Integer.MAX_VALUE-1表示正无穷，正无穷表示无法拼凑的数字，在我们的例子
//用1，2，5拼凑27中，没有这样的问题，因为我们的amount都是整数，我们有货币1,那么就没有无法表示的数字，但是如果我们的货币没有1，
//例如用2,5,7表示27。那么1,3就成了而无法表述的数字.
//不用Integer.MAX_VALUE表示正无穷是因为:Math.min(f(amount-1)+1, result)运行时，
//Math.min(f(Integer.MAX_VALUE+1, Integer.MAX_VALUE)会因为Integer.MAX_VALUE+1的溢出的到不正确的答案
		int result = Integer.MAX_VALUE-1;		
		
		if(amount == 0) {
			return 0;
		}
		
		if(amount >= 1) {
			result = Math.min(f(amount-1)+1, result);
		}
		
		if(amount >= 2) {
			result = Math.min(f(amount-2)+1, result);
		}
		
		if(amount >= 5) {
			result = Math.min(f(amount-5)+1, result);
		}		
		return result;
    }
	
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		CoinChangeFix s = new CoinChangeFix();
		int amount = 45;
		int res = s.coinChange(amount);
		System.out.println(res);
		long t2 = System.currentTimeMillis();
		System.out.print(t2-t1);
		
	}

}