package com.company.Exams.FinalDecember;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int counter = Integer.parseInt(sc.nextLine());
        String regex = ("\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+\\ [A-Za-z]+)#");

        for (int i = 0; i < counter; i++) {
            String input =  sc.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                    String name = matcher.group("name");
                    String title = matcher.group("title");
                    System.out.printf("%s, The %s%n>> Strength: %d%n>> Armour: %d%n", name, title, name.length(), title.length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
