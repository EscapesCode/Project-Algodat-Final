public class Graph {
    Wisata head;

    public Graph() {
        this.head = null;
    }
    public void sortByHarga() {
        if (head == null)
            return;

        boolean swapped;
        do {
            swapped = false;
            Wisata current = head;
            while (current != null && current.next != null) {
                if (current.harga > current.next.harga) {
                    swapWisataData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Wisata berhasil diurutkan berdasarkan harga.");
        printWisataList();
    }

    public void sortByRating() {
        if (head == null)
            return;
        boolean swapped;
        do {
            swapped = false;
            Wisata current = head; 
            while (current != null && current.next != null) {
                if (current.rating < current.next.rating) {
                    swapWisataData(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("Wisata berhasil diurutkan berdasarkan rating.");
        printWisataList(); 
    }

    private void printWisataList() {
        System.out.println("Daftar Wisata:");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-5s %-30s %-10s %-10s\n", "No.", "Nama", "Harga", "Rating");
        System.out.println("-------------------------------------------------------");

        Wisata temp = head;
        int nomer = 1;
        while (temp != null) {
            System.out.printf("%-5d %-30s %-10d %-10.2f\n", nomer, temp.nama, temp.harga, temp.rating);
            temp = temp.next;
            nomer++;
        }
        System.out.println("-------------------------------------------------------");
    }

    // Method buat nukar data dua wisata
    private void swapWisataData(Wisata w1, Wisata w2) {
        String tempNama = w1.nama;
        int tempHarga = w1.harga;
        double tempRating = w1.rating;
        int tempJarak = w1.jarak;

        w1.nama = w2.nama;
        w1.harga = w2.harga;
        w1.rating = w2.rating;
        w1.jarak = w2.jarak;

        w2.nama = tempNama;
        w2.harga = tempHarga;
        w2.rating = tempRating;
        w2.jarak = tempJarak;
    }

    void addWisata(String nama, int harga, double rating) {
        Wisata simpulBaru = new Wisata(nama, harga, rating);
        simpulBaru.next = head;
        head = simpulBaru; 
    }
    void deleteWisata() {
        if (head == null) {
            System.out.println("Daftar wisata kosong.");
            return;
        }

        // kalo wisata dihapus head (wisata pertama)
        Wisata temp = head;
        head = head.next;

        if (temp.tetangga != null) {
            Tetangga tempTetangga = temp.tetangga;
            while (tempTetangga != null) {
                removeEdge(temp.nama, tempTetangga.simpul.nama); // Hapus edge ke wisata terhubung
                tempTetangga = tempTetangga.next;
            }
        }

        Wisata current = head;
        while (current != null) {
            if (current.tetangga != null) {
                Tetangga prev = null;
                Tetangga tempTetangga = current.tetangga;
                while (tempTetangga != null) {
                    if (tempTetangga.simpul == temp) {
                        if (prev == null) {
                            current.tetangga = tempTetangga.next; // Hapus tetangga pertama
                        } else {
                            prev.next = tempTetangga.next; // Hapus mana mana yang di termuin
                        }
                        break;
                    }
                    prev = tempTetangga;
                    tempTetangga = tempTetangga.next;
                }
            }
            current = current.next;
        }

        System.out.println("Wisata " + temp.nama + " berhasil dihapus.");
    }

    Wisata find(String nama) {
        Wisata temp = head;
        while (temp != null) {
            if (temp.nama.equals(nama)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void addEdge(String host, String tujuan, int bobot) {
        Wisata simpulHost = find(host);
        Wisata simpulTujuan = find(tujuan);

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

    void removeEdge(String host, String tujuan) {
        Wisata simpulHost = find(host);
        Wisata simpulTujuan = find(tujuan);

        if (simpulHost != null && simpulTujuan != null) {
            // jika tetangga pertama itu simpul tujuan
            if (simpulHost.tetangga != null && simpulHost.tetangga.simpul == simpulTujuan) {
                simpulHost.tetangga = simpulHost.tetangga.next; // Hapus tetangga pertama
            } else {
                Tetangga temp = simpulHost.tetangga;
                while (temp != null && temp.next != null) {
                    if (temp.next.simpul == simpulTujuan) {
                        temp.next = temp.next.next; 
                        System.out.println("Edge antara " + host + " dan " + tujuan + " berhasil dihapus.");
                        return; // abis delete balik menu utama
                    }
                    temp = temp.next;
                }
                System.out.println("Edge antara " + host + " dan " + tujuan + " tidak ditemukan.");
            }
        }
    }

    public void tampilkanSemuaJalurDFS(String startLocation, String endLocation) {
        Wisata start = find(startLocation);
        Wisata end = find(endLocation);

        if (start == null || end == null) {
            System.out.println("Lokasi tidak ditemukan!");
            return;
        }

        resetVisitedStatus();

        System.out.println("\nDaftar Jalur yang Bisa Ditempuh:");
        StringBuilder currentPath = new StringBuilder();
        DFS(start, end, new LinkedListSchedule(), currentPath);

        System.out.println("\nJalur Terpendek:");
        DJSiktra(startLocation, endLocation);
    }

    private void resetVisitedStatus() {
        Wisata temp = head;
        while (temp != null) {
            temp.dikunjungi = false; 
            temp = temp.next;
        }
    }

    private void DFS(Wisata current, Wisata end, LinkedListSchedule jalur, StringBuilder currentPath) {

        currentPath.append(current.nama).append(" -> ");

        if (current == end) {
            System.out.println(currentPath.substring(0, currentPath.length() - 4));
        } else {
            Tetangga temp = current.tetangga;
            while (temp != null) {
                if (!temp.simpul.dikunjungi) {
                    temp.simpul.dikunjungi = true;
                    DFS(temp.simpul, end, jalur, currentPath);
                    temp.simpul.dikunjungi = false;
                }
                temp = temp.next;
            }
        }
        currentPath.setLength(currentPath.length() - (current.nama.length() + 4));
    }

    void DJSiktra(String startLocation, String endLocation) {
        Wisata start = find(startLocation);
        Wisata end = find(endLocation);

        if (start == null || end == null) {
            System.out.println("Lokasi tidak ditemukan!");
            return;
        }
        ResetWisata();
        start.jarak = 0;
        while (true) {
            Wisata current = findSimpulJarakkecil();
            if (current == null) {
                break;
            }
            current.dikunjungi = true;
            Tetangga tetangga = current.tetangga;
            while (tetangga != null) {
                if (!tetangga.simpul.dikunjungi) {
                    int jarakBaru = current.jarak + tetangga.bobot;
                    if (jarakBaru < tetangga.simpul.jarak) {
                        tetangga.simpul.jarak = jarakBaru;
                        tetangga.simpul.jalur = current;
                    }
                }
                tetangga = tetangga.next;
            }
        }
        if (end.jarak == Integer.MAX_VALUE) {
            System.out.println("Tidak ada jalur dari " + startLocation + " ke " + endLocation);
        } else {
            System.out.print("Jalur terpendek dari " + startLocation + " ke " + endLocation + ": ");
            printPath(end);
            System.out.println("\nJarak total: " + end.jarak + " km");
        }
    }

    Wisata findSimpulJarakkecil() {
        Wisata terkecil = null;
        int jarakTerkecil = Integer.MAX_VALUE;

        Wisata temp = head;
        while (temp != null) {
            if (!temp.dikunjungi && temp.jarak < jarakTerkecil) {
                jarakTerkecil = temp.jarak;
                terkecil = temp;
            }
            temp = temp.next;
        }
        return terkecil;
    }

    void ResetWisata() {
        Wisata temp = head;
        while (temp != null) {
            temp.jarak = Integer.MAX_VALUE; 
            temp.dikunjungi = false; 
            temp.jalur = null; 
            temp = temp.next;
        }
    }

    void printPath(Wisata simpul) {
        if (simpul.jalur != null) {
            printPath(simpul.jalur);
            System.out.print(" => ");
        }
        System.out.print(simpul.nama);
    }

}

