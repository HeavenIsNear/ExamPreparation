package com.company.Exams.MidTechApril;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split("\\s+");
        ArrayList<String> shops = new ArrayList<>(Arrays.asList(array));
        int counter = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < counter; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String command = tokens[0];

            if ("Include".equals(command)) {
                String shopName = tokens[1];
                shops.add(shopName);
            } else if ("Visit".equals(command)) {
                String description = tokens[1];
                int count = Integer.parseInt(tokens[2]);
                if (shops.size() >= count) {
                    if ("first".equals(description)) {
                        removeFirstCountShops(shops, count);
                    } else if ("last".equals(description)) {
                        removeLastCountShops(shops, count);
                    }
                }
            } else if ("Prefer".equals(command)) {
                int firstIndex = Integer.parseInt(tokens[1]);
                int secondIndex = Integer.parseInt(tokens[2]);
                if (indexValidator(shops, firstIndex, secondIndex)) {
                    swapPlaces(shops, firstIndex, secondIndex);
                }
            } else if ("Place".equals(command)) {
                String shopName = tokens[1];
                int index = Integer.parseInt(tokens[2]);
                if (indexValidator(shops, index + 1)) {
                    shops.add(index + 1, shopName);
                }
            }
        }
        System.out.println("Shops left: ");
        String result = String.join(" ", shops);
        System.out.print(result);
    }

    private static boolean indexValidator(ArrayList<String> list, int index) {
        return (index >= 0 && index < list.size());
    }

    private static void swapPlaces(ArrayList<String> list, int firstIndex, int secondIndex) {
        String temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    private static boolean indexValidator(ArrayList<String> list, int firstIndex, int secondIndex) {
        return ((firstIndex >= 0 && firstIndex < list.size()) && (secondIndex >= 0 && secondIndex < list.size()));
    }

    private static void removeLastCountShops(ArrayList<String> list, int count) {
        int indexator = list.size() - 1;
        for (int i = 0; i < count; i++) {
            list.remove(indexator);
            indexator--;
        }
    }

    private static void removeFirstCountShops(ArrayList<String> list, int count) {
        for (int i = 0; i < count; i++) {
            list.remove(0);
        }
    }
}
