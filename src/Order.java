import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void viewOrder() {
        System.out.println("Pesanan Anda:");
        double total = 0;
        for (MenuItem item : items) {
            System.out.println(item);
            total += item.getPrice();
        }
        System.out.println("Total: Rp " + total);
        System.out.println("\nDetail Pesanan: ");
        System.out.println("Jumlah Item: " + items.size());
        System.out.println("Waktu Pemrosesan: " + (items.size() * 5) + " menit");
    }
}