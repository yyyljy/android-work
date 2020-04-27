package multi.android.datamanagementpro.sqlite.exam;

public class item {
    String name;
    int price;
    int quantity;
    int totPrice;

    public item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totPrice = price*quantity;
    }

    @Override
    public String toString() {
        return name + ", " + price + ", " + totPrice + "원";
    }
}
