package stream;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalSample {
	
	public static void main(String[] args) {
		Stream<Integer> st = Stream.of(1,2);
		Optional<Integer> op = st.findFirst();
		op.ifPresent(System.out::print);
	}

}
