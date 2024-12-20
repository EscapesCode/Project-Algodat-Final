public class Riwayat {
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

