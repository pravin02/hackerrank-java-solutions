package org.pk.hackerrank.string;

public class StringBuilderNull {
	
	public static void main(String... args) {
		StringBuilder sb = new StringBuilder();
		sb.append(null);
		System.out.println("sb.append(null) " +sb.toString());
		
		String s = "welcome";
		s = null + s;
		System.out.println("null + s "+s);
		s = s + null;
		System.out.println("s + null "+s);		
	}
}
