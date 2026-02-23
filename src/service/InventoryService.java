package src.service;

import model.Item;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {

    private List<Item> itemList = new ArrayList<>();

    public InventoryService() {
        itemList.add(new Item(1, "Laptop", 50000, 10));
        itemList.add(new Item(2, "Mouse", 500, 50));
        itemList.add(new Item(3, "Keyboard", 1500, 30));
    }

    public void displayItems() {
        System.out.println("\n---- Inventory ----");
        for (Item item : itemList) {
            System.out.println(item.getId() + " - " +
                    item.getName() +
                    " | Price: ₹" + item.getPrice() +
                    " | Stock: " + item.getStock());
        }
    }

    public Item getItemById(int id) {
        for (Item item : itemList) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public void updateStock(Item item, int quantitySold) {
        item.setStock(item.getStock() - quantitySold);
    }
}