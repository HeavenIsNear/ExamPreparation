package com.company.Exams.FinalDecember;

import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String skill = sc.nextLine();
        String input = sc.nextLine();

        while (!"For Azeroth".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if (command.equals("GladiatorStance")) {
                skill = skill.toUpperCase();
                System.out.println(skill);
            } else if (command.equals("DefensiveStance")) {
                skill = skill.toLowerCase();
                System.out.println(skill);
            } else if (command.equals("Dispel")) {
                int index = Integer.parseInt(tokens[1]);
                String replacement = tokens[2];
                if (index >= 0 && index < skill.length()) {
                    StringBuilder sb = new StringBuilder(skill);
                    sb.setCharAt(index, replacement.charAt(0));
                    skill = sb.toString();
                    System.out.println("Success!");
                } else {
                    System.out.println("Dispel too weak.");
                }
            } else if (command.equals("Target")) {
                String description = tokens[1];
                String substring = tokens[2];
                if (description.equals("Change")) {
                    String replacement = tokens[3];
                    if (skill.contains(substring)) {
                        skill = skill.replace(substring, replacement);
                    }
                } else if (description.equals("Remove")){
                    if (skill.contains(substring)) {
                        StringBuilder sb = new StringBuilder(skill);
                        int startIndex = skill.indexOf(substring);
                        int endIndex = startIndex + substring.length();
                        sb.delete(startIndex, endIndex);
                        skill = sb.toString();
                    }
                }
                System.out.println(skill);
            } else {
                System.out.println("Command doesn't exist!");
            }


            input = sc.nextLine();
        }
    }
}
