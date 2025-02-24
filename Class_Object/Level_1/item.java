package Level_1;

class item {
    // Attributes
    String itemname;
    int itemcode;
    int price;

    // constructors
    public item(String itemname, int itemcode, int price) {
        this.itemname = itemname;
        this.itemcode = itemcode;
        this.price = price;
    }

    // Method to display
    public void display() {
        System.out.println("Name of items:" + itemname);
        System.out.println("Code of the item:" + itemcode);
        System.out.println("Price of the item:" + price);
    }

    // Method for total cost
    public int totalcost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        item item1 = new item("Phone", 190, 3500);
        item1.display();

        int quantity = 2;
        double totalCost = item1.totalcost(quantity);
        System.out.println("Total Cost for " + quantity + " units :" + totalCost);
    }
}
