package test;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class MethodReference {

	// When the lambda simply calls another method and passes the input
	// parameter it can be replaced with method reference.
	public static void main(String[] args) {
		
		//0 arg
		Thread t = new Thread(()-> print());
		Thread t1 = new Thread(MethodReference::print);// ()-> print() == MethodReference::print
		t1.start();
		
		BiConsumer<String, String> con = (a,b) -> printArg(a,b);
		BiConsumer<String, String> con1 = MethodReference::printArg;
		processCon(MethodReference::printArg);
		
		//Method reference can be used for object creation.
		constructorMethodReference(() -> new MethodReference());
		constructorMethodReference(MethodReference::new);
		Supp sup = MethodReference::new;
		
	}
	
	interface Supp
	{
		MethodReference getMethodReference();
	}
	
	static void constructorMethodReference(Supplier<MethodReference> supplier)
	{
		
	}
	
	static void print()
	{
		System.out.println("Hello");
	}
	
	static void printArg(String a, String b)
	{
		System.out.println(a+b);
	}
	
	static void processCon(BiConsumer<String, String> con)
	{
		con.accept("1", "2");
	}
}

