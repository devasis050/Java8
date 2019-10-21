package completablefuture.callbackandchaining;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApplySupplyAsync {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Starting task");
			System.out.println("Thread in task:" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello";
		});
		
		CompletableFuture<Integer> callbackTask = future.thenApply((t) -> {
			System.out.println("Thread in callback:" + Thread.currentThread().getName());
			return t.length();
		});
		
		System.out.println(callbackTask.get());
		
	}

}
