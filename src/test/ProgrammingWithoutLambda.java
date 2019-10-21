package test;

public class ProgrammingWithoutLambda {

	public static void main(String[] args) {
		
		//Traditional anonymous class
		Greeting helloGreeting = new Greeting() {
			
			@Override
			public void greet() {
				System.out.println("Hello");
			}
		};
		helloGreeting.greet();
		
		//Convert the above to lambda
		
		Greeting helloGreetingLambda = () -> System.out.println("Hello lambda");
		helloGreetingLambda.greet();
	}
}


interface Greeting
{
	void greet();
}
