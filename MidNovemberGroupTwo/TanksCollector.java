package com.company.Exams.MidNovemberGroupTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TanksCollector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(", ");
        ArrayList<String> tankList = new ArrayList<>(Arrays.asList(array));
        tankList.removeIf(s -> s.equals(""));
        int counter = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < counter; i++) {
            String input = sc.nextLine();
            String[] tokens = input.split(", ");
            String command = tokens[0];

            if ("Add".equals(command)) {
                String tankName = tokens[1];
                if (tankList.contains(tankName)) {
                    System.out.println("Tank is already bought");
                } else {
                    tankList.add(tankName);
                    System.out.println("Tank successfully bought");
                }
            } else if ("Remove".equals(command)) {
                String tankName = tokens[1];
                if (tankList.contains(tankName)) {
                    System.out.println("Tank successfully sold");
                    tankList.remove(tankName);
                } else {
                    System.out.println("Tank not found");
                }
            } else if("Remove At".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                if (indexValidator(tankList, index)) {
                    tankList.remove(index);
                    System.out.println("Tank successfully sold");
                } else {
                    System.out.println("Index out of range");
                }
            } else if ("Insert".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                String tankName = tokens[2];
                if (indexValidator(tankList, index)) {
                    if (tankList.contains(tankName)) {
                        System.out.println("Tank is already bought");
                    } else {
                        tankList.add(index, tankName);
                        System.out.println("Tank successfully bought");
                    }
                } else {
                    System.out.println("Index out of range");
                }
            }
        }
        String result = String.join(", ", tankList);
        System.out.println(result);
    }

    public static boolean indexValidator(ArrayList<String> list, int index) {
        return (index >= 0 && index < list.size());
    }
}
