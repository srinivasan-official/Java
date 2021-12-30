package com.javatutorial.javalang.classandobject.nestedclass;

public class LocalClassSample {

	public static void main(String[] args) {
		InnerLocalClass.m1("Outer Class Method Param Variable Field4");
		new InnerLocalClass().m2("Outer Class Method Param Variable Field4");
	}

}

class InnerLocalClass {
	private String field1 = "Outer Class Field1";
	private static String field2 = "Outer Class Static Field2";
	private static final String field3 = "Outer Class Constant Field3";
	private String shadowField = "Outer Class Shadow Field";
	
	public static void m1(String field4) {
		System.out.println("Static Method Local Class Execution:");
		String field5 = "Outer Class Method Variable field5";
		
		/* Error - The member interface LocalInterface can only be defined inside a top-level class or interface or in a static context
		 * interface LocalInterface {
			
		 * }
		*/
		field2 = "Outer Class Static Field2 - Updated";
		/*
		 * field4 = "";
		 * field5 = "";
		 */
		
		class LocalClass {
			//private static String field6 = ""; - The field field6 cannot be declared static in a non-static inner type, unless initialized with a constant expression
			private static final String field6 = "Inner Local Class Constant Field6";
			
			public LocalClass() {
				
			}
			
			public void print() {
				//System.out.println(field1); - Error Cannot make a static reference to the non-static field field1
				System.out.println(field2);
				System.out.println(field3);
				System.out.println(field4);
				System.out.println(field5);
				System.out.println(field6);
			}
		}
		
		LocalClass localObj = new LocalClass();
		localObj.print();
	}
	
	public void m2(String field4) {
		System.out.println("\nNon-Static Method Local Class Execution:");
		String field5 = "Outer Class Method Variable field5";
		
		/* Error - The member interface LocalInterface can only be defined inside a top-level class or interface or in a static context
		 * interface LocalInterface {
			
		 * }
		*/
		String shadowField = "Method Variable ShadowField";
		field2 = "Outer Class Static Field2 - Updated";
		/*
		 * field4 = "";
		 * field5 = "";
		 */
		class LocalClass {
			//private static String field6 = ""; - The field field6 cannot be declared static in a non-static inner type, unless initialized with a constant expression
			private static final String field6 = "Inner Local Class Constant Field6";
			private static final String shadowField = "Local Variable Shadow Field";
			
			public LocalClass() {
				
			}

			public void print(String shadowField) {
				System.out.println(field1);
				System.out.println(field2);
				System.out.println(field3);
				System.out.println(field4);
				System.out.println(field5);
				System.out.println(field6);
				System.out.println(shadowField);
				System.out.println(this.shadowField);
				System.out.println(InnerLocalClass.this.shadowField);
			}
		}
		
		LocalClass localObj = new LocalClass();
		localObj.print("Local param ShadowField");
	}
}
