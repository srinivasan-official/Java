package com.javatutorial.javalang.classandobject.nestedclass;

import java.util.Iterator;

public class InnerClassSample {

	public static void main(String[] args) {
		DataStructure ds = new DataStructure();
		ds.printEven();
	}

}

class DataStructure {
	private static final int SIZE = 15;
	private int[] arr = new int[SIZE];
	
	public DataStructure() {
		for(int i=0; i<SIZE; i++) {
			arr[i] = i;
		}
	}
	
	public void printEven() {
		DSIterator iterator = this.new EvenIterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
	
	interface DSIterator extends Iterator<Integer> {}
	
	private class EvenIterator implements DSIterator {
		int index = 0;

		@Override
		public boolean hasNext() {
			return index<SIZE;
		}

		@Override
		public Integer next() {
			Integer num = Integer.valueOf(arr[index]);
			index+=2;
			return num;
		}
	}
}