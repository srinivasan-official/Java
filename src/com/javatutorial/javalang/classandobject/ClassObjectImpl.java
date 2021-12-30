package com.javatutorial.javalang.classandobject;

public class ClassObjectImpl {
	public static void main(String[] args) {
		//Sample Object that holds the real data of SampleClass structure 
		SampleClass sampleObj1 = new SampleClass("Sample Object 1");
		SampleClass sampleObj2 = new SampleClass("Sample Object 2");
		//Performing operations
		sampleObj1.sampleMethod();
		sampleObj2.sampleMethod();
	}
}

/**
 * Defines a Structure of Data(Fields) Stored in memory and Operations(Member Functions)
 * to perform on those data
 * 
 * A class can have only public or no-modifier
*/
class SampleClass {
	//Structure of Data, also called as Fields or States or Data Members
	String value;
	
	//Constructor - used by new operator for creating memory on heap
	public SampleClass(String value) {
		this.value = value;
	}
	
	//Operations can be performed on those data, also called as Member Functions
	public void sampleMethod() {
		System.out.println(value);
	}
}