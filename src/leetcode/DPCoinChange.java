package leetcode;

/**
 * @author Chen Lin
 * @date 2021-03-21
 */

public class DPCoinChange {

	/*
	 * @param conins 硬币的面值
	 * @param amount 硬币求和的金额
	 * @return 返回最少几枚硬币能够拼出指定的金额，若没有则返回-1
	 * */
	public int coinChange(int[] coins, int amount) {
		
		//因为cache[0],cache[1]....cache[27]都要表示，数组长度为amount+1
		int cache[] = new int[amount+1];
		
		cache[0] = 0;
		
		for(int i = 1; i <= amount ; i++) {
			//先给所有位置默认赋最大值，表示这个数无法表示，一定计算值比max小，就更新到数组中
			cache[i] = Integer.MAX_VALUE;
		}
		
		//cache[i]表示要计算的当前amount最少需要多少硬币拼凑
		for(int i = 1; i <= amount ; i++) {
			//coins[j]表示我们拥有的银币面值大小，例如coins[]={1,2,5}
			for(int j = 0; j < coins.length ; j++) {
				//i-coins[j] >= 0表示，过滤大面值硬币表达小amount的情况，例如3不可能被5元表达
				//Integer.MAX_VALUE !=cache[i-coins[j]]，表达cache[i-coins[j]]不能是无法表达的数的情况。
				//例如我们的货种类是2,3,7，那么3是无法表达的，那么6就不能通过3+3lai表达，因为3这个时候是Integer.MAX_VALUE
				if(i-coins[j] >= 0 &&  Integer.MAX_VALUE !=cache[i-coins[j]]) {
					cache[i] = Math.min(cache[i-coins[j]]+1, cache[i]);
				}
				
			}
		}
		
		if(cache[amount] == Integer.MAX_VALUE) {
			cache[amount] = -1;
		}
		
		return cache[amount];
		
    }
	
	public static void main(String[] args) {
		DPCoinChange coinChange = new DPCoinChange();
		int[] coins = {1,2,5};
		int amount = 27;
		//测试用例（2，5，7的硬币组合拼出27）
		long t1 = System.currentTimeMillis();
		System.out.println(coinChange.coinChange(coins, amount));
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		

	}

}
