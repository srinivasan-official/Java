package com.javatutorial.javalang.classandobject;

public class ClassDataMembers {

	public static void main(String[] args) {
		//A class can have two types of data members Instance and static
		
		StaticSample.execute();
		new InstanceSample().execute();
		
		System.out.println("\nExcersice:");
		Exercise e1 = new Exercise();
		Exercise e2 = new Exercise();

		e1.x = 1;
		e1.y = 2;
		e2.x = 3;
		e2.y = 4;

		System.out.println("e1.x = " + e1.x);
		System.out.println("e1.y = " + e1.y);
		System.out.println("e2.x = " + e2.x);
		System.out.println("e2.y = " + e2.y);
		System.out.println("Exercise.x = " + Exercise.x);
	}

}

class StaticSample {
	public static int number1;
	public static int number2 = 2;
	public static int number3 = initStatic();
	
	static {
		number1 = 1;
		//this.number1 = 5; - error
	}
	
	public static int initStatic() {
		return 3;
	}
	
	public static void execute() {
		System.out.println("Static Type:\n"+number1 + "\n" + number2 + "\n" + number3);
	}
}

class InstanceSample {
	public int number1;
	public int number2 = 2;
	public int number3 = initInstanceNo();
	
	{
		number1 = 1;
		this.number1 = 1;
	}
	
	public final int initInstanceNo() {
		return 3;
	}
	
	public void execute() {
		System.out.println("Instance Type:\n"+number1 + "\n" + number2 + "\n" + number3);
	}
}

class Exercise {
	public static int x = 1;
	public int y = 2;
}
