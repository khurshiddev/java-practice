package chapter_17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InternetShoppingTask {
    public static void main(String[] args) {

        InternetDokon dokon = new InternetDokon();
        Mahsulot mah1 = new Mahsulot("Kir moshina", "Elektr Jihoz", 200, 10);
        Mahsulot mah2 = new Mahsulot("Telefon", "Elektr Jihoz", 500, 5);
        Mahsulot mah3 = new Mahsulot("Kitob", "kitob", 100, 3);
        dokon.addMahsulot(mah1);
        dokon.addMahsulot(mah2);
        dokon.addMahsulot(mah3);

        Xaridor xaridor1 = new Xaridor("Otabek","1");
        Xaridor xaridor2 = new Xaridor("Jurabek","2");
        Xaridor xaridor3 = new Xaridor("Ulug'bek","3");
        dokon.addXaridor(xaridor1);
        dokon.addXaridor(xaridor2);
        dokon.addXaridor(xaridor3);

        xaridor1.addMahsulot(mah1,7);
        xaridor1.addMahsulot(mah2,3);

        dokon.xaridniYakunlash(xaridor1);
        for (Mahsulot mah : dokon.topMahsulotlar()){
            System.out.println(mah);
        }

    }
}


// Mahsulot Class
class Mahsulot {
    private String nomi;
    private String kategoriya;
    private double narx;
    private int miqdor;
    private int sotilganSoni;

    public Mahsulot(String nomi, String kategoriya, double narx, int miqdor) {
        this.nomi = nomi;
        this.kategoriya = kategoriya;
        this.narx = narx;
        this.miqdor = miqdor;
        this.sotilganSoni = 0;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public String getKategoriya() {
        return kategoriya;
    }

    public void setKategoriya(String kategoriya) {
        this.kategoriya = kategoriya;
    }

    public double getNarx() {
        return narx;
    }

    public void setNarx(double narx) {
        this.narx = narx;
    }

    public int getMiqdor() {
        return miqdor;
    }

    public void setMiqdor(int miqdor) {
        this.miqdor = miqdor;
    }

    public int getSotilganSoni() {
        return sotilganSoni;
    }

    public void setSotilganSoni(int sotilganSoni) {
        this.sotilganSoni = sotilganSoni;
    }

    public void sotish(int miqdor) {
        if (this.miqdor >= miqdor) {
            this.miqdor -= miqdor;
            this.sotilganSoni += miqdor;
        }
    }

    @Override
    public String toString() {
        return "Mahsulot{" +
                "nomi='" + nomi + '\'' +
                ", kategoriya='" + kategoriya + '\'' +
                ", narx=" + narx +
                ", miqdor=" + miqdor +
                ", sotilganSoni=" + sotilganSoni +
                '}';
    }
}

// Xaridor Class
class Xaridor {
    private String ism;
    private String xaridorID;
    private List<Mahsulot> savatcha;

    public Xaridor(String ism, String xaridorID) {
        this.ism = ism;
        this.xaridorID = xaridorID;
        this.savatcha = new ArrayList<>();
    }

    public void addMahsulot(Mahsulot mahsulot, int miqdor) {
        if (mahsulot.getMiqdor() >= miqdor) {
            savatcha.add(new Mahsulot(mahsulot.getNomi(),
                    mahsulot.getKategoriya(), mahsulot.getNarx(), miqdor));
        } else {
            System.out.println("Savatcha bo'sh emas " + mahsulot.getNomi());
        }
    }

    public void removeMahsulot(String mahsulotNomi) {
        if (savatcha.removeIf(mahsulot -> mahsulot.getNomi().equals(mahsulotNomi))) ;
    }

    public double savatchaNarxi() {
        double total = 0;
        for (Mahsulot mah : savatcha) {
            total += mah.getNarx() * mah.getMiqdor();
        }
//        savatcha.forEach(mahsulot -> mahsulot.setNarx(savatchaNarxi()));
        return total;
    }
}

// InternetDokon Class
class InternetDokon {
    private List<Mahsulot> mahsulotlar;
    private List<Xaridor> xaridorlar;

    public InternetDokon() {
        this.mahsulotlar = new ArrayList<>();
        this.xaridorlar = new ArrayList<>();
    }

    public void addMahsulot(Mahsulot mahsulot) {
        mahsulotlar.add(mahsulot);
    }

    public void removeMahsulot(String mahsulotNomi) {
        mahsulotlar.removeIf(mah -> mah.getNomi().equals(mahsulotNomi));
    }

    public List<Mahsulot> topMahsulotlar() {
        mahsulotlar.sort(Comparator.comparingInt(Mahsulot -> Mahsulot.getSotilganSoni()));
        ArrayList<Mahsulot> top = new ArrayList<>();
        int count = 0;
        while (count < 5 && count < mahsulotlar.size()) {
            top.add(mahsulotlar.get(count));
            count++;
        }

        return top;
    }

    public void addXaridor(Xaridor xaridor) {
        xaridorlar.add(xaridor);
    }

    public void xaridniYakunlash(Xaridor xaridor) {
        System.out.println("mahsulotlar umumiy narxi = " + xaridor.savatchaNarxi());
        xaridor.removeMahsulot("Hammasi bo'shatildi");
    }
}



