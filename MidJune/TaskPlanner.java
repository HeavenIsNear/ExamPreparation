package com.company.Exams.MidJune;

import java.util.*;

public class TaskPlanner
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int completed = 0;
		int incomplete = 0;
		int dropped = 0;
		
		String[] array = sc.nextLine().split("\\s+");
		
		int[] tasks = new int[array.length];
		for (int i = 0; i < array.length; i++) {
	        tasks[i] = Integer.parseInt(array[i]);
	    }
		
		String input = sc.nextLine();
		while (!"End".equals(input)) {
		    String[] actions = input.split("\\s+");
		    String command = actions[0];
		    
		    if ("Complete".equals(command)) {
		        int index = Integer.parseInt(actions[1]);
		        completeByIndex(tasks, index);
		    } else if ("Change".equals(command)) {
		        int index = Integer.parseInt(actions[1]);
		        int time = Integer.parseInt(actions[2]);
		        changeTimeByIndex(tasks, index, time);
		    } else if ("Drop".equals(command)) {
		        int index = Integer.parseInt(actions[1]);
		        dropByIndex(tasks, index);
		    } else if ("Count".equals(command)) {
		        String description = actions[1];
		        switch (description) {
		            case "Completed":
		                completed = countCompleted(tasks);
		                System.out.println(completed);
		                break;
		                case "Incomplete":
		                    incomplete = countIncompleted(tasks);
		                    System.out.println(incomplete);
		                    break;
		                    case "Dropped":
		                        dropped = countDropped(tasks);
		                        System.out.println(dropped);
		                        break;
		        }
		    }
		   
		    input = sc.nextLine();
		}
	    printIncomplete(tasks);	
	}
	
	
	public static boolean indexValidator(int[] array, int index) {
	    return (index >= 0 && index < array.length);
	}
	
	public static void completeByIndex(int[] array, int index) {
	    if (indexValidator(array, index)) {
	        array[index] = 0;
	    }
	}
	
	public static void changeTimeByIndex(int[] array, int index, int time) {
	    if (indexValidator(array, index)) {
	        array[index] = time;
	    }
	}
	
	public static void dropByIndex(int[] array, int index) {
	    if (indexValidator(array, index)) {
	        array[index] = -1;
	    }
	}
	
	public static int countCompleted(int[] array) {
	    int count = 0;
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == 0) {
	            count++;
	        }
	    }
	    return count;
	} 
	
	public static int countIncompleted(int[] array) {
	    int count = 0;
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] > 0) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public static int countDropped(int[] array) {
	    int count = 0;
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == -1) {
	            count++;
	        }
	    }
	    return count;
	}
	
	public static void printIncomplete(int[] array) {
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] > 0) {
	            System.out.print(array[i] + " ");
	        }
	    }
	}
}
