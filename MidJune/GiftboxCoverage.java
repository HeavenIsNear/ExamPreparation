package com.company.Exams.MidJune;

import java.util.*;

public class GiftboxCoverage
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double side = Double.parseDouble(sc.nextLine());
		int numberOfSheets = Integer.parseInt(sc.nextLine());
		double sheetArea = Double.parseDouble(sc.nextLine());
		
		
		double boxArea = (side * side) * 6;
		double totalSheetsArea = 0;
		for (int i = 1; i <= numberOfSheets ; i++) {
		    if (i % 3 == 0) {
		        totalSheetsArea += sheetArea * 0.25; 
		    } else {
		        totalSheetsArea += sheetArea;
		    }
		}
		
		double percentage = (totalSheetsArea / boxArea) * 100;
		System.out.printf("You can cover %.2f%% of the box.", percentage);
	}
}
