package com.company.Exams.MidTechApril;

import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double budget = Double.parseDouble(sc.nextLine());
        double priceForOneKiloFloor = Double.parseDouble(sc.nextLine());

        double priceForOnePackEggs = priceForOneKiloFloor * 0.75;
        double priceForMilk = (priceForOneKiloFloor * 1.25) * 0.25;

        double priceForOneCozonac = priceForOneKiloFloor + priceForMilk + priceForOnePackEggs;
        int cozonacs = 0;
        int coloredEggs = 0;

        while (budget >= priceForOneCozonac) {
            cozonacs++;
            coloredEggs += 3;

            if (cozonacs % 3 == 0) {
                coloredEggs -= cozonacs - 2;
            }
            budget -= priceForOneCozonac;
        }

        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", cozonacs, coloredEggs,budget);
    }
}
