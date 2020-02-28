package com.company.Exams.MidTechMarchGroupOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LastStop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split("\\s+");
        ArrayList<String> paintings = new ArrayList<>(Arrays.asList(array));

        String input = sc.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if ("Change".equals(command)) {
                String paintingNumber = tokens[1];
                String numberToChange = tokens[2];
                if (paintings.contains(paintingNumber)) {
                    changeNumbers(paintings, paintingNumber, numberToChange);
                }
            } else if ("Hide".equals(command)) {
                String paintingNumber = tokens[1];
                paintings.remove(paintingNumber);
            } else if ("Switch".equals(command)) {
                String firstPainting = tokens[1];
                String secondPainting = tokens[2];
                if (paintings.contains(firstPainting) && paintings.contains(secondPainting)) {
                    switchPaintings(paintings, firstPainting, secondPainting);
                }
            } else if ("Insert".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                String paintingNumber = tokens[2];
                if (index + 1 < paintings.size()) {
                    paintings.add(index + 1, paintingNumber);
                }
            } else if ("Reverse".equals(command)) {
                Collections.reverse(paintings);
            }

            input = sc.nextLine();
        }
        String result = String.join(" ", paintings);
        System.out.println(result);
    }

    private static void switchPaintings(ArrayList<String> list, String first, String second) {
        int indexOne = list.indexOf(first);
        int indexTwo = list.indexOf(second);
        list.set(indexOne, second);
        list.set(indexTwo, first);
    }


    private static void changeNumbers(ArrayList<String> list, String firstEle, String secondEle) {
        int firstIndex = list.indexOf(firstEle);
        list.set(firstIndex, secondEle);
    }
}
