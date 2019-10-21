package test;

import java.util.function.BiConsumer;

public class ExceptionHandlingByWrapperLambda {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4};
		int key =2;
		process(numbers, 0, getWrapperLambda((t,u)->System.out.println(t%u)));
		
		process(numbers, 0, getWrapper(new BiConsumer<Integer, Integer>() {
			@Override
			public void accept(Integer t, Integer u) {
				System.out.println(t/u);
			}
		}
		));
		String[] arr = {"a","b"};
		processString(arr, 2, getWrapperLambda((str, index) -> System.out.println(str.charAt(index))));
	}

	//We dont want to handle the exception in process() as this exception is specific to this lambda. 
	//e.g. If the lmbda that is passed can cause NullPointer we will have a 
	//long list of catch block in process method. 
	private static <P,Q> BiConsumer<P, Q> getWrapperLambda(BiConsumer<P, Q> consumer) {
		return (i,j) -> {
			try {
				consumer.accept(i,j);
			} catch (Exception e) {
				System.out.println("Exception");
			}
		};
	}
	
	private static BiConsumer<Integer, Integer> getWrapper(BiConsumer<Integer, Integer> consumer)
	{
		return new BiConsumer<Integer, Integer>() {
			@Override
			public void accept(Integer t, Integer u) {
				try{
					consumer.accept(t, u);
				} catch(Exception e)
				{
					System.out.println("Inner exception");
				}
				
			}
		};
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int num : numbers) {
			consumer.accept(num, key);
		}
	}
	
	
	private static void processString(String[] arr, int key, BiConsumer<String, Integer> consumenr)
	{
		for (String string : arr) {
			consumenr.accept(string, key);
		}
	}
	
	
}

