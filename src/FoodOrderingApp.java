import java.util.ArrayList;
import java.util.Scanner;

public class FoodOrderingApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<MenuItem> menu = new ArrayList<>();
    private static Order order = new Order();

    public static void main(String[] args) {
        // Daftar menu makanan Indonesia
        menu.add(new MenuItem(1, "Nasi Goreng", 25000));
        menu.add(new MenuItem(2, "Sate Ayam", 20000));
        menu.add(new MenuItem(3, "Gado-Gado", 15000));
        menu.add(new MenuItem(4, "Es Teh Manis", 5000));
        menu.add(new MenuItem(5, "Bakso", 18000));

        System.out.println("Selamat Datang di Aplikasi Pemesanan Makanan!");
        while (true) {
            System.out.println("\nMenu:");
            for (MenuItem item : menu) {
                System.out.println(item);
            }

            System.out.println("\nPilihan:");
            System.out.println("1. Pesan Makanan");
            System.out.println("2. Kelola Menu (Admin)");
            System.out.println("0. Keluar");
            System.out.println("Masukan ID pilihan anda: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                pesanan();
            } else if (choice == 2) {
                Admin.kelolaMenu(menu);
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        System.out.println("Terima kasih telah menggunakan aplikasi!");
    }

    // Fitur untuk melakukan pemesanan
    private static void pesanan() {
        while (true) {
            System.out.println("\nMenu:");
            for (MenuItem item : menu) {
                System.out.println(item);
            }

            System.out.println("\nMasukkan ID menu untuk ditambahkan ke pesanan Anda (0 untuk selesai):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            boolean found = false;
            for (MenuItem item : menu) {
                if (item.getId() == choice) {
                    order.addItem(item);
                    System.out.println(item.getName() + " berhasil ditambahkan ke pesanan.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("ID menu tidak valid. Silakan coba lagi.");
            }
        }

        System.out.println("\nMenyelesaikan pesanan Anda...");
        order.viewOrder();
    }
}
