//Class dan Object
//Class Mobil.java 
package PraktikumPemlan1;

public class Mobil {
    private String nopol;
    private String warna;
    private String merk;
    private int kecepatan;
    private int jarakTempuh;
    
    public void setNopol(String n) {
        nopol = n;
    }
    public void setWarna(String s) {
        warna = s;
    }
    public void setMerk(String m) {
        merk = m;
    }
    public void setKecepatan(int k) {
        kecepatan = k;
    }
    public void setJarakTempuh(int jt) {
        jarakTempuh = jt;
    }
    public int hitungtJarakTempuh(int waktu) {
        jarakTempuh = kecepatan*waktu;
        return jarakTempuh;
    }
    public double ubahKJPkeMPS() {
        return kecepatan /3.6;
    }
    public void display() {
        System.out.println("Mobil bermerk " + merk);
        System.out.println("bernomor polisi " + nopol);
        System.out.println("serta memililki warna " + warna);
        System.out.println("bergerak dengan kecepatan " + kecepatan + " kpj");
        System.out.println("bergerak dengan kecepatan " + ubahKJPkeMPS() + " mps");
        System.out.println("Berjarak tempuh " + jarakTempuh + " km");
    }
}

//Class App.java
package PraktikumPemlan1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //instansiasi objek bernama m1
        Mobil m1 = new Mobil();

        System.out.print("Masukkan merk mobil1: ");
        m1.setMerk(in.nextLine());
        System.out.print("Masukkan nomor polisi mobil1: ");
        m1.setNopol(in.nextLine());

        m1.setKecepatan(50);
        m1.setWarna("Merah");
        m1.hitungtJarakTempuh(3);
        m1.display();
        System.out.println("---------------");
        //instansiasi objek bernama m2
        Mobil m2 = new Mobil();

        System.out.print("Masukkan merk mobil2: ");
        m2.setMerk(in.nextLine());
        System.out.print("Masukkan nomor polisi mobil2: ");
        m2.setNopol(in.nextLine());

        m2.setKecepatan(100);
        m2.setWarna("Biru");
        m2.hitungtJarakTempuh(5);
        m2.display();
        System.out.println("---------------");
        System.out.println("Atribut pada objek m1 diubah.");
        //mengubah warna dari objek m1
        m1.setWarna("Hijau");
        //menampilkan hasil perubahan
        m1.display();
    }
}

//Konstruktor
//Class Penerbit.java 
package PraktikumPemlan1;

public class Penerbit {
    String nama;
    String kota = "Malang";
    Penerbit() {
        this.nama = "Springer";
    }
    Penerbit(String nama) {
        this.nama = nama;
    }
    Penerbit(String nama, String kota) {
        this.nama = nama;
        this.kota = kota;
    }
    public void display() {
        System.out.println("Penerbit " + nama);
        System.out.println("di Kota " + kota);
    }
}

//Class PenerbitApp.java
package PraktikumPemlan1;

public class BukuApp { 
 public static void main(String[] args) { 
  
    Penerbit gm = new Penerbit("Gramedia", "Jakarta"); 
    Penerbit sp = new Penerbit("Springer", "New York"); 
    Buku artikel = new Buku(); 
    artikel.judul = "Rahasia OOP"; 
    artikel.halaman = 10; 
    artikel.author = "John D. Walker"; 
    artikel.penerbit = gm; 
    Buku paper = new Buku(); 
    paper.judul = "Tips dan Trik Pemrograman Diet"; 
    paper.halaman = 240; 
    paper.author = "Cydia Lapr"; 
    paper.penerbit = sp; 
    
    // === 
    artikel.display(); 
    paper.display(); 
    // copy! 
    artikel.author = paper.author; 
    artikel.author = "Halu de Luna"; 
    artikel.display(); 
    paper.display(); 
    // copy! 
    artikel.penerbit = paper.penerbit; 
    artikel.penerbit.nama = "UB Press"; 
    artikel.display(); 
    paper.display(); 
    } 
}

//Variabel Primitif dan Referensi
//Class Penerbit.java
package PraktikumPemlan1;

public class Penerbit {
    String nama;
    String kota = "Malang";
    Penerbit() {
        this.nama = "Springer";
    }
    Penerbit(String nama) {
        this.nama = nama;
    }
    Penerbit(String nama, String kota) {
        this.nama = nama;
        this.kota = kota;
    }
    public void display() {
        System.out.println("Penerbit " + nama);
        System.out.println("di Kota " + kota);
    }
}

//Class Buku.java
package PraktikumPemlan1;

public class Buku {
    public String judul; 
    public int halaman; 
    public String author; 
    public Penerbit penerbit; 
    public void display() { 
        System.out.println("Buku " + judul); 
        System.out.println("Halaman: " + halaman); 
        System.out.println("Author : " + author); 
        penerbit.display(); 
        System.out.println("------------------"); 
    } 
}

//Class BukuApp.java
package PraktikumPemlan1;

public class BukuApp { 
 public static void main(String[] args) { 
  
    Penerbit gm = new Penerbit("Gramedia", "Jakarta"); 
    Penerbit sp = new Penerbit("Springer", "New York"); 
    Buku artikel = new Buku(); 
    artikel.judul = "Rahasia OOP"; 
    artikel.halaman = 10; 
    artikel.author = "John D. Walker"; 
    artikel.penerbit = gm; 
    Buku paper = new Buku(); 
    paper.judul = "Tips dan Trik Pemrograman Diet"; 
    paper.halaman = 240; 
    paper.author = "Cydia Lapr"; 
    paper.penerbit = sp; 
    
    // === 
    artikel.display(); 
    paper.display(); 
    // copy! 
    artikel.author = paper.author; 
    artikel.author = "Halu de Luna"; 
    artikel.display(); 
    paper.display(); 
    // copy! 
    artikel.penerbit = paper.penerbit; 
    artikel.penerbit.nama = "UB Press"; 
    artikel.display(); 
    paper.display(); 
    } 
}

