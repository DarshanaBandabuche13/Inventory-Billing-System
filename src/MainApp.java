
import service.*;
import model.*;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryService inventoryService = new InventoryService();
        BillingService billingService = new BillingService();
        List<BillItem> billList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n1. View Inventory");
            System.out.println("2. Add Item to Bill");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter number.");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    inventoryService.displayItems();
                    break;

                case 2:
                    inventoryService.displayItems();
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();

                    Item item = inventoryService.getItemById(id);

                    if (item != null) {
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        if (qty <= 0 || qty > item.getStock()) {
                            System.out.println("Invalid quantity.");
                        } else {
                            billList.add(new BillItem(item, qty));
                            inventoryService.updateStock(item, qty);
                            System.out.println("Item added to bill.");
                        }
                    } else {
                        System.out.println("Invalid Item ID.");
                    }
                    break;

                case 3:
                    billingService.generateBill(billList);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}