package com.javatutorial.javalang.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericBoundImpl {

	public static void main(String[] args) {
		GenericBoundUtil<Integer, List<Integer>> genericBoundUtil = new GenericBoundUtil<>(new ArrayList<>());
		genericBoundUtil.inspect(7);
		genericBoundUtil.inspect(12.1);
	}

}

class GenericBoundUtil<T1, T extends List<T1>> {
	T t;
	
	public GenericBoundUtil(T t) {
		this.t = t;
	}
	
	public <U extends Number> void inspect(U u) {
		String s = (u.intValue()%2 == 0) ? "Even" : "Odd";
		System.out.println("Number: " + u + " is " + s);
	}
}