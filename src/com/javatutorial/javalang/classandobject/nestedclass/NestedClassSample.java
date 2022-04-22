package com.javatutorial.javalang.classandobject.nestedclass;

public class NestedClassSample {
	
	public static void main(String[] args) {
		System.out.println("Nested Class Sample:\n");
		OuterClass outerObject = new OuterClass();
		OuterClass.InnerNestedClass innerObject = outerObject.new InnerNestedClass();
		innerObject.accessField();
		
		OuterClass.Consume consume = () -> System.out.println("\nInterface can be accessed in static way even if it is not declared static");
		consume.execute();
		consume.print();
		
		OuterClass.StaticNestedClass staticOuterObject = new OuterClass.StaticNestedClass();
		staticOuterObject.accessField(outerObject);
	}
	
}

class OuterClass {
	private String field1 = "Outer Class Field";
	private static String field2 = "Outer Class Static Field";
	
	//interface can be accessible to static nested class even if it is not declared with static keyword
	@FunctionalInterface
	interface Consume {
		public void execute();
		
		interface Consume1 {
			public static void print() {
				System.out.println("nested interface");
			}
		}
		
		public default void print() {
			//System.out.println(field1); Error - Cannot make a static reference to the non-static field field1
			System.out.println(field2);
			Consume1.print();
			System.out.println();
		}
	}
	
	//Modifiers can be public, private, no modifier and protected for nested classes
	class InnerNestedClass {
		public int j = 3;
		public static final int i = 3;
		//error - public static int j = 3;
		public void accessField() {
			Consume consume = () -> System.out.println("Msg from interface");
			System.out.println("Inner Class Example:");
			System.out.println(field1);
			System.out.println(field2);
			consume.execute();
		}
	}
	
	//Modifiers can be public, private, no modifier and protected for nested classes
	static class StaticNestedClass {
		public int i = 3;
		public static int j = 3;
		public static final int k = 3;
		
		public void accessField(OuterClass outerObject) {
			Consume consume = () -> System.out.println("Msg from interface");
			System.out.println("Static Nested Class Example:");
			//Error - System.out.println(field1);
			System.out.println(outerObject.field1);
			System.out.println(field2);
			consume.execute();
		}
	}
	
	public InnerNestedClass initInnerClass() {
		InnerNestedClass innerNestedClass = this.new InnerNestedClass();
		return innerNestedClass;
	}
	
	public StaticNestedClass initStaticNestedClass() {
		StaticNestedClass staticNestedClass = new StaticNestedClass();
		return staticNestedClass;
	}
}
