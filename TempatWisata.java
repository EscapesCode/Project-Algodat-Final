
public class TempatWisata {
    String nama;
    int jarak;
    int harga;
    int totalRating;
    int jumlahRating;
    // TempatWisata next;

    public TempatWisata(String nama, int jarak, int harga) {
        this.nama = nama;
        this.jarak = jarak;
        this.harga = harga;
        this.totalRating = 0;
        this.jumlahRating = 0;

    }

    double getRating() {
        return jumlahRating == 0 ? 0 : (double) totalRating / jumlahRating;
    }

    void tambahRating(int rating) {
        totalRating += rating;
        jumlahRating++;
    }
}