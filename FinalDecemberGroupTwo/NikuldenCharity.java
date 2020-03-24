package com.company.Exams.FinalDecemberGroupTwo;

import java.util.Scanner;

public class NikuldenCharity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        String input = sc.nextLine();

        while(!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("Replace")) {
                String currentChar = tokens[1];
                String newChar = tokens[2];
                message = message.replaceAll(currentChar, newChar);
                System.out.println(message);
            } else if (command.equals("Cut")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                StringBuilder sb = new StringBuilder(message);
                if (indexChecker(startIndex, endIndex, message)) {
                    sb.delete(startIndex, endIndex + 1);
                    message = sb.toString();
                    System.out.println(message);
                } else {
                    System.out.println("Invalid indexes!");
                }
            } else if (command.equals("Make")) {
                String description = tokens[1];
                if (description.equals("Upper")) {
                    message = message.toUpperCase();
                } else if (description.equals("Lower")) {
                    message = message.toLowerCase();
                }
                System.out.println(message);
            } else if (command.equals("Check")) {
                String str = tokens[1];
                if (message.contains(str)) {
                    System.out.printf("Message contains %s%n", str);
                } else {
                    System.out.printf("Message doesn't contain %s%n", str);
                }
            } else if (command.equals("Sum")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                if (indexChecker(startIndex, endIndex, message)) {
                    String str = message.substring(startIndex, endIndex + 1);
                    int sum = 0;
                    for (int i = 0; i < str.length(); i++) {
                        sum += str.charAt(i);
                    }
                    System.out.println(sum);
                } else {
                    System.out.println("Invalid indexes!");
                }
            }

            input = sc.nextLine();
        }
    }

    private static boolean indexChecker(int startIndex, int endIndex, String text) {
        return startIndex >= 0 && endIndex <= text.length();
    }
}
