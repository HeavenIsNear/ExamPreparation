package com.company.Exams.MidDecember;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split("&");
        ArrayList<String> books = new ArrayList<>(Arrays.asList(array));

        String input = sc.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split(Pattern.quote(" | "));
            String command = tokens[0];

            if (command.equals("Add Book")) {
                String bookName = tokens[1];
                if (!books.contains(bookName)) {
                    books.add(0, bookName);
                }
            } else if (command.equals("Take Book")) {
                String bookName = tokens[1];
                books.remove(bookName);
            } else if (command.equals("Swap Books")) {
                String bookName = tokens[1];
                String swapBook = tokens[2];
                if (books.contains(bookName) && books.contains(swapBook)) {
                    swapPlaces(books, bookName, swapBook);
                }
            } else if (command.equals("Insert Book")) {
                String bookName = tokens[1];
                books.add(bookName);
            } else  if (command.equals("Check Book")){
                int index = Integer.parseInt(tokens[1]);
                if (index >= 0 && index < books.size()) {
                    System.out.println(books.get(index));
                }
            }
            input = sc.nextLine();
        }
        String bookshelf = String.join(", ", books);
        System.out.println(bookshelf);
    }

    private static void swapPlaces(ArrayList<String> books, String first, String second) {
        int indexFirst = books.indexOf(first);
        int indexSecond = books.indexOf(second);
        books.set(indexFirst, second);
        books.set(indexSecond, first);
    }
}
