package completablefuture.completeandget;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class SypplyAsyncCompleteExample {
	
	public static void main(String[] args) throws InterruptedException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				System.out.println("Executing the task");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return "Task value";
		});
		MyThread2 t1 = new MyThread2(future);
		MyThread2 t2 = new MyThread2(future);
		
		t1.start();
		t2.start();
		
		Thread.sleep(2000);
		future.complete("Complete value");
		Thread.sleep(200);
		
		MyThread2 t3 = new MyThread2(future);
		t3.start(); // Any subsequent call will return immediately.
	}
	
	
	

}


class MyThread2 extends Thread {
	CompletableFuture<String> future;
	
	MyThread2(CompletableFuture<String> future) {
		this.future = future; 
	}
	
	@Override
	public void run() {
		System.out.println("Gettin the result in: " + Thread.currentThread().getName());
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
