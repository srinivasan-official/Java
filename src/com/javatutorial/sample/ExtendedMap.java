package com.javatutorial.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ExtendedMap  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		l1.add(20);
		l1.add(25);
		l1.add(40);
		l1.set(1, 10);
		
		l2.add(25);
		l2.add(l1.get(0)+5);
		l2.addAll(0, l1);
		
		Iterator<Integer> itr = l2.iterator();
		int count = 0;
		while(itr.hasNext()) {
			if(l2.contains(25)) {
				count = 1;
				l2.set(0, count);
			} else {
				l2.add(count);
			}
			System.out.println(itr.next());
		}
		System.out.println(l2);
	}

}