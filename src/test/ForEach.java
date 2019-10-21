package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("a","b","c","d", "e", "f","g");
//		strList.forEach(System.out::print);
//		System.out.println();
//		strList.stream().filter(str->str.startsWith("a")).forEach(System.out::print);
		
		List<Integer> li = new ArrayList<>();
		for(int i=0; i <= 50 ; i++)
		{
			li.add(i);
		}
		li.forEach(System.out::println);
	}
}
