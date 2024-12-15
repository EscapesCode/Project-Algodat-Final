
import java.util.Scanner;

class Vertex {
    String nama;
    Tetangga tetangga;
    boolean dikunjungi; 
    int jarak; 
    Vertex next;
    Vertex jalur;

    public Vertex(String nama) {
        this.nama = nama;
        this.next = null;
        this.tetangga = null;
        this.dikunjungi = false;
        this.jarak = Integer.MAX_VALUE;
        this.jalur = null;
    }
}

class Tetangga {
    Vertex simpul;
    Tetangga next;
    int bobot;

    public Tetangga(Vertex simpul, int bobot) {
        this.simpul = simpul;
        this.bobot = bobot;
        this.next = null;
    }
}

class Graph {
    Vertex head;

    public Graph() {
        this.head = null;
    }

    void addVertex(String nama) {
        Vertex simpulBaru = new Vertex(nama);
        if (head == null) {
            head = simpulBaru;
        } else {
            Vertex temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = simpulBaru;
        }
    }

    Vertex find(String nama) {
        Vertex temp = head;
        while (temp != null) {
            if (temp.nama.equals(nama)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void addEdge(String host, String tujuan, int bobot) {
        Vertex simpulHost = find(host);
        Vertex simpulTujuan = find(tujuan);

        if (simpulHost != null && simpulTujuan != null) {
            Tetangga tetanggaBaru = new Tetangga(simpulTujuan, bobot);
            if (simpulHost.tetangga == null) {
                simpulHost.tetangga = tetanggaBaru;
            } else {
                Tetangga temp = simpulHost.tetangga;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = tetanggaBaru;
            }
        }
    }

    void DJSiktra(String startLocation, String endLocation) {
        Vertex start = find(startLocation);
        Vertex end = find(endLocation);

        if (start == null || end == null) {
            System.out.println("Lokasi tidak ditemukan!");
            return;
        }

        ResetVertex();
        start.jarak = 0;

        Vertex current = start;
        while (current != null) {
            Tetangga tetangga = current.tetangga;

            while (tetangga != null) {
                int totalBobot = current.jarak + tetangga.bobot;
                if (totalBobot < tetangga.simpul.jarak) {
                    tetangga.simpul.jarak = totalBobot;
                    tetangga.simpul.jalur = current;
                }
                tetangga = tetangga.next;
            }
            current.dikunjungi = true;
            current = findSimpulJarakkecil();
        }

        if (end.jarak == Integer.MAX_VALUE) {
            System.out.println("Tidak ada jalur dari " + startLocation + " ke " + endLocation);
        } else {
            printPath(end);
            System.out.println("\nJarak total: " + end.jarak);
        }
    }

    Vertex findSimpulJarakkecil() {
        Vertex temp = head;
        Vertex vertexEfisien = null;
        int jarakTerkecil = Integer.MAX_VALUE;

        while (temp != null) {
            if (!temp.dikunjungi && temp.jarak < jarakTerkecil) {
                jarakTerkecil = temp.jarak;
                vertexEfisien = temp;
            }
            temp = temp.next;
        }
        return vertexEfisien;
    }

    void ResetVertex() {
        Vertex temp = head;
        while (temp != null) {
            temp.jarak = Integer.MAX_VALUE;
            temp.dikunjungi = false;
            temp.jalur = null;
            temp = temp.next;
        }
    }

    void printPath(Vertex simpul) {
        if (simpul.jalur != null) {
            printPath(simpul.jalur);
            System.out.print(" => ");
        }
        System.out.print(simpul.nama);
    }
}

class Jadwal {
    String startLocation;
    String endLocation;
    String waktuStart;
    String waktuSelesai;
    Jadwal next;

    public Jadwal(String startLocation, String endLocation, String waktuStart) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.waktuStart = waktuStart;
        this.waktuSelesai = null; 
        this.next = null;
    }

    @Override
    public String toString() {
        return "Jadwal: " + startLocation + " -> " + endLocation + " | Waktu Mulai: " + waktuStart +
                (waktuSelesai != null ? " | Waktu Selesai: " + waktuSelesai : "");
    }
}


class Riwayat {
    String startLocation;
    String endLocation;
    String waktuStart;
    String waktuSelesai;
    Riwayat next;

    public Riwayat(String startLocation, String endLocation, String waktuStart, String waktuSelesai) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.waktuStart = waktuStart;
        this.waktuSelesai = waktuSelesai;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Graph wisata = new Graph();
            LinkedList daftarJadwal = new LinkedList();

            wisata.addVertex("Gunung Rinjani");
            wisata.addVertex("Loang Baloq");
            wisata.addVertex("Mataram Mall");
            wisata.addVertex("Pantai Senggigi");
            wisata.addVertex("Sembalun");
            wisata.addVertex("Sesaot");
            wisata.addVertex("Desa Banyumulek");
            wisata.addVertex("Bandara Internasional Lombok");
            wisata.addVertex("Pantai Kuta Lombok");
            wisata.addVertex("Gili Trawangan");

            wisata.addEdge("Gunung Rinjani", "Loang Baloq", 9);
            wisata.addEdge("Loang Baloq", "Pantai Senggigi", 9);
            wisata.addEdge("Pantai Senggigi", "Sesaot", 11);
            wisata.addEdge("Sesaot", "Bandara Internasional Lombok", 2);
            wisata.addEdge("Bandara Internasional Lombok", "Pantai Kuta Lombok", 8);
            wisata.addEdge("Pantai Kuta Lombok", "Gili Trawangan", 2);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Lihat lokasi wisata");
                System.out.println("2. Cari lokasi wisata");
                System.out.println("3. Buat jadwal perjalanan");
                System.out.println("4. Daftar jadwal perjalanan");
                System.out.println("5. Riwayat perjalanan");
                System.out.println("6. Keluar");
                System.out.print("Pilih menu: ");
                int menu = scanner.nextInt();
                scanner.nextLine();

                if (menu == 1) {
                    System.out.println("\nDaftar Lokasi Wisata:");
                    Vertex temp = wisata.head;
                    while (temp != null) {
                        System.out.println("- " + temp.nama);
                        temp = temp.next;
                    }
                } else if (menu == 2) {
                    System.out.print("Masukkan nama lokasi wisata: ");
                    String lokasiCari = scanner.nextLine();
                    Vertex result = wisata.find(lokasiCari);
                    if (result != null) {
                        System.out.println("Lokasi ditemukan: " + result.nama);
                    } else {
                        System.out.println("Lokasi tidak ditemukan.");
                    }
                } else if (menu == 3) {
                    System.out.print("Masukkan lokasi awal: ");
                    String startLocation = scanner.nextLine();
                    System.out.print("Masukkan lokasi tujuan: ");
                    String endLocation = scanner.nextLine();
                    System.out.print("Masukkan waktu mulai (format: HH:mm): ");
                    String waktuStart = scanner.nextLine();

                    System.out.println("\nJalur terpendek:");
                    wisata.DJSiktra(startLocation, endLocation);

                    System.out.print("Apakah Anda ingin menambahkan jadwal ini ke daftar? (ya/tidak): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("ya")) {
                        daftarJadwal.addJadwal(startLocation, endLocation, waktuStart);
                        System.out.println("Jadwal berhasil ditambahkan.");
                    } else {
                        System.out.println("Jadwal dibatalkan.");
                    }
                } else if (menu == 4) {
                    System.out.println("\nDaftar Jadwal Perjalanan:");
                    daftarJadwal.printList();  
                
                    System.out.println("\nApakah Anda ingin menandai jadwal sebagai selesai? (ya/tidak)");
                    String pilihan = scanner.nextLine();
                    if (pilihan.equalsIgnoreCase("ya")) {
                        System.out.print("Masukkan nomor jadwal yang ingin ditandai selesai: ");
                        int nomorJadwal = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Masukkan waktu selesai: ");
                        String waktuSelesai = scanner.nextLine();
                        daftarJadwal.tandaiSelesai(nomorJadwal, waktuSelesai);
                    }
                } else if (menu == 5) {
                    daftarJadwal.printRiwayat();
                } else if (menu == 6) {
                    System.out.println("Keluar dari program.");
                    break;
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}

class LinkedList {
    Jadwal headJadwal;
    Jadwal headRiwayat;

    public LinkedList() {
        this.headJadwal = null;
        this.headRiwayat = null;
    }

    public void addJadwal(String startLocation, String endLocation, String waktuStart) {
        Jadwal jadwalBaru = new Jadwal(startLocation, endLocation, waktuStart);
        if (headJadwal == null) {
            headJadwal = jadwalBaru;
        } else {
            Jadwal temp = headJadwal;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = jadwalBaru;
        }
    }

    public void printList() {
        Jadwal tempJadwal = headJadwal;
        int nomor = 1;
        while (tempJadwal != null) {
            System.out.println(nomor + ". " + tempJadwal);
            tempJadwal = tempJadwal.next;
            nomor++;
        }
    }

    public void tandaiSelesai(int nomorJadwal, String waktuSelesai) {
        Jadwal temp = headJadwal;
        Jadwal prev = null;
        int counter = 1;

        while (temp != null && counter < nomorJadwal) {
            prev = temp;
            temp = temp.next;
            counter++;
        }

        if (temp != null && counter == nomorJadwal) {
            temp.waktuSelesai = waktuSelesai;

            if (prev == null) {
                headJadwal = temp.next;
            } else {
                prev.next = temp.next;
            }

            if (headRiwayat == null) {
                headRiwayat = temp;
            } else {
                Jadwal riwayatTemp = headRiwayat;
                while (riwayatTemp.next != null) {
                    riwayatTemp = riwayatTemp.next;
                }
                riwayatTemp.next = temp;
            }
            temp.next = null;
        } else {
            System.out.println("Nomor jadwal tidak ditemukan.");
        }
    }

    public void printRiwayat() {
        Jadwal tempRiwayat = headRiwayat;
        int nomor = 1;
        while (tempRiwayat != null) {
            System.out.println(nomor + ". " + tempRiwayat);
            tempRiwayat = tempRiwayat.next;
            nomor++;
        }
    }
}


