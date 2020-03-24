package com.company.Exams.FinalAugust;

import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();
        String input = sc.nextLine();

        while (!"Sign up".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("Case")) {
                String description = tokens[1];
                if (description.equals("upper")) {
                    username = username.toUpperCase();
                } else if (description.equals("lower")) {
                    username = username.toLowerCase();
                }
                System.out.println(username);
            } else if (command.equals("Reverse")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                if (startIndex >= 0 && endIndex < username.length()) {
                    StringBuilder sb = new StringBuilder(username.substring(startIndex, endIndex + 1));
                    sb.reverse();
                    System.out.println(sb.toString());
                }
            } else if (command.equals("Cut")) {
                String substring = tokens[1];
                if (username.contains(substring)) {
                    int index = username.indexOf(substring);
                    StringBuilder sb = new StringBuilder(username);
                    sb.delete(index, index + substring.length());
                    username = sb.toString();
                    System.out.println(username);
                } else {
                    System.out.printf("The word %s doesn't contain %s.%n", username, substring);
                }
            } else if (command.equals("Replace")) {
                String replace = tokens[1];
                username = username.replaceAll(replace, "*");
                System.out.println(username);
            } else if (command.equals("Check")) {
                String contain = tokens[1];
                if (username.contains(contain)) {
                    System.out.println("Valid");
                } else {
                    System.out.printf("Your username must contain %s.%n", contain);
                }
            }

            input = sc.nextLine();
        }
    }
}
