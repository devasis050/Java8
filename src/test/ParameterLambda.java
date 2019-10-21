package test;

public class ParameterLambda {

	public static void main(String[] args) {
		
		//Traditional
		
		Calculator addCalculator = new Calculator() {
			
			@Override
			public int calculate(int a, int b) {
				return a+b;
			}
		};
		System.out.println(addCalculator.calculate(2, 3));
		
		//Return is valid if we are using braces. Compiler determines it by itself
		Calculator addLambda = (int a, int b) -> {return a + b;};
		
		System.out.println(addLambda.calculate(2, 5));
		
		//Example of type inference. Return is not valid if we are not using braces.
		Calculator addLambda1 = (a,b) -> a+b;
		
		System.out.println(addLambda1.calculate(1, 2));
		
	}
}

interface Calculator
{
	int calculate(int a, int b);
}
