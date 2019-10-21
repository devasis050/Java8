# Java8
 java8 practice

 Links
Functional programing vs OOP
https://www.youtube.com/watch?v=nL7H4F_ly_k&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=5
Introduction to Lambda:- How to convert a normal method to lambda expression.
https://www.youtube.com/watch?v=nUIAvs4OEkM&index=6&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3
https://www.youtube.com/watch?v=BK5iSG5yMT0&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=7

Difference between anonymous implementation class and lambda
https://www.youtube.com/watch?v=kpK2e343v48&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=8#t=3.157392

1)	Return is not required in one-line lambda. In fact, you cannot use it without braces. But it is required in multiline lambda. 

Difference between final and effectively final
A variable or parameter whose value is never changed after it is initialized is effectively final.

Anonymous inner class is different from Lambda
1)	“this” in anonymous inner class refers to this of anonymous inner class object but in lambda it refers to outer class this. There is not “this” in lambda. 

Meta Space in Java 8
On a high level, it has been introduced in place of perm gen. It can grow at run time unlike perm gen.
HashMap
Internally it uses Tree for collision use case.
Initially it stores in Node (LinkedList)
When LinkedList size greater than TREEIFY_THRESHOLD=8(default) it is converted to TreeNode.

CHM
Internally it does not use Segment anymore and it uses synchronized() on table[index].

Stream
https://www.baeldung.com/java-streams
https://www.geeksforgeeks.org/java-8-stream/
https://stackify.com/streams-guide-java-8/
https://www.baeldung.com/java-streams 
What is Stream?
Streams are wrapper around data source (Collection, Arrays, elements etc). It allows us to perform aggregate operations (Like filter(), map(), find(), match() etc) and Pipelining. 
Pipelining: Intermediate Stream operation return Stream which can be pipelined for another operation. 
It does not modify the underlying data source.
It is like conveyor belt of items of stream and multiple operations are done on same item in one loop. 
Lazy Evaluation: All intermediate operations are lazy; these are not performed until it is required. 
E.g. stream.map().findFirst() : - map() will not be executed for second item onwards as findFirst() would return for the first element. In this case the operation is triggered by findFirst().
https://stackify.com/streams-guide-java-8/
Advantages: - 
Easy to write. These are declarative style coding than performance.
Code looks concise small (Not true when stream would look complex)
Disadvantage: -
Performance: These are slower than traditional for loops. 
Debugging: Difficult to debug the code.
A disadvantage of a Stream is that filters, mappings, etc., cannot throw checked exceptions. This makes a Stream a poor choice for, say, intermediate I/O operations
https://medium.com/@milan.mimica/slow-like-a-stream-fast-like-a-loop-524f70391182
https://stackoverflow.com/questions/22658322/java-8-performance-of-streams-vs-collections
https://stackoverflow.com/questions/44180101/in-java-what-are-the-advantages-of-streams-over-loops
 
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
	}
}
Stream API
collect()

https://www.baeldung.com/java-8-collectors
To extract out data from stream to a data structure after applying some additional logic (if needed)
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
O/P
2
1
1.5
a b
1
{1a=1, 2a=2}

peek()
Peek is also similar to forEach(). Both take a Consumer but peek() is not a terminal operation unlike forEach(). This returns a stream.
map(),
st.map((t) -> t + "A ").forEach(t -> System.out.print(t));
filter()
st.filter(t -> t % 2==0).forEach(t -> System.out.print( t + " "));
toArray()
Integer[] arr = (Integer[]) st.filter(t -> t % 2==1).toArray(Integer[]::new);
flatMap
Converts Coleaction<Collection> to a flat collection
List<String> list = sstream.flatMap(Collection::stream).collect(Collectors.toList());
findFirst
Optional<T> op = st.findFirst()
Sorted()
Sort by natural order. Throws if not Comparable. ClassCastException
Sorted(Comparator)
Min()
Max()
Distinct()
anyMatch()
allMatch()
noMatch()

reduce(BinaryOperator), reduce(T, BinaryOperator)
Reduces the stream to a single value.
st = Stream.of(1,2,3);
Optional<Integer> op = st.reduce((a,b) -> a+b); // 1 +2+3 = 6
System.out.println(op.get());
st = Stream.of(1,2,3);
Integer res = st.reduce(10, (a,b) -> a+b);
System.out.println(res);
O/P: 
6
16
Optional class
A better way of handling return result of Stream API. It is a container object which has few utility methods to handle null or non-null values. 
get()
Return the value if a value is present in this Optional, returns the value, otherwise throws NoSuchElementException
orElse(T t)
Return the value if present, otherwise return other
orElseGet(Supplier)
isPresent()
filter(Predicate)
ifPresent(Consumenr) –invoke consumer if present otherwise do nothing
map()
public static void main(String[] args) {
	Stream<Integer> st = Stream.of(1,2);
	Optional<Integer> op = st.findFirst();
	op.ifPresent(System.out::print);
}
O/P: 1
 
