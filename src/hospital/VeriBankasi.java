package hospital;

import java.util.ArrayList;
import java.util.List;

public class VeriBankasi {
  static   List<String> doctorIsimleri = new ArrayList<>();
    static List<String> doctorSoyIsimleri = new ArrayList<>();
    static List<String> unvanlar = new ArrayList<>();
    static   List<String> hastaIsimleri = new ArrayList<>();
    static   List<String> hastaSoyIsimleri = new ArrayList<>();
    static  List<String> durumlar = new ArrayList<>();
    static List<Integer> hastaIDleri = new ArrayList<>();
   static  {
        // Verilerin başlatılması
        doctorIsimleri.add("Nilson");
        doctorIsimleri.add("John");
        doctorIsimleri.add("Robert");
        doctorIsimleri.add("Marry");
        doctorIsimleri.add("Alan");
        doctorIsimleri.add("Mahesh");

        doctorSoyIsimleri.add("Avery");
        doctorSoyIsimleri.add("Abel");
        doctorSoyIsimleri.add("Erik");
        doctorSoyIsimleri.add("Jacob");
        doctorSoyIsimleri.add("Pedro");
        doctorSoyIsimleri.add("Tristen");

        unvanlar.add("Allergist");
        unvanlar.add("Norolog");
        unvanlar.add("Genel cerrah");
        unvanlar.add("Cocuk doktoru");
        unvanlar.add("Dahiliye");
        unvanlar.add("Kardiolog");

        hastaIsimleri.add("Warren");
        hastaIsimleri.add("Petanow");
        hastaIsimleri.add("Sophia");
        hastaIsimleri.add("Emma");
        hastaIsimleri.add("Darian");
        hastaIsimleri.add("Peter");

        hastaSoyIsimleri.add("Traven");
        hastaSoyIsimleri.add("William");
        hastaSoyIsimleri.add("George");
        hastaSoyIsimleri.add("Tristan");
        hastaSoyIsimleri.add("Luis");
        hastaSoyIsimleri.add("Cole");

        durumlar.add("Allerji");
        durumlar.add("Bas agrisi");
        durumlar.add("Diabet");
        durumlar.add("Soguk alginligi");
        durumlar.add("Migren");
        durumlar.add("Kalp hastaliklari");

        hastaIDleri.add(111);
        hastaIDleri.add(222);
        hastaIDleri.add(333);
        hastaIDleri.add(444);
        hastaIDleri.add(555);
        hastaIDleri.add(666);
    }
}
