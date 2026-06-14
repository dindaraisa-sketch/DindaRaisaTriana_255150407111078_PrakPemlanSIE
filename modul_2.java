
    public class GeometriApp {
    public static void main(String[] args) {
        Lingkaran lingKecil = new Lingkaran(2.0f);
        Lingkaran lingBesar = new Lingkaran(11.0f);
        float lK = lingKecil.luas();
        float lB = lingBesar.luas();
        System.out.println("Luas Lingkaran Kecil: " + lK);
        System.out.println("Luas Lingkaran Besar: " + lB);
    }
}

public class Lingkaran {
    public static float PI = 3.14f;
    public float r;

    public Lingkaran(float r) {
        this.r = r;
    }

    public float luas() {
        return Lingkaran.PI * r * r;
    }

    public static float keliling(Lingkaran ling) {
        return 2 * Lingkaran.PI * ling.r;
    }
}

public class SchoolApp {
    public static void main(String[] args) {
        Student miki = new Student("Miki");
        Student mini = new Student("Mini");

        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());

        System.out.println("Grade " + miki.getNama() + " " + miki.getSkor());
        System.out.println("Grade " + mini.getNama() + " " + mini.getSkor());
    }
}

public class Student {
    private String nama;
    private int skor;

    public Student(String nama) {
        this.nama = nama;
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public static void setNama(Student std, String nama) {
        std.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public int getSkor() {
        return this.skor;
    }
}
