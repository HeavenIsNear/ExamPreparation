package com.company.Exams.FinalJuly;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("([#%$&*])(?<racer>[A-Za-z]+)\\1=(?<codeLength>\\d+)!!(?<geohashCode>.+)$");
        boolean isFound = false;
        String input = sc.nextLine();

        while (true) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String racer = matcher.group("racer");
                int length = Integer.parseInt(matcher.group("codeLength"));
                String geohashCode = matcher.group("geohashCode");

                if (geohashCode.length() == length) {
                    String coordinates = decryptCoordinates(geohashCode, length);
                    System.out.printf("Coordinates found! %s -> %s", racer, coordinates);
                    break;
                }
            }

            System.out.println("Nothing found!");

            input = sc.nextLine();
        }
    }

    private static String decryptCoordinates(String text, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char letter = (char)(text.charAt(i) + length);
            sb.append(letter);
        }
        return sb.toString();
    }
}
