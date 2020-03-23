package com.company.Exams.FinalDecemberGroupOne;

import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String emailWannaBe = sc.nextLine();
        String input = sc.nextLine();
        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("Make")) {
                String description = tokens[1];
                if (description.equals("Upper")) {
                    emailWannaBe = emailWannaBe.toUpperCase();
                } else if (description.equals("Lower")) {
                    emailWannaBe = emailWannaBe.toLowerCase();
                }
                System.out.println(emailWannaBe);
            } else if (command.equals("GetDomain")) {
                int count = Integer.parseInt(tokens[1]);
                int startIndex = Math.max(emailWannaBe.length() - count, 0);
                System.out.println(emailWannaBe.substring(startIndex));
            } else if (command.equals("GetUsername")) {
                int index = emailWannaBe.indexOf('@');
                if (index != -1) {
                    System.out.println(emailWannaBe.substring(0, index));
                } else {
                    System.out.println(String.format("The email %s doesn't contain the @ symbol.", emailWannaBe));
                }
            } else if (command.equals("Replace")) {
                String letter = "" + tokens[1].charAt(0);
                emailWannaBe = emailWannaBe.replaceAll(letter, "-");
                System.out.println(emailWannaBe);
            } else if (command.equals("Encrypt")) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < emailWannaBe.length(); i++) {
                    int number = emailWannaBe.charAt(i);
                    sb.append(number).append(" ");
                }
                System.out.println(sb);
            }

            input = sc.nextLine();
        }
    }
}
