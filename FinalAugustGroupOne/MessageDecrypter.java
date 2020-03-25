package com.company.Exams.FinalAugustGroupOne;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<first>\\d+)\\]\\|\\[(?<second>\\d+)\\]\\|\\[(?<third>\\d+)\\]\\|$");
        int counter = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < counter; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                StringBuilder sb = new StringBuilder();
                int fir = Integer.parseInt(matcher.group("first"));
                char first = (char)fir;
                int sec = Integer.parseInt(matcher.group("second"));
                char second = (char)sec;
                int thi = Integer.parseInt(matcher.group("third"));
                char third = (char)thi;
                sb.append(first).append(second).append(third);
                System.out.printf("%s: %s%n", tag, sb);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
