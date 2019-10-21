package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
	
	public static void main(String[] args) {
		
		List<Integer> li = new ArrayList<>();
		
		for(int i=1; i <= 10; i ++)
		{
			li.add(i);
		}
		
		collect(li);
		
		//forEach
		System.out.println("foreach() example");
		Stream<Integer> st = li.stream();
		st.forEach((t) -> System.out.print(t + " "));
		//map
		System.out.println("\nmap() example");
		st = li.stream();
		st.map((t) -> t + "A ").forEach(t -> System.out.print(t));
		
		//filter
		System.out.println("\nfilter() example");
		st = li.stream();
		st.filter(t -> t % 2==0).forEach(t -> System.out.print( t + " "));
		
		//toAray
		System.out.println("\ntoArray example");
		st = li.stream();
		Integer[] arr = (Integer[]) st.filter(t -> t % 2==1).toArray(Integer[]::new);
		System.out.println(Arrays.toString(arr));
		
		//flatMap
		System.out.println("flatMap example");
		List<List<String>> llist = Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C", "D"));
		Stream<List<String>> sstream = llist.stream();
		List<String> list = sstream.flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(list.size() + ":" + list );
		
		//reduce
		System.out.println("reduce Examaple");
		st = Stream.of(1,2,3);
		Optional<Integer> op = st.reduce((a,b) -> a+b); // 1 +2+3 = 6
		System.out.println(op.get());
		st = Stream.of(1,2,3);
		Integer res = st.reduce(10, (a,b) -> a+b);
		System.out.println(res);
		
	}

	private static void collect(List<Integer> li) {
		Stream<Integer> st = Stream.of(1, 2);
		List<Integer> li2 = st.collect(Collectors.toList());
		li2.remove(0);
		System.out.println(li2.get(0));
		System.out.println(li.get(0));
		
		st = Stream.of(1, 2);
		Double d = st.collect(Collectors.averagingInt((t) -> t));
		System.out.println(d);
		
		
		Stream<String> st1 = Stream.of("a", "b");
		String str = st1.collect(Collectors.joining(" "));
		System.out.println(str);
		
		st = Stream.of(1, 2);
		Map<String, Integer> map = st.collect(Collectors.toMap(t->t + "a",t->t));
		System.out.println(map);
		
	}

	private static void forEach(List<Integer> li) {
		Stream<Integer> st = li.stream();
		System.out.println("Printing list elements using for each");
		st.forEach((t) -> System.out.print(t + " "));
		System.out.println(" \nEnd - for each");
	}

}
