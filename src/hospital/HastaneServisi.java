package hospital;

import java.util.LinkedList;
import java.util.Scanner;

import static hospital.Islemler.*;

public class HastaneServisi {
    static Scanner scan = new Scanner(System.in);
    static Doktor doktor = new Doktor();
    static Hasta hasta = new Hasta();
    static LinkedList<Hasta> hastaListesi = new LinkedList<>();
    static LinkedList<Durum> hastaDurumListesi = new LinkedList<>();
    private static Hastane hastane2 = new Hastane();

    public static void main(String[] args) {
        ekle();
    }

    public static void ekle() {

        System.out.println("Eklemek istediginiz hastanin ADINI giriniz");
        String hastaAdi = scan.next();
        System.out.println("Eklemek istediginiz hastanin SOYADINI giriniz");
        String hastaSoyadi = scan.next();
        scan.nextLine();
        System.out.println("slm23.satir");
        int hastaId = VeriBankasi.hastaIDleri.get(VeriBankasi.hastaIDleri.size() - 1) + 111;
        System.out.println(hastaId);
        String durum;
        boolean aciliyet;

        do {
            System.out.println("Hastanin Durumu:\n\t=> Allerji\n\t=> Bas agrisi\n\t=> Diabet\n\t=> Soguk alginligi\n\t=> Migren\n\t" +
                    "=> Kalp hastaliklari");
            durum = scan.nextLine().toLowerCase().trim();
            if (durum.equals("allerji") || durum.equals("bas agrisi") || durum.equals("diabet") ||
                    durum.equals("soguk alginligi") || durum.equals("migren") || durum.equals("kalp hastaliklari")) {
                hastaDurumu(durum);
            }else{
                ekle();
            }
            System.out.println(durum);
        }
        while (durum.equalsIgnoreCase("Yanlis Durum"));
        aciliyet = hastaDurumuBul(durum).isAciliyet();
        System.out.println(aciliyet);
        Durum hastaDurum = new Durum(durum, aciliyet);
        hastaDurumListesi.add(hastaDurum);
        Hasta hasta = new Hasta(hastaAdi, hastaSoyadi, hastaId, hastaDurum);

        hastaListesi.add(hasta);

        System.out.println(hastaListesi);
        System.out.println("slm3");
        hastalariListele();

    }

    public static Hasta hastaEkle() {


        return hasta;
    }
}
