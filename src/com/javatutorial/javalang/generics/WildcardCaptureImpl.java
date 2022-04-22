package com.javatutorial.javalang.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardCaptureImpl {

	public static void main(String[] args) {
		List<?> wL = Arrays.asList(1, 2, 3, "Str", 3.2);
		WildcardCaptureUtil.setElement(wL);
		Object ele = wL.get(0);	
		System.out.println(ele);
		
		wL = new ArrayList<>();
		wL.add(null);
		//wL.add(0, 3); Error - The method add(int, capture#3-of ?) in the type List<capture#3-of ?> is not applicable for the arguments (int, int)
		//WildcardCaptureUtil.addElement(wL, 5); Error - The method addElement(List<T>, T) in the type WildcardCaptureUtil is not applicable for the arguments (List<capture#4-of ?>, int)
	
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<Double> ld = Arrays.asList(1.1, 2.2, 3.3);
		WildcardCaptureUtil.swap(li, ld);
		
		List<Integer> iList = new ArrayList<>();
		for(int i=1; i<=5; i++) {
			iList.add(i);
		}
		List<? extends Number> nList = iList;
		nList.forEach(num -> System.out.print(((Integer)num).intValue() + " "));
		nList.add(null);
		//nList.add(new Integer(7)); Error
		nList.clear();
		System.out.println();
		nList.forEach(num -> System.out.print(num + " "));
	}

}

class WildcardCaptureUtil {
	public static <T> void setElement(List<T> wl) {
		wl.set(0, wl.get(2));
	}
	
	public static <T> void addElement(List<T> wl, T ele) {
		wl.add(ele);
	}
	
	public static void swap(List<? extends Number> l1, List<? extends Number> l2) {
		Number temp = l1.get(0);
		/*
		Error - The method set(int, capture#5-of ? extends Number) in the type 
		List<capture#5-of ? extends Number> is not applicable for the 
		arguments (int, capture#6-of ? extends Number)
		l1.set(0, l2.get(0));
		*/
		
		/*
		Error - The method set(int, capture#7-of ? extends Number) in the type 
		List<capture#7-of ? extends Number> is not applicable for the 
		arguments (int, Number)
		l2.set(0, temp);
		*/
	}
}