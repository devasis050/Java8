package completablefuture.callbackandchaining;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenAcceptSupplyAsync {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello";
		});
		
		CompletableFuture<Void> result = future.thenApply((t) -> t).thenAccept(t-> System.out.println(t));
		result.get();
		future.thenRun(() -> System.out.println("Print some randon stuff")).get();
	}

}
