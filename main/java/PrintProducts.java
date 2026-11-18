/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hificorp
 */
public class PrintProducts {
    private final Iproduct productReport;

    public PrintProducts(Iproduct productReport) {
        this.productReport = productReport;
    }

    public void printTotalProductSales() {
        System.out.println("Total product sales: " + productReport.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        System.out.printf("Average product sales: %.2f%n", productReport.GetAverageProductSold());
    }

    public void printMostPopularProductSales() {
        System.out.println("Most popular product: " + productReport.GetMostPopularProduct());
    }
}

