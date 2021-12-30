package com.javatutorial.javalang.classandobject.nestedclass;

public class ShadowTestImpl {

	public static void main(String[] args) {
		ShadowTest shadowTest = new ShadowTest();
		ShadowTest.Inner inner = shadowTest.new Inner();
		inner.shadow(3);
	}

}

class ShadowTest {
	private int x = 1;
	
	class Inner {
		private int x = 2;
		
		public void shadow(int x) {
			System.out.println(x);
			System.out.println(this.x);
			System.out.println(ShadowTest.this.x);
		}
	}
}
