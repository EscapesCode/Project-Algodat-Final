import java.util.Scanner;

public class FindMyTravel {
    static Scanner scanner = new Scanner(System.in);
    static LinkedList users = new LinkedList(); 
    static LinkedList tempatWisata = new LinkedList(); 
    static LinkedList schedules = new LinkedList(); // 

    public static void main(String[] args) {
        initDefaultData();
        login();
    }


    static void initDefaultData() {
        users.add(new User("admin", "admin1234", "admin"));
        users.add(new User("user", "user123", "user"));

        tempatWisata.add(new TempatWisata("Gunung Rinjani", 80, 50000));
        tempatWisata.add(new TempatWisata("Pantai Senggigi", 15, 20000));
        tempatWisata.add(new TempatWisata("Loang Baloq", 10, 10000));
        tempatWisata.add(new TempatWisata("Air Terjun Sendang Gile", 25, 30000));
    }

    static void login() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        User user = (User) users.find(username, password);
        if (user != null) {
            if (user.role.equals("admin")) {
                menuAdmin();
            } else {
                menuUser();
            }
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
            login();
        }
    }

    static void menuAdmin() {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Kelola User");
            System.out.println("2. Kelola Tempat Wisata");
            System.out.println("3. Logout");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    kelolaUser();
                    break;
                case 2:
                    kelolaTempatWisata();
                    break;
                case 3:
                    System.out.println("Logout berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void kelolaUser() {
        while (true) {
            System.out.println("\nKelola User:");
            System.out.println("1. Tambah User");
            System.out.println("2. Lihat User");
            System.out.println("3. Cari User");
            System.out.println("4. Hapus User");
            System.out.println("5. Kembali");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    tambahUser();
                    break;
                case 2:
                    tampilkanUser();
                    break;
                case 3:
                    cariUser();
                    break;
                case 4:
                    hapusUser();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    static void tambahUser() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        System.out.print("Masukkan role (admin/user): ");
        String role = scanner.nextLine();

        users.add(new User(username, password, role));
        System.out.println("User berhasil ditambahkan.");
    }


    static void tampilkanUser() {
        System.out.println("\nDaftar User:");
        users.print();
    }

    // Cari User
    static void cariUser() {
        System.out.print("Masukkan username yang dicari: ");
        String keyword = scanner.nextLine();

        users.findAndPrint(keyword);
    }

    // Hapus User
    static void hapusUser() {
        System.out.print("Masukkan username yang ingin dihapus: ");
        String username = scanner.nextLine();

        users.remove(username);
    }

    // Kelola Tempat Wisata
    static void kelolaTempatWisata() {
        while (true) {
            System.out.println("\nKelola Tempat Wisata:");
            System.out.println("1. Tambah Tempat Wisata");
            System.out.println("2. Lihat Tempat Wisata");
            System.out.println("3. Hapus Tempat Wisata");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    tambahTempatWisata();
                    break;
                case 2:
                    tampilkanTempatWisata();
                    break;
                case 3:
                    hapusTempatWisata();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Tambah Tempat Wisata
    static void tambahTempatWisata() {
        System.out.print("Masukkan nama tempat: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan jarak (km): ");
        int jarak = scanner.nextInt();
        System.out.print("Masukkan harga (Rp): ");
        int harga = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        tempatWisata.add(new TempatWisata(nama, jarak, harga));
        System.out.println("Tempat wisata berhasil ditambahkan.");
    }

    // Tampilkan Tempat Wisata
    static void tampilkanTempatWisata() {
        System.out.println("\nDaftar Tempat Wisata:");
        tempatWisata.print();
    }

    // Hapus Tempat Wisata
    static void hapusTempatWisata() {
        System.out.print("Masukkan nama tempat wisata yang ingin dihapus: ");
        String nama = scanner.nextLine();

        tempatWisata.remove(nama);
    }

    // Menu User
    static void menuUser() {
        while (true) {
            System.out.println("\nMenu User:");
            System.out.println("1. Tampilkan Wisata");
            System.out.println("2. Cari Wisata");
            System.out.println("3. Buat Schedule");
            System.out.println("4. List Schedule");
            System.out.println("5. Logout");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    tampilkanTempatWisata();
                    break;
                case 2:
                    cariWisata();
                    break;
                case 3:
                    buatSchedule();
                    break;
                case 4:
                    listSchedule();
                    break;
                case 5:
                    System.out.println("Logout berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // Cari Wisata
    static void cariWisata() {
        System.out.print("Masukkan nama tempat wisata yang dicari: ");
        String keyword = scanner.nextLine();

        tempatWisata.findAndPrint(keyword);
    }

    // Buat Schedule
    static void buatSchedule() {
        System.out.print("Masukkan judul perjalanan: ");
        String judulPerjalanan = scanner.nextLine();
        System.out.print("Masukkan lokasi tujuan: ");
        String lokasiTujuan = scanner.nextLine();

        schedules.add(new Schedule(judulPerjalanan, lokasiTujuan));
        System.out.println("Schedule berhasil dibuat.");
    }

    // List Schedule
    static void listSchedule() {
        System.out.println("\nDaftar Schedule:");
        schedules.print();
    }
}

// Kelas untuk LinkedList
class LinkedList {
    private Node head;

    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Object find(String username, String password) {
        Node current = head;
        while (current != null) {
            if (current.data instanceof User) {
                User user = (User) current.data;
                if (user.username.equals(username) && user.password.equals(password)) {
                    return user;
                }
            }
            current = current.next;
        }
        return null;
    }

    public void remove(String username) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.data instanceof User) {
                User user = (User) current.data;
                if (user.username.equals(username)) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    System.out.println("User berhasil dihapus.");
                    return;
                }
            }
            previous = current;
            current = current.next;
        }
        System.out.println("User tidak ditemukan.");
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void findAndPrint(String keyword) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.data instanceof User) {
                User user = (User) current.data;
                if (user.username.contains(keyword)) {
                    System.out.println(user);
                    found = true;
                }
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    // Node class untuk LinkedList
    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }
}

// Kelas User
class User {
    String username;
    String password;
    String role;

    User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return username + " (" + role + ")";
    }
}

// Kelas TempatWisata
class TempatWisata {
    String nama;
    int jarak;
    int harga;

    TempatWisata(String nama, int jarak, int harga) {
        this.nama = nama;
        this.jarak = jarak;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama + " (Jarak: " + jarak + " km, Harga: Rp" + harga + ")";
    }
}

// Kelas Schedule
class Schedule {
    String judulPerjalanan;
    String lokasiTujuan;

    Schedule(String judulPerjalanan, String lokasiTujuan) {
        this.judulPerjalanan = judulPerjalanan;
        this.lokasiTujuan = lokasiTujuan;
    }

    @Override
    public String toString() {
        return judulPerjalanan + " ke " + lokasiTujuan;
    }
}
