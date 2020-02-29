package com.company.MidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(", ");
        ArrayList<String> items = new ArrayList<>(Arrays.asList(array));

        String input = sc.nextLine();
        while (!"Craft!".equals(input)) {
            String[] tokens = input.split(Pattern.quote(" - "));
            String command = tokens[0];

            if ("Collect".equals(command)) {
                String item = tokens[1];
                if (!items.contains(item)) {
                    items.add(item);
                }
            } else if ("Drop".equals(command)) {
                String item = tokens[1];
                items.remove(item);
            } else if ("Combine Items".equals(command)) {
                String[] smallTokens = tokens[1].split(":");
                String firstItem = smallTokens[0];
                String secondItem = smallTokens[1];
                if (items.contains(firstItem)) {
                    int index = items.indexOf(firstItem);
                    if (index < items.size() - 1) {
                        items.add(index + 1, secondItem);
                    } else {
                        items.add(secondItem);
                    }
                }
            } else if ("Renew".equals(command)) {
                String item = tokens[1];
                if (items.contains(item)) {
                    items.remove(item);
                    items.add(item);
                }
            }

            input = sc.nextLine();
        }
        String result = String.join(", ", items);
        System.out.println(result);
    }
}
