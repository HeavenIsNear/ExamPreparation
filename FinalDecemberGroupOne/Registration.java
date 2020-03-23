package com.company.Exams.FinalDecemberGroupOne;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = Integer.parseInt(sc.nextLine());
        int successfulRegs = 0;

        for (int i = 0; i < counter; i++) {
            String input = sc.nextLine();
            Pattern pattern = Pattern.compile("U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}\\d+)P@\\$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String username = matcher.group("username");
                String password = matcher.group("password");
                successfulRegs++;
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", username, password);
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", successfulRegs);
    }
}
