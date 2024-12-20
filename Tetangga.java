public class Tetangga {
    Wisata simpul;
    Tetangga next;
    int bobot;

    public Tetangga(Wisata simpul, int bobot) {
        this.simpul = simpul;
        this.bobot = bobot;
        this.next = null;
    }
}