package com.company.Exams.MidNovember;

import java.util.Scanner;

public class WeaponSmith {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sword = sc.nextLine().split("\\|");
        String input = sc.nextLine();

        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String description = tokens[1];

            if ("Move".equals(command)) {
                if ("Left".equals(description)) {
                    int index = Integer.parseInt(tokens[2]);
                    if (index > 0 && index < sword.length) {
                        moveLeft(sword, index);
                    }
                } else if ("Right".equals(description)) {
                    int index = Integer.parseInt(tokens[2]);
                    if (index < sword.length - 1 && index >= 0) {
                        moveRight(sword, index);
                    }
                }
            } else if ("Check".equals(command)) {
                if ("Even".equals(description)) {
                    for (int i = 0; i < sword.length; i++) {
                        if (i % 2 == 0) {
                            if (i == sword.length - 2) {
                                System.out.println(sword[i]);
                            } else {
                                System.out.print(sword[i] + " ");
                            }
                        }
                    }
                } else if ("Odd".equals(description)) {
                    for (int i = 0; i < sword.length; i++) {
                        if (i % 2 != 0) {
                            if (i == sword.length - 1) {
                                System.out.println(sword[i]);
                            } else {
                                System.out.print(sword[i] + " ");
                            }
                        }
                    }
                }
            }

            input = sc.nextLine();
        }
        System.out.print("You crafted ");
        for (int i = 0; i < sword.length; i++) {
            if (i == sword.length - 1) {
                System.out.print(sword[i] + "!");
            } else {
                System.out.print(sword[i]);
            }
        }
    }

    private static void moveRight(String[] text, int index) {
        String temp = text[index + 1];
        text[index + 1] = text[index];
        text[index] = temp;
    }

    private static void moveLeft(String[] text, int index) {
        String temp = text[index - 1];
        text[index - 1] = text[index];
        text[index] = temp;
    }
}
