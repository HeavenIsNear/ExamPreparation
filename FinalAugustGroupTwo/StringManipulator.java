package com.company.Exams.FinalAugustGroupTwo;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String input = sc.nextLine();

        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("Change")) {
                String letter = tokens[1];
                String replacement = tokens[2];
                text = text.replaceAll(letter, replacement);
                System.out.println(text);
            } else if (command.equals("Includes")) {
                String str = tokens[1];
                if (text.contains(str)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (command.equals("End")) {
                String str = tokens[1];
                if (text.endsWith(str)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (command.equals("Uppercase")) {
                text = text.toUpperCase();
                System.out.println(text);
            } else if (command.equals("FindIndex")) {
                String letter = tokens[1];
                System.out.println(text.indexOf(letter));
            } else if (command.equals("Cut")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);
                text = text.substring(startIndex, startIndex + length);
                System.out.println(text);
            }

            input = sc.nextLine();
        }
    }
}
