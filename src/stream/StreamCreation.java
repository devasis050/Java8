package stream;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class StreamCreation {
	public static void main(String[] args) {
		List<Integer> li = null;
		Stream<Integer> st1 = li.stream();

		Stream<String> st2 = Stream.of("asd", "asd");

		Integer arr[] = new Integer[1];
		Stream<Integer> st3 = Stream.of(arr);

		Stream.Builder<Integer> builder = Stream.builder();
		builder.accept(1);
		builder.accept(2);
		Stream<Integer> st4 = builder.build();

		IntStream ins = IntStream.of(1, 2);
		IntStream ins2 = IntStream.range(0, 5);
		IntStream ins3 = IntStream.iterate(0, t -> t + 2);

		DoubleStream ds = DoubleStream.generate(Math::random);
		DoubleStream ds2 = DoubleStream.builder().build();
		
		
Stream<Double> st = Stream.generate(Math::random);
DoubleStream ds1 = DoubleStream.generate(Math::random);
	}
}
