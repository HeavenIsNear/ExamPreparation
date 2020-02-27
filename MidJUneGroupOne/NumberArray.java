package com.company.Exams.MidJUneGroupOne;

import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split("\\s+");
        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        String input = sc.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            if ("Switch".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                if (indexValidator(numbers, index)) {
                    numbers[index] *= -1;
                }
            } else if ("Change".equals(command)) {
                int index = Integer.parseInt(tokens[1]);
                int replacement = Integer.parseInt(tokens[2]);
                if (indexValidator(numbers, index)) {
                    numbers[index] = replacement;
                }
            } else if ("Sum".equals(command)) {
                String description = tokens[1];
                if ("Negative".equals(description)) {
                    System.out.println(sumNegatives(numbers));
                } else if ("Positive".equals(description)) {
                    System.out.println(sumPositives(numbers));
                } else if ("All".equals(description)) {
                    System.out.println(sumAll(numbers));
                }
            }

            input = sc.nextLine();
        }
        for (int number : numbers) {
            if (number >= 0) {
                System.out.print(number + " ");
            }
        }
    }

    private static int sumAll(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int sumPositives(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number >= 0) {
                sum += number;
            }
        }
        return sum;
    }

    private static int sumNegatives(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number < 0) {
                sum += number;
            }
        }
        return sum;
    }

    private static boolean indexValidator(int[] numbers, int index) {
        return (index >= 0 && index < numbers.length);
    }
}
