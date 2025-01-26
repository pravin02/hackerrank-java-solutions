package org.pk.hackerrank;

class Jumps {
	
	public static int calculateJumps(int flagHeight, int jumps) {
		double unit = (double )flagHeight/(double)jumps;
		unit =  Math.round(unit);
		//System.out.println(unit);
		return (int)unit;
	}
	
	public static void main (String[] args) {
		System.out.println(Jumps.calculateJumps(3, 1)); // 3
		System.out.println(Jumps.calculateJumps(3, 3)); // 1		
		System.out.println(Jumps.calculateJumps(3, 2)); // 2
		
		//System.out.println(Math.round((double)3 / (double)2)); // 2
	}
}