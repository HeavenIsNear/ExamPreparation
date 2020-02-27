package com.company.Exams.MidJune;

import java.util.*;

public class FroggySquad
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] array = sc.nextLine().split("\\s+");
		ArrayList<String> frogs = new ArrayList<>(Arrays.asList(array));
		
		String input = sc.nextLine();
		
		while (!input.contains("Print")) {
		    String[] tokens = input.split("\\s+");
		    String command = tokens[0];
		    
		    if ("Join".equals(command)) {
		        String name = tokens[1];
		        frogs.add(name);
		    } else if ("Jump".equals(command)) {
		        String name = tokens[1];
		        int index = Integer.parseInt(tokens[2]);
		        if (indexValidator(frogs, index)) {
		            frogs.add(index, name);
		        }
		    } else if ("Dive".equals(command)) {
		        int index = Integer.parseInt(tokens[1]);
		        if (indexValidator(frogs, index)) {
		            frogs.remove(index);
		        }
		    } else if ("First".equals(command)) {
		        int count = Integer.parseInt(tokens[1]);
		        firstCount(frogs, count);
		    } else if ("Last".equals(command)) {
		        int count = Integer.parseInt(tokens[1]);
		        lastCount(frogs, count);
		    }
		    
		    input = sc.nextLine();
		}
		
		if (input.contains("Normal")) {
		    printNormal(frogs);
		} else {
		    printReversed(frogs);
		}
	}
	
	public static boolean indexValidator(ArrayList<String> list, int index) {
	    return (index >= 0 && index < list.size());
	}
	
	public static void lastCount(ArrayList<String> list, int count) {
	    int size = list.size();
	    if (count < size) {
	        for (int i = size - count; i < size; i++) {
	            System.out.print(list.get(i) + " ");
	        } 
	    } else {
	        for (int i = 0; i < size; i++) {
	            System.out.print(list.get(i) + " ");
	        }
	    }
	    System.out.println();
	}
	
	public static void firstCount(ArrayList<String> list, int count) {
	    int size = list.size();
	    if (count < size) {
	        for (int i = 0; i < count; i++) {
	            System.out.print(list.get(i) + " ");
	        }
	    } else {
	        for (int i = 0; i < size; i++) {
	            System.out.print(list.get(i) + " ");
	        }
	    }
	    System.out.println();
	}
	
	public static void printNormal(ArrayList<String> list) {
	    System.out.print("Frogs: ");
	    for (int i = 0; i < list.size(); i++) {
	        System.out.print(list.get(i) + " ");
	    }
	}
	
	public static void printReversed(ArrayList<String> list) {
	    System.out.print("Frogs: ");
	    for (int i = list.size() - 1; i >= 0; i--) {
	        System.out.print(list.get(i) + " ");
	    }
	}
}
