package leetcode;
class CoinChange {
    public int coinChange(int[] coins, int amount) {
    
    int result = f(coins, amount);
		
		if(Integer.MAX_VALUE -1 == result) {
			result = -1;
		}
		
		return result;

    }

	private int f(int[] coins, int amount) {		
		
		int result = Integer.MAX_VALUE-1;		
		
		if(amount == 0) {
			return 0;
		}
		
		if(amount == 1) {
			return 1;
		}
		
		for(int i = 0; i < coins.length; i++) {
			if(amount >= coins[i]) {
				result = Math.min(f(coins, amount-coins[i])+1,result);
			}
		}			
		return result;
    }
	
	public static void main(String[] args) {
		CoinChange s = new CoinChange();
		int[] coins = {1,2,5};
		int amount = 50;
		long t1 = System.currentTimeMillis();
		int res = s.coinChange(coins, amount);
		System.out.println(res);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
	}

}