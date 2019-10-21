package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> cf = new CompletableFuture<>();
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "Return value");
		CompletableFuture<Void> cf3 = CompletableFuture.runAsync(() -> System.out.println("asd"));
		System.out.println(cf2.get());
		System.out.println(cf3.get());
		System.out.println("WHat");
		
		
		//Below code is to see if the task gets executed even after the main thread completes
		
		CompletableFuture<Void> cf4 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("Long running task completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println("Main completed");
	}
}

