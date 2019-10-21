package completablefuture.combine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOf {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("run async task"));
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Supply async task");
			return "Hello";
		});
		
		CompletableFuture<Void> allTaskFuture = CompletableFuture.allOf(future1, future2);
		
		allTaskFuture.thenRun(() -> {
			try {
				System.out.println("After all tals complete result:" + future2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}).get();
	}

}
