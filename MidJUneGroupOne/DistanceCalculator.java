package com.company.Exams.MidJUneGroupOne;

import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int steps = Integer.parseInt(sc.nextLine());
        double lengthOfStep = Double.parseDouble(sc.nextLine());
        int distance = Integer.parseInt(sc.nextLine()) * 100;

        double travelledDistance = 0;

        for (int i = 1; i <= steps; i++) {
            double currentLength = lengthOfStep;
            if (i % 5 == 0) {
                currentLength = lengthOfStep * 0.70;
            }
            travelledDistance += currentLength;
        }

        double percentage = (travelledDistance / distance) * 100;
        System.out.println(String.format("You travelled %.2f%% of the distance!", percentage));
    }
}
