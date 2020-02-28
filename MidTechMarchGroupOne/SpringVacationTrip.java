package com.company.Exams.MidTechMarchGroupOne;

import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = Integer.parseInt(sc.nextLine());
        double budget = Double.parseDouble(sc.nextLine());
        int people = Integer.parseInt(sc.nextLine());
        double fuelPricePerKilometer = Double.parseDouble(sc.nextLine());
        double foodPricePerPersonPerDay = Double.parseDouble(sc.nextLine());
        double hotelPricePerPersonPerNight = Double.parseDouble(sc.nextLine());
        double expenses = 0;
        boolean isExpenseMoreThanBudget = false;

        expenses += foodPricePerPersonPerDay * days * people;
        if (people > 10) {
            expenses += (hotelPricePerPersonPerNight * people * days) * 0.75;
        } else {
            expenses += hotelPricePerPersonPerNight * people * days;
        }

        for (int i = 1; i <= days; i++) {
            double distanceTravelled = Double.parseDouble(sc.nextLine());
            expenses += distanceTravelled * fuelPricePerKilometer;

            if (i % 3 == 0 || i % 5 == 0) {
                expenses += expenses * 0.40;
            }
            if (i % 7 == 0) {
                expenses -= expenses / people;
            }

            if (expenses > budget) {
                isExpenseMoreThanBudget = true;
                break;
            }
        }

        if (isExpenseMoreThanBudget) {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", expenses - budget);
        } else {
            System.out.println(String.format("You have reached the destination. You have %.2f$ budget left.", budget - expenses));
        }
    }
}
