package test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public interface Test {

	default void show()
	{
		System.out.println("");
		
		ConcurrentHashMap<String, String> chm = null;
//		chm.put("A", "a");
		
		
		ConcurrentSkipListMap cm = null;
		LinkedHashMap l;
		
		LinkedList s = null;
		
		Executor e;
		
		ThreadPoolExecutor te = new ThreadPoolExecutor(2, 2, 2000, null, null, new RejectedExecutionHandler() {		
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
				
			}
		});
		
		HashMap hm;
		
		ExecutorService es;
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

	}
}
