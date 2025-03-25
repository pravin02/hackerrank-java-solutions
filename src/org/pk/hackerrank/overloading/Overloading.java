package org.pk.hackerrank.overloading;

public class Overloading {
	
	public void printMessage(String string) {
		System.out.println(string);
	}
	
	public void printMessage(Object obj) {
		System.out.println(obj);
	}

	public static void main(String... args) {
		Overloading ov = new Overloading();
		ov.printMessage("Welcome");
		ov.printMessage(1);
	}
}
