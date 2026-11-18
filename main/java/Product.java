/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hificorp
 */
public class Product implements Iproduct {
    private final String[] products;
    private final int[][] monthlySales;

    public Product(String[] products, int[][] monthlySales) {
        this.products = products;
        this.monthlySales = monthlySales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] productSales : monthlySales) {
            for (int sales : productSales) {
                total += sales;
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int totalMonths = 0;
        for (int[] productSales : monthlySales) {
            totalMonths += productSales.length;
        }
        return totalMonths == 0 ? 0.0 : (double) GetTotalProductsSold() / totalMonths;
    }

    @Override
    public String GetMostPopularProduct() {
        int highestMonthlySales = -1;
        int highestProductIndex = 0;

        for (int product = 0; product < monthlySales.length; product++) {
            for (int sales : monthlySales[product]) {
                if (sales > highestMonthlySales) {
                    highestMonthlySales = sales;
                    highestProductIndex = product;
                }
            }
        }

        return products[highestProductIndex].replace(" Mattress", "")
                + " (" + highestMonthlySales + ")";
    }
}
