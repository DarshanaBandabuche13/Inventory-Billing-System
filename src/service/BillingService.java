package src.service;

import model.BillItem;
import java.util.List;

public class BillingService {

    public void generateBill(List<BillItem> billList) {

        if (billList.isEmpty()) {
            System.out.println("No items in bill.");
            return;
        }

        double total = 0;

        System.out.println("\n--------- BILL ---------");
        System.out.printf("%-10s %-5s %-10s\n", "Item", "Qty", "Amount");
        System.out.println("-------------------------");

        for (BillItem bill : billList) {
            double itemTotal = bill.getTotalPrice();
            total += itemTotal;

            System.out.printf("%-10s %-5d ₹%-10.2f\n",
                    bill.getItem().getName(),
                    bill.getQuantity(),
                    itemTotal);
        }

        System.out.println("-------------------------");
        System.out.printf("Total: ₹%.2f\n", total);
        System.out.println("-------------------------");
    }
}