class Schedule {
    String judulPerjalanan;
    String lokasiAwal;
    String lokasiTujuan;
    LinkedList jalur;
    int totalJarak;
    String waktuMulai;
    String waktuSelesai;

    public Schedule(String judulPerjalanan, String lokasiAwal, String lokasiTujuan, LinkedList jalur, int totalJarak, String waktuMulai) {
        this.judulPerjalanan = judulPerjalanan;
        this.lokasiAwal = lokasiAwal;
        this.lokasiTujuan = lokasiTujuan;
        this.jalur = jalur;
        this.totalJarak = totalJarak;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = null;
    }

    void tandaiSelesai(String waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }
}