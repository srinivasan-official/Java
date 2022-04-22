package com.javatutorial.javalang.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardLowerBoundImpl {

	public static void main(String[] args) {
		WildcardLowerBoundUtil wlbUtil = new WildcardLowerBoundUtil();
		
		List<Object> list1 = new ArrayList<>();
		wlbUtil.addNum(list1);
		
		List<Number> list2 = new ArrayList<>();
		wlbUtil.addNum(list2);
		
		List<Integer> list3 = new ArrayList<>();
		wlbUtil.addNum(list3);
	}

}

class WildcardLowerBoundUtil {
	public void addNum(List<? super Integer> list) {
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		/*
		Error - The method add(capture#2-of ? super Integer) in the type List<capture#2-of ? super Integer> is 
				not applicable for the arguments (String)
		list.add("Str");
		*/
		list.forEach(System.out::println);
	}
}