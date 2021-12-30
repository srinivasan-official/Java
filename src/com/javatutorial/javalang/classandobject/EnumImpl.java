package com.javatutorial.javalang.classandobject;

public class EnumImpl {

	public static void main(String[] args) {
		for(Planet p : Planet.values()) {
			System.out.println(p.ordinal() + " " + p.name() + " " + p.toString());
		}
	}

}
