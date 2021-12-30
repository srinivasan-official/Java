package com.javatutorial.javalang.classandobject.nestedclass;

import java.util.Arrays;
import java.util.function.Consumer;

public class LambdaImpl {
	public static void main(String[] args) {
		new Calculator().execute();
		new LambdaShadowTestImpl().test(1);
	}
}

class Calculator {
	
	@FunctionalInterface
	interface IntegerMath {
		public int calculate(int a, int b);
		
		public boolean equals(Object obj);
		public String toString();
	}
	
	public void execute() {
		IntegerMath add = (a, b) -> a + b;
		IntegerMath sub = (a, b) -> a - b;
		IntegerMath mul = (a, b) -> a * b;
		IntegerMath div = (a, b) -> a / b;
		
		System.out.println("Add(1,2) = " + add.calculate(1, 2));
		System.out.println("Sub(3,4) = " + sub.calculate(3, 4));
		System.out.println("Mul(5,6) = " + mul.calculate(5, 6));
		System.out.println("Div(7,8) = " + div.calculate(7, 8));
	}
}

class LambdaShadowTestImpl {
	private int x = 0;
	
	public void test(int x) {
		int z = 2;
		
		/* Error - Lambda expression's parameter x cannot redeclare another local variable defined in an enclosing scope. 
		  	Consumer<Integer> consumer = (x) -> {
			
			};
		*/
		
		Consumer<Integer> consumer = (y) -> {
			//z = 23; error - Local variable z defined in an enclosing scope must be final or effectively final
			System.out.println(x);
			System.out.println(y);
			System.out.println(z);
			System.out.println(this.x);
		};
		
		consumer.accept(x);
	}
}