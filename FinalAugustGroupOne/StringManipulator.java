package com.company.Exams.FinalAugustGroupOne;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String manipulateMe = sc.nextLine();
        String input = sc.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Translate":
                    String notNeeded = tokens[1];
                    String replaceWith = tokens[2];
                    manipulateMe = (translateString(manipulateMe, notNeeded, replaceWith));
                    printString(manipulateMe);
                    break;
                case "Includes":
                    String checkIfIncluded = tokens[1];
                    boolean isIncluded = include(manipulateMe, checkIfIncluded);
                    printBooleans(isIncluded);
                    break;
                case "Start":
                    String start = tokens[1];
                    boolean isStartingWith = startWith(manipulateMe, start);
                    printBooleans(isStartingWith);
                    break;
                case "Lowercase":
                    manipulateMe = manipulateMe.toLowerCase();
                    printString(manipulateMe);
                    break;
                case "FindIndex":
                    char findIndex = tokens[1].charAt(0);
                    int index = findChar(manipulateMe, findIndex);
                    System.out.println(index);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    manipulateMe = removeChars(manipulateMe, startIndex, count);
                    printString(manipulateMe);
                    break;
            }

            input = sc.nextLine();
        }
    }

    private static String removeChars(String text, int startIndex, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
        }
        sb.delete(startIndex, startIndex + count);
        return sb.toString();
    }

    private static int findChar(String text, char findMe) {
        int index = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) == (findMe)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static void printString(String text) {
        System.out.println(text);
    }

    private static boolean startWith(String text, String start) {
        return text.startsWith(start);
    }

    private static boolean include(String text, String check) {
        return text.contains(check);
    }

    private static String translateString(String text, String replaced, String replacement) {
         return text.replace(replaced, replacement);
    }

    private static void printBooleans(boolean isItTrue) {
        if (isItTrue) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
