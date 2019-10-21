package completablefuture.exceptionhandling;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Exceptionally {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			throw new NullPointerException("exception occurred");
		});
		
		CompletableFuture<String> exceptionallyFuture = future.exceptionally((ex) -> {
			ex.printStackTrace();
			return "fallback value";
		});
		
		System.out.println(exceptionallyFuture.get());
		
	}

}
