package completablefuture.completeandget;

import java.util.concurrent.CompletableFuture;

public class RunAsyncCompleteExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		CompletableFuture<Void> run1 = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(5000);
				System.out.println("Finished execution of task");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("finally"); //Note: Even finally does not get executed when we complete manually
			}
		});
		
		MyThread t1 = new MyThread(run1);
		t1.start();
		
		Thread.sleep(2000);
		run1.complete(null);// Note we can pass only null for Void arguments
	}
	

}


class MyThread extends Thread {
	
	CompletableFuture<Void> future;
	MyThread(CompletableFuture<Void> future) {
		this.future = future;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Getting the result of future");
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}