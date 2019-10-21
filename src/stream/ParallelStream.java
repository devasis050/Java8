package stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {
	
	public static void main(String[] args) {
		Stream<String> st = Stream.of("A", "B");
		st.parallel();
		st.sequential();
		
		List<String> li= null;
		Stream<String> st1 = li.parallelStream();
		
		IntStream in = IntStream.range(1, 5);
		in.parallel();
	}

}
