package com.company.Exams.MidDecember;

import java.util.Collections;
import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] field = sc.nextLine().split("\\|");
        int[] targets = new int[field.length];
        for (int i = 0; i < field.length; i++) {
            targets[i] = Integer.parseInt(field[i]);
        }
        int points = 0;

        String input = sc.nextLine();
        while (!"Game over".equals(input)) {
            String[] tokens = input.split("@");
            String command = tokens[0];

            if (command.contains("Shoot")) {
                int startIndex = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);
                if (startIndex >= 0 && startIndex < targets.length) {
                    if (command.contains("Left")) {
                        while (length > 0) {
                            startIndex--;
                            if (startIndex < 0) {
                                startIndex = targets.length - 1;
                            }
                            length--;
                        }
                        if (targets[startIndex] >= 5) {
                            targets[startIndex] -= 5;
                            points += 5;
                        } else {
                            points += targets[startIndex];
                            targets[startIndex] = 0;
                        }
                    } else if (command.contains("Right")) {
                        while (length > 0) {
                            startIndex++;
                            if (startIndex == targets.length) {
                                startIndex = 0;
                            }
                            length--;
                        }
                        if (targets[startIndex] >= 5) {
                            targets[startIndex] -= 5;
                            points += 5;
                        } else {
                            points += targets[startIndex];
                            targets[startIndex] = 0;
                        }
                    }
                }
            } else if ("Reverse".equals(command)) {
                reverseArray(targets);
            }

            input = sc.nextLine();
        }
        for (int i = 0; i < targets.length; i++) {
            if (i == targets.length - 1) {
                System.out.println(targets[i]);
            } else {
                System.out.print(targets[i] + " - ");
            }
        }
        System.out.println(String.format("Iskren finished the archery tournament with %d points!", points));
    }

    private static void reverseArray(int[] targets) {
        for (int i = 0; i < targets.length / 2; i++) {
            int temp = targets[i];
            targets[i] = targets[targets.length - 1 - i];
            targets[targets.length - 1 -i] = temp;
        }
    }
}
