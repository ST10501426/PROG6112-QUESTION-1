/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cozynights;

/**
 *
 * @author hificorp
 */
import java.util.Scanner;

public class Cozynights {
    public static void main(String[] args) {
        String[] products = {
            "Cozy Nights Monarch Mattress",
            "Restonic Barbados Mattress",
            "Sealy Phuket Mattress"
        };
        String[] months = {"Month 1", "Month 2", "Month 3"};
        int[][] monthlySales = new int[products.length][months.length];
        int[] productTotals = new int[products.length];
        int companyTotal = 0;
        int highestMonthlySales = -1;
        int highestProductIndex = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            for (int product = 0; product < products.length; product++) {
                for (int month = 0; month < months.length; month++) {
                    System.out.print("Enter number of sales for " + months[month] + " for "
                            + products[product] + ": ");
                    monthlySales[product][month] = scanner.nextInt();
                }
            }
        }

        System.out.println("\nProduct Sales Report - 2026");
        System.out.println("********************************");

        for (int product = 0; product < products.length; product++) {
            for (int month = 0; month < months.length; month++) {
                productTotals[product] += monthlySales[product][month];
                if (monthlySales[product][month] > highestMonthlySales) {
                    highestMonthlySales = monthlySales[product][month];
                    highestProductIndex = product;
                }
            }

            companyTotal += productTotals[product];
        }

        double averagePerProduct = (double) companyTotal / (products.length * months.length);
        System.out.println("\nTotal product sales: " + companyTotal);
        System.out.printf("Average product sales: %.2f%n", averagePerProduct);
        System.out.println("Most popular product: "
                + products[highestProductIndex].replace(" Mattress", "")
                + " (" + highestMonthlySales + ")");
    }
}

