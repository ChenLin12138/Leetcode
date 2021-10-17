package leetcode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Chen Lin
 * @date 2020-07-05
 */

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new TreeSet();
		set.add(5);
		set.add(2);
		set.add(1);
		set.add(3);
		set.add(4);
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			set.iterator().next();
		}
		
		
	}

}
