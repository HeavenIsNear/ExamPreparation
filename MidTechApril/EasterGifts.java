package com.company.Exams.MidTechApril;

import java.util.Scanner;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] gifts = sc.nextLine().split("\\s+");

        String input = sc.nextLine();
        while (!"No Money".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String gift = tokens[1];

            if ("OutOfStock".equals(command)) {
                while (findAllGiftsByName(gifts, gift)) {
                    int index = findGiftByName(gifts, gift);
                    if (index >= 0) {
                        gifts[index] = "None";
                    }
                }
            } else if("Required".equals(command)) {
                int index = Integer.parseInt(tokens[2]);
                if (indexValidator(gifts, index)) {
                    gifts[index] = gift;
                }
            } else if ("JustInCase".equals(command)) {
                gifts[gifts.length - 1] = gift;
            }

            input = sc.nextLine();
        }
        for (String gift : gifts) {
            if (!gift.equals("None")) {
                System.out.print(gift + " ");
            }
        }
    }

    private static boolean findAllGiftsByName(String[] gifts, String gift) {
        for (String s : gifts) {
            if (s.equals(gift)) {
                return true;
            }
        }
        return false;
    }

    private static boolean indexValidator(String[] array, int index) {
        return (index >= 0 && index < array.length);
    }

    private static int findGiftByName(String[] array, String gift) {
        for (int i = 0; i < array.length; i ++) {
            if (array[i].equals(gift)) {
                return i;
            }
        }
        return -1;
    }
}
