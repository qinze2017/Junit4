package com.ze.junit4;

// Not good methods for the test
public class T {
	
	public int add(int x, int y) {
		return x + y ;
	}
	
	public String concat(String a, String b) {
		return a + ' ' + b;
	}
	
	public int divide(int x, int y) {
		return x/y;
	}
	
	public static void main(String[] args) {
		
		int z = new T().add(3, 5);
		System.out.println(z);
		
		String s = new T().concat("abc", "def");
		System.out.println(s);
	}
}
