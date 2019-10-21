package test;

public class InlineLambda {

	int aaaa = 20;
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		greeter.greet(new Greetings() {
			
			@Override
			public void greet(String name) {
				System.out.println("Aasd");
			}
		});
		
		Greetings engGreet = (String name) -> System.out.println("Hello "+ name);
		greeter.greet(engGreet);
		
		greeter.greet((String name) -> System.out.println("Hello "+ name));

		//We can omit type. Type inference
		greeter.greet((name) -> System.out.println("Hello "+ name));
		
		//For single parameter we can omit braces
		greeter.greet(name-> System.out.println("Hello "+ name));
	}
	
}


class Greeter
{
	void greet(Greetings greeting)
	{
		greeting.greet("Deva");
	}
}

interface Greetings
{
	void greet(String name);
}