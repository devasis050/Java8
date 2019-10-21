package test;

import java.util.ArrayList;
import java.util.List;

public class StreamApi {
	
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		for(int i=0; i <= 50 ; i++)
		{
			li.add(i);
		}
		
		long count = li.stream().filter(i->i%2==0).count();
		System.out.println(count);
		li.stream().filter(i->i%2==0).distinct().forEach(i -> System.out.println(i));
		
		int T = 0;
		
		 while (T-- > 0) {
			 
		 }
		 
	}

}
