package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CFWithExecutor {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadFactory threadFactory = (runnable) -> {
			Thread t = new Thread() {
				public void run() {
					System.out.println("Worker thread from our thread pool");
					runnable.run();
				}
			};
			return t;
		};
		ExecutorService executor = Executors.newSingleThreadExecutor(threadFactory);
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->"result", executor);
		System.out.println(cf.get());
		executor.shutdown();
	}

}