Parallel Stream
Stream operations are executed parallel.
It uses ForkJoin framework and Thread pool under the hood. 
This should be used in ThreadSafe envirionment.
Should not be used where order matters. 
We can use either parallel() in Stream or parallelStream() in Collection to create parallel stream. Parallel stream can be converted back to sequential().
		Stream<String> st = Stream.of("A", "B");
		st.parallel();
		st.sequential();
		
		List<String> li= null;
		Stream<String> st1 = li.parallelStream();
		
		IntStream in = IntStream.range(1, 5);
		in.parallel();

Stream of Primitives
IntStream ins = IntStream.of(1,2);
IntStream ins2 = IntStream.range(0, 5);
IntStream ins3 = IntStream.iterate(0, t -> t +2);

LongStream longStream = LongStream.rangeClosed(1, 3);

DoubleStream ds = DoubleStream.generate(Math::random);
DoubleStream ds2 = DoubleStream.builder().build();
These streams have mostly similar methods like Stream, however deling with few methods are more convenient like max(), min(). We don’t have to pass a extractor to it.
Infinite Stream
Stream<Double> st = Stream.generate(Math::random);
IntStream ins3 = IntStream.iterate(0, t -> t + 2);
DoubleStream ds1 = DoubleStream.generate(Math::random);

Spliterators
Spliterator = split + iterator
It is used for parallel traversal. It is in parallel stream. We can use Spliterator even if you won’t be using parallel execution.
https://www.geeksforgeeks.org/java-util-interface-spliterator-java8/
Default methods:
We can now specify static/non static default method.
When there is a diamond problem there will be compilation error in impl class. We have to resolve by implementing the method in Impl and call required Interface method.
public class Impl implements Interface1, Interface2{
	@Override
	public void default1() {
		Interface1.super.default1();
	}
}

Static methods in Interface
It is like any other static methods. 

CompletableFuture
https://www.callicoder.com/java-8-completablefuture-tutorial/
How it is different from Future

1)	It cannot be completed manually. 
completableFuture.complete("Future's Result")
2)	Ability to attach callback (then())
3)	Combining multiple Futures
4)	ExceptionHandling

How to create

1)	CompletableFuture<String> cf = new CompletableFuture<>();
I am not sure where it is used
2)	Using Runnable and Supplier.
CompletableFuture.supplyAsync(Supplier s) and runAsync(Runnable r) gets the worker thread from ForkJoinPool.commonPool().
CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "Return value");
CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> System.out.println(""));
3)	With executor: 
By default it obtains thread from common ForkJoinPool.commonPool(). We can also pass our own executor. 

CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->"result", executor);

CompletableFuture.get() 

1)	It’s a blocking call.
2)	We can manually complete by providing result. 
Q: What value we need to provide in case of runAsync.
Return type(and compete(T)) is Void in runAsync(). Any method that expects Void can only accept null. 

Get() vs join()

Callbacks

thenApply(Function f) – It runs in the main thread if the future on which it is called is complete by the time it is called. Else, the same thread that execute the future executes it.
thenApplyAsync(Function f) – Executed by a different thread from ForkJoinPool.commonPool().
thenApplyAsync(Function f, Executor e) – Executed by a different thread from executor.
Other methods
thenAccept(Consumer c) + other 2 overloaded like above
thenRun(Runnable r) + other 2 overloaded like above

Q: Can we attach thenApply() after the task is complete? Yes

Combining futures
thenCompose() – TODO
thenCombine() - TODO
allOf(CompletableFuture<?>... cfs) :-
anyOf(CompletableFuture<?>... cfs)

exception handling

exceptionally(ex->{}) - Calles only when exception occurs.
Handle((res, ex) -> {}) – Always called. Ex will be null when executes successfully and res will be null when there is exception. 
Quetstions: 

1)	thenApply((t) -> {} ) – What is the value of t on runAsync(). – Null

2)	Does the task completes even after main thread is completed: 
Ans: NO – Check completablefuture.CompletableFutureTest.java





 