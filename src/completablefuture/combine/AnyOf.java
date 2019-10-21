package completablefuture.combine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AnyOf {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
			System.out.println("run async task");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Supply async task");
			return "Hello";
		});
		
		CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2);
		
		anyOfFuture.thenAccept((t) -> {
			System.out.println("AnyOf task thenAccept callback:" + t);
		}).get();
		
		Thread.sleep(2000);
		
	}

}
