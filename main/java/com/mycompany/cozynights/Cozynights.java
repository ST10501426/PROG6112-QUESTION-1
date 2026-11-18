/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cozynights;

/**
 * Displays a product sales report and identifies the highest monthly sales.
 *
 * @author hificorp
 */
import java.util.Scanner;

public class Cozynights {
    public static void main(String[] args) {
        // Names of the products whose sales will be recorded.
        String[] products = {
            "Cozy Nights Monarch Mattress",
            "Restonic Barbados Mattress",
            "Sealy Phuket Mattress"
        };

        // Labels for the three months of sales data.
        String[] months = {"Month 1", "Month 2", "Month 3"};

        // Stores sales for each product for each month.
        int[][] monthlySales = new int[products.length][months.length];

        // Stores the total sales for each individual product.
        int[] productTotals = new int[products.length];

        // Stores the total sales for the company.
        int companyTotal = 0;

        // Tracks the highest monthly sales value found.
        int highestMonthlySales = -1;

        // Tracks the index of the product with the highest monthly sales.
        int highestProductIndex = 0;

        // Prompt the user to enter sales for every product and month.
        try (Scanner scanner = new Scanner(System.in)) {
            for (int product = 0; product < products.length; product++) {
                for (int month = 0; month < months.length; month++) {
                    System.out.print("Enter number of sales for " + months[month] + " for "
                            + products[product] + ": ");
                    monthlySales[product][month] = scanner.nextInt();
                }
            }
        }

        // Print the report heading.
        System.out.println("\nProduct Sales Report - 2026");
        System.out.println("********************************");

        // Calculate product totals and find the product with the highest monthly sales.
        for (int product = 0; product < products.length; product++) {
            for (int month = 0; month < months.length; month++) {
                // Add this month's sales to the product's total.
                productTotals[product] += monthlySales[product][month];

                // Update the highest monthly sales and product index if this value is larger.
                if (monthlySales[product][month] > highestMonthlySales) {
                    highestMonthlySales = monthlySales[product][month];
                    highestProductIndex = product;
                }
            }

            // Add this product's total to the company's overall sales total.
            companyTotal += productTotals[product];
        }

        // Calculate average sales across all products and months.
        double averagePerProduct = (double) companyTotal / (products.length * months.length);

        // Display the final sales totals and most popular product.
        System.out.println("\nTotal product sales: " + companyTotal);
        System.out.printf("Average product sales: %.2f%n", averagePerProduct);
        System.out.println("Most popular product: "
                + products[highestProductIndex].replace(" Mattress", "")
                + " (" + highestMonthlySales + ")");
    }
}
