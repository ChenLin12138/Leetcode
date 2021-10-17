package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chen Lin
 * @date 2021-10-14
 */

public class PermuteUnique {
   
	public static <T> List<T> reverseList(List<T> list) {
		List<T> reverse = new ArrayList<>(list.size());

		list.stream()
				.collect(Collectors.toCollection(LinkedList::new))
				.descendingIterator()
				.forEachRemaining(reverse::add);

		return reverse;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		
		//只有1或者0个元素的时候返回当前数组
		if (nums.length < 2) {
			return Arrays.asList(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		}

		//有2个元素的时候返回当前集合和取反的集合，其实大部分的数据都在这里结束
		if (nums.length == 2) {
			if (nums[0] == nums[1]) {
				return Arrays.asList(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			}
			List<Integer> res = Arrays.stream(nums).boxed().collect(Collectors.toList());
			List<Integer> resRev = reverseList(res);
			return Arrays.asList(new List[]{res, resRev});
		}

		//获取头元素
		int num = nums[0];

		List<List<Integer>> res = new ArrayList<>();
		
		//子规模问题的返回
		List<List<Integer>> ps = this.permuteUnique(Arrays.copyOfRange(nums, 1, nums.length));
		
		//这里用[1,1,2]举例子
		//ps=[[1,2][2,1]]
		for (List<Integer> p : ps) {
			for (int i = 0; i < nums.length; i++) {
				
				//下面在干一个什么事情呢？
				//就是从subList中通过limit选取前面几个元素和skip跳过前面几个元素
				//num+p.stream.skip(i)来拼装元素，列出一些拼装后的状态，这里做的是46题的内容
				List<Integer> subList = p.stream().limit(i).collect(Collectors.toList());
				//这里都是语句执行后，变量的状态
				//i=0;p=[1,2];subList=[]
				//i=1;p=[1,2];subList=[1](其实这个i=1是不会发生的，他在判断那里就滤掉了)
				subList.add(num);
				//i=0;p=[1,2]subList=[1]
				//i=1;p=[1,2]sublist=[1,1](其实这个i=1是不会发生的，他在判断那里就滤掉了)
				subList.addAll(p.stream().skip(i).collect(Collectors.toList()));
				//i=0;p=[1,2]subList[1,1,2]
				//i=0;p=[1,2]subList[1,1,2](其实这个i=1是不会发生的，他在判断那里就滤掉了)
				res.add(subList);
				//i=0;res=[1,1,2]
				
				
				//修建树枝的逻辑在这里:
				//当头元素与数据流中当前元素相同的时候，结束这个头元素的所有拼装
				//这是因为头元素num==p.get(i)了，那么下一次的拼装只是头元素和i的位置互换
				//那么结果是重复的
				//那么为什么p.get(i) == num直接break了呢？p.get(i) == num不行，
				//那么p.get(i+1) != num为什么不行，我觉得是因为这个返回方式的特性决定的
				//我们返回返回的是Arrays.asList(new List[]{res, resRev});
				//数组本身和数组取反。所以那些情况被取反的那个数组包含了。
				//判断条件写前面
				//i=0;p.size=2&&p.get(0)=1,num=1，所以退出。
				//i<p.size()只是为了保证p.get(i)安全的，当i>=p.size的时候，也没有机会
				//出现p.get(i) == num了
				if (i < p.size() && p.get(i) == num) {
					break;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		PermuteUnique ins = new PermuteUnique();
//		List<List<Integer>> res = ins.permuteUnique(new int[] {1, 2, 2, 2, 3, 4, 5, 7});
		List<List<Integer>> res = ins.permuteUnique(new int[] {2, 3, 4, 5, 7});
		System.out.print("sdfsdf");
	}
}
