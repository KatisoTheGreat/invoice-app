import java.util.Scanner;

public class Invoice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get purchase details
        System.out.print("Enter invoice number: ");
        int invoiceNumber = scanner.nextInt();

        // validate the invoice number
        while (invoiceNumber < 1000 || invoiceNumber > 6000) {
            System.out.println("Invalid invoice number. Please enter a number between 1000 and 6000.");
            System.out.print("Enter invoice number: ");
            invoiceNumber = scanner.nextInt();
        }

        System.out.print("Enter sale amount: ");
        double saleAmount = scanner.nextDouble();

        // validate the sale amount
        while (saleAmount < 0) {
            System.out.println("Invalid sale amount. Please enter a non-negative value.");
            System.out.print("Enter sale amount: ");
            saleAmount = scanner.nextDouble();
        }

        // create the Purchase object
        Purchase purchase = new Purchase(invoiceNumber, saleAmount);

        //print out the purchase details
        System.out.println("\nPurchase Details:");
        System.out.println("Invoice number: " + purchase.getInvoiceNumber());
        System.out.println("Sale amount: R" + purchase.getSaleAmount());
        System.out.println("Sales tax: R" + purchase.getSalesTax());

        scanner.close();
    }
}

class Purchase {
    private int invoiceNumber;
    private double saleAmount;
    private double salesTax;

    public Purchase(int invoiceNumber, double saleAmount) {
        this.invoiceNumber = invoiceNumber;
        this.saleAmount = saleAmount;
        calculateSalesTax();
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public double getSalesTax() {
        return salesTax;
    }

    private void calculateSalesTax() {
        salesTax = saleAmount * 0.1; // assuming a 10% sales tax rate
    }
}
