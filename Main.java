import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    static Graph wisata = new Graph();
    static LinkedListSchedule daftarJadwal = new LinkedListSchedule();
    private static UserLinkedList userList = new UserLinkedList();

    static void sortSubMenu() {
        while (true) {
            System.out.println("\nPilih opsi sortir wisata:");
            System.out.println("1. Sortir berdasarkan harga");
            System.out.println("2. Sortir berdasarkan rating");
            System.out.println("3. Kembali ke menu utama");
            System.out.print("Pilih opsi: ");
            int sortOption = scanner.nextInt();
            scanner.nextLine();

            switch (sortOption) {
                case 1:
                    wisata.sortByHarga();
                    scanner.nextLine();
                    clearConsole();
                    // Menyortir berdasarkan harga
                    break;
                case 2:
                    wisata.sortByRating();
                    scanner.nextLine();
                    clearConsole();
                    break;
                case 3:
                    userMenu(); // Kembali ke menu utama
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void main(String[] args) {

        wisata.addWisata("Gunung Rinjani", 25000, 4.5);
        wisata.addWisata("Loang Baloq", 45000, 4.2);
        wisata.addWisata("Mataram Mall", 30000, 4.3);
        wisata.addWisata("Pantai Senggigi", 25000, 4.4);
        wisata.addWisata("Sembalun", 30000, 4.2);
        wisata.addWisata("Sesaot", 35000, 4.1);
        wisata.addWisata("Desa Banyumulek", 25000, 4.3);
        wisata.addWisata("Bandara Internasional Lombok", 30000, 4.4);
        wisata.addWisata("Pantai Kuta Lombok", 35000, 4.2);
        wisata.addWisata("Gili Trawangan", 90000, 4.5);
        wisata.addWisata("Gili Air", 80000, 4.4);
        wisata.addWisata("Desa Sade", 50000, 4.3);
        wisata.addWisata("Taman Narmada", 60000, 4.2);
        wisata.addWisata("Bukit Merese", 70000, 4.1);
        wisata.addWisata("Tanjung Aan", 80000, 4.0);
        wisata.addWisata("Gili Meno", 90000, 4.5);
        wisata.addWisata("Pantai Mawun", 100000, 4.4);
        wisata.addWisata("Pantai Pink", 110000, 4.7);
        wisata.addWisata("Air Terjun Sendang Gile", 120000, 4.6);
        wisata.addWisata("Pantai Selong Belanak", 130000, 4.9);

        // Menambahkan edge untuk menghubungkan tempat wisata beserta jaraknya
        wisata.addEdge("Gunung Rinjani", "Sembalun", 22);
        wisata.addEdge("Sembalun", "Gunung Rinjani", 22);
        wisata.addEdge("Sembalun", "Air Terjun Sendang Gile", 15);
        wisata.addEdge("Air Terjun Sendang Gile", "Sembalun", 15);
        wisata.addEdge("Air Terjun Sendang Gile", "Gili Trawangan", 52);
        wisata.addEdge("Gili Trawangan", "Air Terjun Sendang Gile", 52);
        wisata.addEdge("Gili Trawangan", "Gili Meno", 2);
        wisata.addEdge("Gili Meno", "Gili Trawangan", 2);
        wisata.addEdge("Gili Meno", "Gili Air", 2);
        wisata.addEdge("Gili Air", "Gili Meno", 2);
        wisata.addEdge("Gili Air", "Pantai Senggigi", 33);
        wisata.addEdge("Pantai Senggigi", "Gili Air", 33);
        wisata.addEdge("Pantai Senggigi", "Loang Baloq", 10);
        wisata.addEdge("Loang Baloq", "Pantai Senggigi", 10);
        wisata.addEdge("Loang Baloq", "Mataram Mall", 7);
        wisata.addEdge("Mataram Mall", "Loang Baloq", 7);
        wisata.addEdge("Mataram Mall", "Desa Banyumulek", 10);
        wisata.addEdge("Desa Banyumulek", "Mataram Mall", 10);
        wisata.addEdge("Desa Banyumulek", "Taman Narmada", 15);
        wisata.addEdge("Taman Narmada", "Desa Banyumulek", 15);
        wisata.addEdge("Taman Narmada", "Sesaot", 8);
        wisata.addEdge("Sesaot", "Taman Narmada", 8);
        wisata.addEdge("Sesaot", "Bandara Internasional Lombok", 30);
        wisata.addEdge("Bandara Internasional Lombok", "Sesaot", 30);
        wisata.addEdge("Sesaot", "Sembalun", 30);
        wisata.addEdge("Sembalun", "Sesaot", 30);
        wisata.addEdge("Bandara Internasional Lombok", "Desa Sade", 6);
        wisata.addEdge("Desa Sade", "Bandara Internasional Lombok", 6);
        wisata.addEdge("Desa Sade", "Pantai Kuta Lombok", 10);
        wisata.addEdge("Pantai Kuta Lombok", "Desa Sade", 10);
        wisata.addEdge("Pantai Kuta Lombok", "Tanjung Aan", 7);
        wisata.addEdge("Tanjung Aan", "Pantai Kuta Lombok", 7);
        wisata.addEdge("Tanjung Aan", "Bukit Merese", 3);
        wisata.addEdge("Bukit Merese", "Tanjung Aan", 3);
        wisata.addEdge("Bukit Merese", "Pantai Pink", 40);
        wisata.addEdge("Pantai Pink", "Bukit Merese", 40);
        wisata.addEdge("Pantai Pink", "Pantai Mawun", 25);
        wisata.addEdge("Pantai Mawun", "Pantai Pink", 25);
        wisata.addEdge("Pantai Mawun", "Pantai Selong Belanak", 10);
        wisata.addEdge("Pantai Selong Belanak", "Pantai Mawun", 10);
        wisata.addEdge("Pantai Selong Belanak", "Bandara Internasional Lombok", 20);
        wisata.addEdge("Bandara Internasional Lombok", "Pantai Selong Belanak", 20);

        userList.addUser("admin", "admin", "admin");
        userList.addUser("user", "user", "user");
        clearConsole();
        login(userList);

    }

    private static void login(UserLinkedList userList) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userList.findUser(username);

        if (user != null && user.password.equals(password)) {
            if (user.role.equals("admin")) {
                adminMenu();
                clearConsole();
            } else if (user.role.equals("user")) {
                userMenu();
                clearConsole();
            }
        } else {
            System.out.println("Username atau password salah!");
            login(userList); 
        }
    }

    private static void adminMenu() {
        clearConsole();
        while (true) {
            System.out.println("1. Kelola User");
            System.out.println("2. Kelola Wisata");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    kelolaUser();
                    break;

                case 2:
                    kelolaWisata();
                    break;

                case 3:
                    System.out.println("Logout berhasil.");
                    scanner.nextLine();
                    clearConsole();
                    login(userList);
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void kelolaUser() {
        clearConsole();
        while (true) {
            System.out.println("1. Tambah User");
            System.out.println("2. Edit User");
            System.out.println("3. Tampilkan Daftar User");
            System.out.println("4. Cari User");
            System.out.println("5. Hapus User");
            System.out.println("6. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();
                    System.out.print("Masukkan role (admin/user): ");
                    String role = scanner.nextLine();
                    userList.addUser(username, password, role);
                    break;
                case 2:
                    userList.printUserList();
                    System.out.print("Masukkan nomor user yang ingin diedit: ");
                    int nomor = scanner.nextInt();
                    scanner.nextLine();
                    User user = userList.getUserByIndex(nomor - 1);
                    if (user != null) {
                        System.out.print("Masukkan password baru: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Masukkan role baru (admin/user): ");
                        String newRole = scanner.nextLine();
                        userList.updateUser(user.username, newPassword, newRole);
                    } else {
                        System.out.println("User dengan nomor " + nomor + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    userList.printUserList();
                    break;

                case 4:
                    userList.printUserList();
                    System.out.println("Masukan Username dri User yang ingin dicari : ");
                    String Username = scanner.nextLine();
                    userList.findUser(Username);
                    scanner.nextLine();
                    clearConsole();
                    break;

                case 5:
                    System.out.print("Masukkan nomor user yang ingin dihapus: ");
                    int nomorUser = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    boolean isDeleted = userList.deleteUserByIndex(nomorUser - 1);
                    if (!isDeleted) {
                        System.out.println("Gagal menghapus user.");
                    }
                    break;
                case 6:
                    clearConsole();
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    private static void kelolaWisata() {
        clearConsole();
        while (true) {
            System.out.println("1. Tambah Wisata");
            System.out.println("2. Hapus Wisata");
            System.out.println("3. Tampilkan Wisata");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearConsole();
                    System.out.print("Masukkan nama wisata: ");
                    String namaWisata = scanner.nextLine();
                    System.out.print("Masukkan harga wisata: ");
                    int harga = scanner.nextInt();
                    System.out.print("Masukkan rating wisata: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();
                    wisata.addWisata(namaWisata, harga, rating);
                    boolean tambahTetangga = true;
                    while (tambahTetangga) {
                        System.out.print("Masukkan Tetangga / jalur Wisata : ");
                        String tetangga = scanner.nextLine();
                        System.out.print("Masukkan Jarak dari Wisata ke Tetangga : ");
                        int jarak = scanner.nextInt();
                        scanner.nextLine();

                        wisata.addEdge(namaWisata, tetangga, jarak);
                        wisata.addEdge(tetangga, namaWisata, jarak);

                        System.out.print("Apakah masih ada jalur / tetangga lain? (ya/tidak): ");
                        String konfirmasi = scanner.nextLine();
                        if (!konfirmasi.equalsIgnoreCase("ya")) {
                            tambahTetangga = false;
                        }
                    }

                    System.out.println("Wisata berhasil ditambahkan.");
                    clearConsole();
                    break;

                case 2:
                    System.out.print("Wisata akan di Hapus dari yang terakhir Ditambahkan, (ya/tidak) ? : ");
                    String konfirmasi = scanner.nextLine();
                    if (konfirmasi.equals("ya") || konfirmasi.equals("y")) {
                        wisata.deleteWisata();
                        scanner.nextLine();
                        clearConsole();
                        adminMenu();
                    } else {
                        scanner.nextLine();
                        clearConsole();
                        adminMenu();
                    }
                    break;
                case 3:
                    System.out.println("Daftar Wisata:");
                    System.out.println("-------------------------------------------------------");
                    System.out.printf("%-5s %-30s %-10s %-10s\n", "No.", "Nama", "Harga", "Rating");
                    System.out.println("-------------------------------------------------------");

                    Wisata temp = wisata.head;
                    int nomer = 1;
                    while (temp != null) {
                        System.out.printf("%-5d %-30s %-10d %-10.2f\n", nomer, temp.nama, temp.harga, temp.rating);
                        temp = temp.next;
                        nomer++;
                    }
                    System.out.println("-------------------------------------------------------");
                    scanner.nextLine();
                    clearConsole();
                    break;
                case 4:
                    System.out.println("Logout berhasil.");
                    scanner.nextLine();
                    clearConsole();
                    login(userList);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void userMenu() {
        clearConsole();
        while (true) {
            System.out.println("1. Tampilkan daftar wisata");
            System.out.println("2. Cari wisata berdasarkan nama");
            System.out.println("3. Sorting Wisata");
            System.out.println("4. Schedule dan Rekomendasi Jalur");
            System.out.println("5. List schedule");
            System.out.println("6. Riwayat perjalanan");
            System.out.println("7. Logout");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.println("Daftar Wisata:");
                    System.out.println("-------------------------------------------------------");
                    System.out.printf("%-5s %-30s %-10s %-10s\n", "No.", "Nama", "Harga", "Rating");
                    System.out.println("-------------------------------------------------------");

                    Wisata temp = wisata.head;
                    int nomer = 1;
                    while (temp != null) {
                        System.out.printf("%-5d %-30s %-10d %-10.2f\n", nomer, temp.nama, temp.harga, temp.rating);
                        temp = temp.next;
                        nomer++;
                    }
                    System.out.println("-------------------------------------------------------");
                    scanner.nextLine();
                    clearConsole();
                    break;
                case 2:
                    clearConsole();
                    System.out.print("Masukkan nama wisata: ");
                    String cariWisata = scanner.nextLine();
                    Wisata hasilCari = wisata.find(cariWisata);
                    if (hasilCari != null) {
                        System.out.println("Wisata ditemukan: " + hasilCari.nama + "| " + hasilCari.harga + "| "
                                + hasilCari.rating);
                    } else {
                        System.out.println("Wisata tidak ditemukan.");
                    }
                    scanner.nextLine();
                    clearConsole();
                    break;
                case 3:
                    clearConsole();
                    sortSubMenu();
                case 4:
                    clearConsole();
                    System.out.print("Masukkan lokasi awal: ");
                    String startLocation = scanner.nextLine();
                    System.out.print("Masukkan lokasi tujuan: ");
                    String endLocation = scanner.nextLine();
                    System.out.print("Masukkan waktu mulai (format: HH:mm): ");
                    String waktuStart = scanner.nextLine();

                    String confirm;
                    wisata.tampilkanSemuaJalurDFS(startLocation, endLocation);

                    System.out.print("Apakah Anda ingin menambahkan jadwal ini ke daftar? (ya/tidak): ");
                    confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("ya")) {
                        daftarJadwal.addJadwal(startLocation, endLocation, waktuStart);
                        System.out.println("Jadwal berhasil ditambahkan.");
                    } else {
                        System.out.println("Jadwal dibatalkan.");
                    }
                    scanner.nextLine();
                    clearConsole();
                    break;
                case 5:
                    System.out.println("\nDaftar Jadwal Perjalanan:");
                    daftarJadwal.printList();

                    System.out.println("\nApakah Anda ingin menandai jadwal sebagai selesai? (ya/tidak)");
                    String pilihan = scanner.nextLine();
                    if (pilihan.equalsIgnoreCase("ya")) {
                        scanner.nextLine();
                        System.out.print("Masukkan waktu selesai: ");
                        String waktuSelesai = scanner.nextLine();
                        daftarJadwal.tandaiSelesai(waktuSelesai);
                    }
                    scanner.nextLine();
                    clearConsole();
                    break;
                case 6:
                    daftarJadwal.printRiwayat();
                    scanner.nextLine();
                    clearConsole();
                    break;
                case 7:
                    System.out.println("Logout berhasil.");
                    scanner.nextLine();
                    clearConsole();
                    login(userList);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


