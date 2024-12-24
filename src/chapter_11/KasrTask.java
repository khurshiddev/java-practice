package chapter_11;

public class KasrTask {
    public static void main(String[] args) {

        Kasr k1 = new Kasr(4, 8);
        Kasr k2 = new Kasr(2, 5);
        k1.add(k2);
        System.out.println(k1);
    }
}
class Kasr {
    private int surat;
    private int maxraj;

    public Kasr(int surat, int maxraj) {
        this.surat = surat;
        this.maxraj = maxraj;
    }

    public void add(Kasr kasr) {
        maxraj = maxraj * kasr.maxraj;
        surat = (surat * kasr.maxraj) + (kasr.surat * maxraj);
        System.out.println(surat + " | " + maxraj);
    }

}


