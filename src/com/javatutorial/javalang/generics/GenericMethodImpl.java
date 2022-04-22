package com.javatutorial.javalang.generics;

public class GenericMethodImpl {

	public static void main(String[] args) {
		Pair<String, String> strP1 = new Pair<>("1", "Hello");
		Pair<String, String> strP2 = new Pair<>("2", "World");
		System.out.println("String Pair Compare : " + GenericMethodUtil.<String, String>compare(strP1, strP2));
		System.out.println("String Pair Compare : " + GenericMethodUtil.compare(strP1, strP2));
		
		Pair<Integer, String> intP1 = new Pair<>(1, "Hello");
		Pair<Integer, String> intP2 = new Pair<>(1, "Hello");
		System.out.println("Integer Pair Compare : " + GenericMethodUtil.compare(intP1, intP2));
	}

}

class GenericMethodUtil {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
}

class Pair<K, V> {
	K key;
	V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void setKey(K key) { this.key = key; }
	public void setValue(V value) { this.value = value; }
	public K getKey() { return key; }
	public V getValue() { return value; }
	
	public boolean compare(Pair<K, V> p2) {
		return GenericMethodUtil.compare(this, p2);
	}
}