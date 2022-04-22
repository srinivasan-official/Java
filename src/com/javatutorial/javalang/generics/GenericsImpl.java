package com.javatutorial.javalang.generics;

public class GenericsImpl {

	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<>();
		integerBox.set(7);
		Box<String> stringBox = new Box<>();
		stringBox.set("Hello");
		
		OrderedPair<String, String> orderedPair = new OrderedPair<>("Key", "Value");
		System.out.println(orderedPair.getKey() + ":" + orderedPair.getValue());
		
		OrderedPair<String, Box<Integer>> orderedIntegerPair = new OrderedPair<>("IntBoxKey", integerBox);
		System.out.println(orderedIntegerPair.getKey() + ":" + orderedIntegerPair.getValue().get());
		
		OrderedPair<String, Box<String>> orderedStringPair = new OrderedPair<>("StrBoxKey", stringBox);
		System.out.println(orderedStringPair.getKey() + ":" + orderedStringPair.getValue().get());
		
		PayloadList<Integer, String> list = new PayloadList<Integer, String>();
		list.setPayLoad(1, "Hello");
		
		Box<Integer> intBox = new Box<>();
		Box raw = intBox;
		Box rawBox = new Box();
		Box<String> box = rawBox;
		rawBox.set("str");
	}

}

class Box<T> {
	private T obj;
	
	public void set(T obj) {
		this.obj = obj;
	}
	
	public T get() {
		return obj;
	}
}

// class OrderedPair<K, K> - Duplicate type parameter K
class OrderedPair<K, V> {
	private K key;
	private V value;
	
	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
}

class PayloadList<T1, T2> {
	private T1 e;
	private T2 p;
	public void setPayLoad(T1 ele, T2 val) {
		this.e = ele;
		this.p = val;
	}
	public T2 getPayLoad() { return p; }
	public T1 getE() { return e; }
}
