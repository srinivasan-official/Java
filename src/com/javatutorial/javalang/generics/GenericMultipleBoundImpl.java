package com.javatutorial.javalang.generics;

public class GenericMultipleBoundImpl {

	public static void main(String[] args) {
		D d = new D("Class A", "Interface B", "Interface C");
		E<D> e1 = new E<>(d);
		e1.execute();
		
		F f = new F("Class A", "Interface B", "Interface C");
		E<F> e2 = new E<>(f);
		e2.execute();
	}

}

class A {
	void show1() {
		
	}
}

interface B {
	void show2();
}

interface C {
	void show3();
	/*
	The inherited method A.show1() cannot hide the public abstract method in C
	void show1();
	*/
}

class D extends A implements B, C {
	String value1;
	String value2;
	String value3;
	
	public D(String value1, String value2, String value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
	
	@Override
	public void show1() {
		System.out.println("Show 1 : " + value1);
	}

	@Override
	public void show2() {
		System.out.println("Show 2 : " + value2);
	}

	@Override
	public void show3() {
		System.out.println("Show 3 : " + value3);
	}
}

class F extends D {

	public F(String value1, String value2, String value3) {
		super(value1, value2, value3);
	}
	
}

class E<T extends A & B & C> {
	T t;
	
	public E(T t) {
		this.t = t;
	}
	
	public void execute() {
		t.show1();
		t.show2();
		t.show3();
	}
}
