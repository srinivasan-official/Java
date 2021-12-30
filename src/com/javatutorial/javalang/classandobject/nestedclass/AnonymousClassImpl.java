package com.javatutorial.javalang.classandobject.nestedclass;

public class AnonymousClassImpl {

	public static void main(String[] args) {
		InterfaceVersion.execute();
		ClassVersion.execute();
	}

}

class InterfaceVersion {
	private String field1 = "field1";
	
	interface Consume {
		public void execute(String msg);
	}
	
	public static void execute() {
		System.out.println("Interface Version");
		staticMethod();
		new InterfaceVersion().instanceMethod();
	}
	
	public void instanceMethod() {
		String field2 = "field2";
		Consume consume = new Consume() {
			String field3 = "";
			public void execute(String field4) {
				field3 = "hi";
				field3 = "field3";
				System.out.println(field1);
				System.out.println(field2);
				System.out.println(field3);
				System.out.println(field4);
				print();
			}
			public void print() {
				System.out.println("print - field5");
			}
		};
		System.out.println("\nInstance Method Execution starts");
		consume.execute("field4");
		//consume.print(); - The method print() is undefined for the type AnonymousClassImpl.Consume
	}
	
	public static void staticMethod() {
		String field2 = "field2";
		Consume consume = new Consume() {
			String field3 = "";
			public void execute(String field4) {
				field3 = "hi";
				field3 = "field3";
				//System.out.println(field1); - Cannot make a static reference to the non-static field field1
				System.out.println(field2);
				System.out.println(field3);
				System.out.println(field4);
				print();
			}
			public void print() {
				System.out.println("print - field5");
			}
		};
		System.out.println("Static Method Execution starts");
		consume.execute("field4");
		//consume.print(); - The method print() is undefined for the type AnonymousClassImpl.Consume
	}
}

class ClassVersion {
	String field1 = "field1";
	
	class InstanceConsume {
		public void execute(String msg) {
			System.out.println("Instance");
		}
	}
	
	static class StaticConsume {
		public void execute(String msg) {
			System.out.println("Static");
		}
	}
	
	public static void execute() {
		System.out.println("\nClass Version");
		staticMethod();
		new ClassVersion().instanceMethod();
	}
	
	public void instanceMethod() {
		String field2 = "field2";
		InstanceConsume consume = new InstanceConsume() {
			String field3 = "";
			public void execute(String field4) {
				System.out.println("\nInstance Method Execution starts");
				field3 = "hi";
				field3 = "field3";
				System.out.println(field1);
				System.out.println(field2);
				System.out.println(field3);
				System.out.println(field4);
				print();
			}
			public void print() {
				System.out.println("print - field5");
			}
		};
		consume.execute("field4");
		//consume.print(); - The method print() is undefined for the type ClassVersion.InstanceConsume
	}
	
	public static void staticMethod() {
		String field2 = "field2";
		StaticConsume consume = new StaticConsume() {
			String field3 = "";
			public void execute(String field4) {
				System.out.println("\nStatic Method Execution starts");
				field3 = "hi";
				field3 = "field3";
				//System.out.println(field1); - Cannot make a static reference to the non-static field field1
				System.out.println(field2);
				System.out.println(field3);
				System.out.println(field4);
				print();
			}
			public void print() {
				System.out.println("print - field5");
			}
		};
		consume.execute("field4");
		//consume.print(); //- The method print() is undefined for the type ClassVersion.StaticConsume
	}
}
