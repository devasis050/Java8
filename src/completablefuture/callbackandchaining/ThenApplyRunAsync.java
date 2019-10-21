package completablefuture.callbackandchaining;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApplyRunAsync {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Void>  future = CompletableFuture.runAsync(() -> {
			try {
				System.out.println("Run task started");
				System.out.println("Thread in future task:" + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		CompletableFuture<String>  future2 = future.thenApply((t) -> {
			System.out.println("Callback param in runAsync:" + t);
			System.out.println("Thread in thenApply callback:" + Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Then apply completed";
		});
		
		CompletableFuture<String>  future4 = future.thenApplyAsync((t) -> {
			System.out.println("Thread in applyAsync callback:" + Thread.currentThread().getName());
			return "Then applyAsync before future was completed";
		});
		
		
		Thread.sleep(2000);
		
		CompletableFuture<String>  future3 = future.thenApply((t) -> {
			System.out.println("Thread in thenApply callback after the task is complete:" + Thread.currentThread().getName());
			return "Then apply after future was completed";
		});
		
	}

}
