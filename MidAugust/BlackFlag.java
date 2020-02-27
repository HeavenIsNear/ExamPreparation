package com.company.Exams.MidAugust;

import java.util.*;

public class BlackFlag
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int days = Integer.parseInt(sc.nextLine());
		int dailyPlunder = Integer.parseInt(sc.nextLine());
		double expectedPlunder = Double.parseDouble(sc.nextLine());
		
		double gatheredPlunder = 0;
		
		for (int i = 1; i <= days; i++) {
		    double actualPlunder = dailyPlunder;
		    if (i % 3 == 0) {
		        actualPlunder = dailyPlunder + dailyPlunder * 0.5;
		    } 
		    gatheredPlunder += actualPlunder;
		    
		    if (i % 5 == 0) {
		        gatheredPlunder = gatheredPlunder * 0.7;
		    }
		}
		
		if (gatheredPlunder >= expectedPlunder) {
		    System.out.printf("Ahoy! %.2f plunder gained.", gatheredPlunder);
		} else {
		    double percentage = gatheredPlunder / expectedPlunder * 100;
		    System.out.printf("Collected only %.2f%% of the plunder.", percentage);
		}
	}
}
