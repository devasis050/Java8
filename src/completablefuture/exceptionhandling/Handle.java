package completablefuture.exceptionhandling;

import java.util.concurrent.CompletableFuture;

public class Handle {
	
	public static void main(String[] args) {
		
		
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
			throw new NullPointerException();
		});
		
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
			return 2;
		});
		
		
		future1.handle((result, exception) -> {
			System.out.println("result:" + result);
			System.out.println("exception:" + exception);
			return result;
		});
		
		future2.handle((result, exception) -> {
			System.out.println("result:" + result);
			System.out.println("exception:" + exception);
			return result;
		});
		
	}

}
