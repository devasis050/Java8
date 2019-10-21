package test;

import java.util.function.Consumer;

public class ClosureExample {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		Consumer<Integer> c = i->System.out.println(a+ i);
		//a=13;
		show(c);
		
		Consumer<Integer> c1 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(a+ t);
			}
		};
		
		show(c1);
	}

	private static void show(Consumer<Integer> c) {
		c.accept(1);
		
	}

}
