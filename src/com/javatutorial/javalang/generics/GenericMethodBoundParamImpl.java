package com.javatutorial.javalang.generics;

public class GenericMethodBoundParamImpl {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(GenericMethodBoundParamUtil.getGreaterEleCount(arr, 7));
	}

}

class GenericMethodBoundParamUtil {
	public static <T extends Comparable<T>> int getGreaterEleCount(T[] arr, T ele) {
		int count = 0;
		for(T t : arr) {
			//if(t>ele) Error - The operator > is undefined for the argument type(s) T, T
			if(t.compareTo(ele)==1) count++;
		}
		return count;
	}
}