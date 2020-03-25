package com.company.Exams.FinalAugustGroupTwo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("([*@])(?<tag>[A-Z][a-z]{2,})\\1: (?<message>\\[[A-Za-z]\\]\\|\\[[A-Za-z]\\]\\|\\[[A-Za-z]\\]\\|)$");

        for (int i = 0; i < counter; i++) {
            String text = sc.nextLine();
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String message = matcher.group("message").replaceAll("[\\[\\]\\|]", "");
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < message.length(); j++) {
                    int num = message.charAt(j);
                    result.append(num).append(" ");
                }
                System.out.printf("%s: %s%n", tag, result.toString());
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
