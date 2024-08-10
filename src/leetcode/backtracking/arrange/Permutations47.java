package leetcode.backtracking.arrange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chen Lin
 * @date 2021-09-12
 */

public class Permutations47 {

	//输入[1,2],[a,b],[A,B]
	//输出全排列[
	//[1,a,A],[1,a,B],[1,b,A],[1,b,B],
	//[2,a,A],[2,a,B],[2,b,A],[2,b,B]
	//]

	//要求输入一个List<List<String>>列表，里面包含了n个String数组，求他们概率组合的全排列
	//解题的关键是把List.get(0)那出来遍历他里面的元素，然后传入List.get(1)，将这个from List.get(0)的
	//问题转换成一个from List.get(1)的小规模的问题
	public List<List<String>> recu (List<List<String>> list) {

		List<List<String>> res = new LinkedList<List<String>>();

		//退出条件
		if (list.isEmpty()) return res;

		//单层逻辑
		//遍历List.get(0)的所有元素
		//拼接递归的返回值
		for(String head : list.get(0)) {
			List<List<String>> subRes = recu(list.subList(1, list.size()));
			if(subRes.isEmpty()) {
				res.add(new LinkedList<String>(Arrays.asList(head)));
			}

			for(List<String> subList : subRes) {
				subList.add(0, head);
				res.add(subList);
			}
		}

		//传递参数
		//传入List<List<String>>, List<List<String>>
		return res;
	}

	//测试使用
	public static void main(String[] args) {
		Permutations47 ins = new Permutations47();
		List<List<String>> input = new ArrayList<List<String>>();

		input.add(Arrays.asList("1","2"));
		input.add(Arrays.asList("a","b"));
		input.add(Arrays.asList("A","B"));

		System.out.print("[");
		for(List<String> list : ins.recu(input)) {
			System.out.print("[");
			int i = 0;
			for(String e : list) {
				if(i == list.size() -1) {
					System.out.print(e);
				}else {
					System.out.print(e+",");
				}
				i ++;
			}
			System.out.print("]");
		}
		System.out.print("]");
	}

}
