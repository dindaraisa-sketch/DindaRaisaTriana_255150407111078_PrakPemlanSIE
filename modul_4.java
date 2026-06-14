public class Tiket {
    private String namaPenumpang = "Anonim";
    private String tujuan = "Jakarta";
    private int jarakTempuh = 750;
    private double hargaTiket = 250000;
    
    public void pesan() {}

    public void pesan(String n, String t) {
        this.namaPenumpang = n;
        this.tujuan = t;
        this.jarakTempuh = 90;
        this.hargaTiket = 55000;
    }

    public void pesan(String n, String t, int j, double h) {
        this.namaPenumpang = n;
        this.tujuan = t;
        this.jarakTempuh = j;
        this.hargaTiket = h;
    }

    public void pesan(String n, int j) {
        this.namaPenumpang = n;
        this.jarakTempuh = j;
    }

    public void pesan(String t, String n) {
        this.tujuan = t;
        this.namaPenumpang = n;
    }

    public void tampil() {
        System.out.println("Nama Penumpang: " + this.namaPenumpang);
        System.out.println("Tujuan: " + this.tujuan);
        System.out.println("Jarak Tempuh: " + this.jarakTempuh);
        System.out.println("Harga Tiket: " + this.hargaTiket);
        System.out.println("--------------------");
    }
}

public class AgenBusApp {
    public static void main(String[] args) {

        Tiket t1 = new Tiket();
        t1.pesan();
        t1.tampil();

        TiketBus t2 = new TiketBus();
        t2.pesan();
        t2.tampil();

        TiketBus t3 = new TiketBus();
        t3.pesan("Kasino", "Bandung", 650, 450000);
        t3.tampil();

        t1.pesan("Indro", "Makassar");
        t1.tampil();

        t2.pesan("Dono", "Makassar");
        t2.tampil();

        TiketBus t4 = new TiketBus();
        t4.pesan("Budi");
        t4.tampil();
     
        TiketBus t5 = new TiketBus() {
            @Override
            public void tampil() {
                System.out.println("===== DETAIL TIKET BUS =====");
                System.out.println("Nama Penumpang : " + namaPenumpang);
                System.out.println("Tujuan         : " + tujuan);
                System.out.println("Harga Tiket    : " + hargaTiket);
                System.out.println("============================");
            }
        };

        t5.pesan("Siti", "Bandung", 500, 300000);
        t5.tampil();
    }
}

public class AmongUsGame {

    public static void main(String[] args) {

        Character brian, cindy, david, jacky;

        brian = new Crew("Brian");
        cindy = new Crew("Cindy");
        david = new Crew("David");
        jacky = new Crew("Jacky");

        brian.doWork();
        cindy.doWork();
        david.doWork();
        jacky.doWork();

        // Jacky menjadi Impostor
        jacky = new Impostor(jacky);
        jacky.kill(cindy);

        // Jacky memakai "topeng" NPC
        jacky = new NonPlayableChar(jacky);

        if (david instanceof Crew crew)
            crew.callMeeting();

        AmongUsGame.check(brian);
        AmongUsGame.check(david);
        AmongUsGame.check(jacky);
    }

    public static void check(Character ch) {
        if (AmongUsGame.isImpostor(ch))
            System.out.println(ch.name + " is the impostor!");
        else
            System.out.println(ch.name + " is not the impostor.");
    }

    public static boolean isImpostor(Character ch) {
        return (ch instanceof Impostor);
    }
}

public class Character { 
    public String name; 
    public void doWork() {} 
    public void kill(Character ch) {
        
    } 
  
}

public class Crew extends Character { 
    public Crew(String name) { 
    this.name = name; 
    } 
    
    @Override 
    public void doWork() { 
        System.out.println("Crew " + this.name + " is doing work."); 
    } 
    public void callMeeting() { 
        System.out.print(this.name + " found a corpse "); 
        System.out.print("and calls a meeting. "); 
        System.out.println("Let's find the impostor!"); 
    } 
  
}

public class Impostor extends Character { 
    public Impostor(Character ch) { 
        this.name = ch.name; 
    } 
    public void kill(Character ch) { 
        System.out.println(ch.name + " has been killed!"); 
    } 
  
}

public class NonPlayableChar extends Character {

    public NonPlayableChar(Character ch) {
        this.name = ch.name;
    }

    @Override
    public void doWork() {
        System.out.println("NPC " + this.name + " is wandering around.");
    }
}

public class Tiket {
    protected String namaPenumpang = "Anonim";
    protected String tujuan = "Jakarta";
    protected int jarakTempuh = 750;
    protected double hargaTiket = 250000;

    public void pesan() {
        namaPenumpang = "Anonim";
        tujuan = "Jakarta";
        jarakTempuh = 750;
        hargaTiket = 250000;
    }

    public void pesan(String n, String t) {
        this.namaPenumpang = n;
        this.tujuan = t;
        this.jarakTempuh = 90;
        this.hargaTiket = 55000;
    }

    public void pesan(String n, String t, int j, double h) {
        this.namaPenumpang = n;
        this.tujuan = t;
        this.jarakTempuh = j;
        this.hargaTiket = h;
    }

    public void tampil() {
        System.out.println("Nama Penumpang: " + namaPenumpang);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Jarak Tempuh: " + jarakTempuh);
        System.out.println("Harga Tiket: " + hargaTiket);
        System.out.println("--------------------");
    }
}

public class TiketBus extends Tiket {

    @Override
    public void pesan() {
        this.tujuan = "Bandung";
    }

    @Override
    public void pesan(String n, String t) {
        if (t.equals("Makassar")) {
            this.tujuan = "Makassar";
            System.out.println("Maaf " + n + ", tiket tidak dapat dipesan.");
        } else {
            this.namaPenumpang = n;
            this.tujuan = t;
        }
    }

    @Override
    public void tampil() {
        if (!this.tujuan.equals("Makassar")) {
            super.tampil();
        } else {
            System.out.println("Tiket tujuan Makassar tidak tersedia.");
            System.out.println("--------------------");
        }
    }

    public void pesan(String n) {
        this.namaPenumpang = n;
    }
}
