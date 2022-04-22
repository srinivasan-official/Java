package com.javatutorial.javalang.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		List<Number> numList = new ArrayList<>();
		//List<Number> numList = intList; Error - Type mismatch: cannot convert from List<Integer> to List<Number>
		
		List<Integer> checkList = Arrays.asList(1, 2, 3, 4);
		//checkList.add(5); Error - Unsupported operation
	}
	
	@SuppressWarnings("unused")
	public void checkForListOfIntegerCompatibility(List<Integer> intList) {
		List<?> parentList = intList;
		List<Integer> intListClone = intList;
		List<? extends Number> numListUpperBound = intList;
		List<? extends Integer> intListUpperBound = intList;
		List<? super Integer> intListLowerBound = intList;
		//List<? super Number> numListLowerBound = intList; Error - Type mismatch: cannot convert from List<Integer> to List<? super Number>
	}
	
	@SuppressWarnings("unused")
	public void checkForListOfNumberCompatibility(List<Number> numList) {
		List<?> parentList = numList;
		List<Number> numListClone = numList;
		List<? extends Number> numListUpperBound = numList;
		List<? super Integer> intListLowerBound = numList;
		List<? super Number> numListLowerBound = numList;
		//List<? extends Integer> intListUpperBound = numList; Error - Type mismatch: cannot convert from List<Number> to List<? extends Integer>
		
	}
	
}
