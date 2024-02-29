package hospital;

import java.util.LinkedList;
import java.util.Scanner;

import static hospital.Islemler.hastaDurumuBul;

public class HastaneServisi {
    static Scanner scan = new Scanner(System.in);
    static Doktor doktor = new Doktor();
    static Hasta hasta = new Hasta();
    static LinkedList<Hasta> hastaListesi = new LinkedList<>();
    static LinkedList<Durum> hastaDurumListesi = new LinkedList<>();
    private static Hastane hastane2 = new Hastane();

    public static void ekle() {

        System.out.println("Eklemek istediginiz hastanin ADINI giriniz");
        String hastaAdi = scan.next();
        System.out.println("Eklemek istediginiz hastanin SOYADINI giriniz");
        String hastaSoyadi = scan.next();
        scan.nextLine();
        System.out.println("slm23.satir");
        int hastaId = 111;
        System.out.println("slm1");
        String  durum;
        boolean aciliyet;

        do {
            System.out.println("Hastanin Durumu:\n\t=> Allerji\n\t=> Bas agrisi\n\t=> Diabet\n\t=> Soguk alginligi\n\t=> Migren\n\t" +
                    "=> Kalp hastaliklari");
            durum = scan.nextLine().toLowerCase();


        } while (hastaDurumuBul(durum).getAktuelDurum().equalsIgnoreCase("Yanlis Durum"));
        aciliyet = hastaDurumuBul(durum).isAciliyet();
        System.out.println("slm2");
        Durum hastaDurum = new Durum(durum, aciliyet);
        Hasta hasta = new Hasta(hastaAdi, hastaSoyadi, hastaId, hastaDurum);
        hastaListesi.add(hasta);
        hastaDurumListesi.add(hastaDurum);
        //list();
        System.out.println("slm3");

    }

    public static Hasta hastaEkle() {


        return hasta;
    }
}
