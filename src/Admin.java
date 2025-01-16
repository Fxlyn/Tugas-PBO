import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static Scanner scanner = new Scanner(System.in);

    public static void kelolaMenu(ArrayList<MenuItem> menu) {
        System.out.println("\nMasukkan username & password admin untuk mengelola menu:");
        scanner.nextLine(); // Consume newline
        String password = scanner.nextLine();

        if (password.equals("admin123")) {
            while (true) {
                System.out.println("\nMenu Pengelolaan:");
                System.out.println("1. Tambah Menu");
                System.out.println("2. Hapus Menu");
                System.out.println("3. Update Menu");
                System.out.println("0. Kembali");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    break;
                } else if (choice == 1) {
                    tambahMenu(menu);
                } else if (choice == 2) {
                    hapusMenu(menu);
                } else if (choice == 3) {
                    updateMenu(menu);
                } else {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
        } else {
            System.out.println("Password salah!");
        }
    }

    // Fitur untuk menambahkan menu
    private static void tambahMenu(ArrayList<MenuItem> menu) {
        System.out.println("\nMasukkan ID menu baru:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Masukkan nama menu:");
        String name = scanner.nextLine();
        System.out.println("Masukkan harga menu:");
        double price = scanner.nextDouble();

        menu.add(new MenuItem(id, name, price));
        System.out.println("Menu " + name + " berhasil ditambahkan.");
    }

    // Fitur untuk menghapus menu
    private static void hapusMenu(ArrayList<MenuItem> menu) {
        System.out.println("\nMasukkan ID menu yang ingin dihapus:");
        int id = scanner.nextInt();
        boolean found = false;
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                menu.remove(item);
                System.out.println("Menu " + item.getName() + " berhasil dihapus.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Menu dengan ID " + id + " tidak ditemukan.");
        }
    }

    // Fitur untuk memperbarui menu
    private static void updateMenu(ArrayList<MenuItem> menu) {
        System.out.println("\nMasukkan ID menu yang ingin diperbarui:");
        int id = scanner.nextInt();
        boolean found = false;
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                scanner.nextLine(); // Consume newline
                System.out.println("Masukkan nama menu baru:");
                String newName = scanner.nextLine();
                System.out.println("Masukkan harga menu baru:");
                double newPrice = scanner.nextDouble();
                menu.set(menu.indexOf(item), new MenuItem(id, newName, newPrice));
                System.out.println("Menu berhasil diperbarui.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Menu dengan ID " + id + " tidak ditemukan.");
        }
    }
}
