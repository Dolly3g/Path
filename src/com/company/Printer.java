package com.company;

import java.util.*;

public class Printer {
	public static void print(Queue<String> queue){
		for(String ele : queue) {
			System.out.println(ele);
		}
	}	
}