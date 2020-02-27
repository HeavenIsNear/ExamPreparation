package com.company.Exams.MidDecember;

import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double cost = Double.parseDouble(sc.nextLine());
        int months = Integer.parseInt(sc.nextLine());
        double budget = 0;

        for (int i = 1; i <= months; i++) {
            if (i != 1 && i % 2 != 0) {
                budget -= budget * 0.16;
            }

            if (i % 4 == 0) {
                budget += budget * 0.25;
            }
            budget += cost * 0.25;
        }

        if (budget > cost) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", budget - cost);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", cost - budget);
        }
    }
}
