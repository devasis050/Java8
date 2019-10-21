package practice;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Test {
	
	public static void main(String[] args) {
		
		Comparator<String> c1 = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		
		BinaryOperator<String> s = BinaryOperator.minBy(c1);
		System.out.println(s.apply("a", "b"));
	}

}
