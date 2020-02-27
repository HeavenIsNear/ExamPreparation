package com.company.Exams.MidAugust;

import java.util.*;

public class TreasureHunt
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] array = sc.nextLine().split("\\|");
		ArrayList<String> chest = new ArrayList(Arrays.asList(array));
		
		String input = sc.nextLine();
		
		while (!"Yohoho!".equals(input)) {
		    String[] tokens = input.split("\\s+");
		    String command = tokens[0];
		    
		    if ("Loot".equals(command)) {
		        for (int i = 1; i < tokens.length; i++) {
		            boolean isContained = false;
		            for (int j = 0; j < chest.size(); j++) {
		                if (tokens[i].equals(chest.get(j))) {
		                    isContained = true;
		                    break;
		                }
		            }
		            if (!isContained) {
		                chest.add(0, tokens[i]);    
		            }
		        }
		    } else if ("Drop".equals(command)) {
		        int index = Integer.parseInt(tokens[1]);
		        if (index >= 0 && index < chest.size() - 1) {
		            String temp = chest.get(index);
		            chest.add(temp);
		            chest.remove(temp);
		        }
		    } else if ("Steal".equals(command)) {
		        int count = Integer.parseInt(tokens[1]);
		        if (count >= chest.size()) {
		            for (int i = 0; i < chest.size(); i++) {
		                if (i == chest.size() - 1) {
		                    System.out.print(chest.get(i));
		                } else {
		                    System.out.print(chest.get(i) + ", ");
		                }
		            }
		            System.out.println();
		            for (int i = chest.size() - 1; i >= 0; i--) {
		                chest.remove(i);
		            }
		        } else {
		            for (int i = chest.size() - count; i < chest.size(); i++) {
		                if (i == chest.size() - 1) {
		                    System.out.print(chest.get(i));
		                } else {
		                    System.out.print(chest.get(i) + ", ");
		                }
		            }
		            System.out.println();
		            int indexator = chest.size() - 1;
		            for (int i = 0; i < count; i ++) {
		                chest.remove(indexator);
		                indexator--;
		            }
		        }
		    }
		    
		    input = sc.nextLine();
		}
		
		double sum = 0;
		double items = 0;
		if (chest.size() > 0) {
		    for (int i = 0; i < chest.size(); i++) {
		        sum += chest.get(i).length();
		        items += 1;
		    }
		    System.out.printf("Average treasure gain: %.2f pirate credits.", sum / items);
		} else {
		    System.out.print("Failed treasure hunt.");
		}
	}
}
