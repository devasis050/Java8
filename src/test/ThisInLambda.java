package test;

import java.util.PriorityQueue;
import java.util.function.Supplier;

public class ThisInLambda {

	public static void main(String[] args) {
		ThisInLambda tl = new ThisInLambda();
		tl.innerThis();
		tl.lambdaThis();
		
	}
	
	private void lambdaThis()
	{
		Supplier<String> s = () -> {
				System.out.println("Lambda this:"+this);
				return "lambda";
		};
		show(s);
	}
	
	private void innerThis()
	{
		Supplier<String> s = new Supplier<String>() {
			@Override
			public String get() {
				System.out.println("Inner this:"+this);
				return "inn";
			}
			@Override
			public String toString() {
				return "Inner class tostring";
			}
		};
		
		show(s);
	}
	
	@Override
	public String toString() {
		return "This of outer class";
	}
	
	private void show(Supplier<String> p)
	{
		p.get();
	}
}
