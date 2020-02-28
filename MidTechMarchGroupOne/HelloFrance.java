package com.company.Exams.MidTechMarchGroupOne;

import java.util.ArrayList;
import java.util.Scanner;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] purchases = sc.nextLine().split("\\|");
        double budget = Double.parseDouble(sc.nextLine());
        double initialBudget = budget;
        ArrayList<Double> boughtItems = new ArrayList<>();

        for (int i = 0; i < purchases.length; i++) {
            String[] item = purchases[i].split("->");
            String type = item[0];
            double price = Double.parseDouble(item[1]);

            if (priceValidator(type, price)) {
                if (budget >= price) {
                    budget -= price;
                    boughtItems.add(price * 1.40);
                }
            }
        }
        double totalSumOfSold = budget;
        for (int i = 0; i < boughtItems.size(); i++) {
            totalSumOfSold += boughtItems.get(i);
            if (i == boughtItems.size() - 1) {
                System.out.println(String.format("%.2f",boughtItems.get(i)));
            } else {
                System.out.print(String.format("%.2f",boughtItems.get(i)) + " ");
            }
        }

        System.out.printf("Profit: %.2f%n", totalSumOfSold - initialBudget);
        if (totalSumOfSold >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }

    private static boolean priceValidator(String type, double price) {
        switch (type) {
            case "Clothes":
                return (price <= 50);
            case "Shoes":
                return (price <= 35);
            case "Accessories":
                return (price <= 20.50);
        }
        return false;
    }
}
