package com.company.Exams.FinalDecemberGroupTwo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");

        for (int i = 0; i < counter; i++) {
            String text = sc.nextLine();
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String command = matcher.group("command");
                String message = matcher.group("message");
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < message.length(); j++) {
                    int num = message.charAt(j);
                    sb.append(" ").append(num);
                }
                System.out.printf("%s:%s%n", command, sb.toString());
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
