package Level_1;

class MobilePhone {

    // Attributes
    String brand;
    String model;
    int price;

    // constructor
    public MobilePhone(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display
    public void display() {
        System.out.println("Brand is:" + brand);
        System.out.println("Model is:" + model);
        System.out.println("Price is:" + price);
    }

    public static void main(String[] args) {
        MobilePhone item_one = new MobilePhone("Samsung", "S23", 50000);
        item_one.display();
    }
}
