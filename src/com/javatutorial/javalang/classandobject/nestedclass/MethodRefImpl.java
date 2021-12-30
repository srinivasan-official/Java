package com.javatutorial.javalang.classandobject.nestedclass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;

public class MethodRefImpl {

	public static void main(String[] args) {
		String[] stringArray = { "Barbara", "James", "Mary", "John",
			    "Patricia", "Robert", "Michael", "Linda", "Dinda", "Panda"};
		Custom[] customs = new Custom[stringArray.length];
		for(int i=0; i<stringArray.length; i++) {
			customs[i] = new Custom(stringArray[i]);
		}
		
		//Reference to a static method
		Arrays.sort(customs, Custom::compare);
		
		//Reference to instance method of particular object
		Custom customObj = new Custom("");
		Arrays.sort(customs, customObj::compareInstance);
		
		/*
		Error - The type Custom does not define compareInstance(T, T) that is applicable here
		Arrays.sort(customs, Custom::compareInstance);
		*/
		
		//Reference to instance method of an arbitrary object of a particular type
		Arrays.sort(customs, Custom::compareToIgnoreCase);
		/*
		Other Examples
		String::compareToIgnoreCase
		String::concat  
		*/
		
		//Reference to a constructor
		Supplier<HashMap<String, String>> mapFactory = HashMap<String, String>::new; 
		HashMap<String, String> map = mapFactory.get();
		map.put("Key", "Value");
		
		for(Custom custom : customs) {
			System.out.println(custom.value);
		}
		System.out.println(map.get("Key"));
	}

}

class Custom {
	String value;
	
	public Custom(String value) {
		this.value = value;
	}
	
	public int compareToIgnoreCase(Custom str) {
		return str.value.length();
	}
	
	public int compareInstance(Custom a, Custom b) {
		return a.value.compareTo(b.value);
	}
	
	public static int compare(Custom a, Custom b) {
		return a.value.compareTo(b.value);
	}
}
