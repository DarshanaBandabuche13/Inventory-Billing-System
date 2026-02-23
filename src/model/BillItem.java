package model;

public class BillItem {

    private Item item;
    private int quantity;

    public BillItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    public Item getItem() { return item; }
    public int getQuantity() { return quantity; }
}