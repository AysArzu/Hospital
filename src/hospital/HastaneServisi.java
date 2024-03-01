package hospital;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import static hospital.DoktorServisi.*;
import static hospital.Islemler.hastaBul;
import static hospital.Islemler.hastaDurumuBul;

public class HastaneServisi {
    static Scanner scan = new Scanner(System.in);
    static Doktor doktor = new Doktor();
    static Hasta hasta = new Hasta();
    static LinkedList<Hasta> hastaListesi = new LinkedList<>();
    static LinkedList<Durum> hastaDurumListesi = new LinkedList<>();
    private static Hastane hastane2 = new Hastane();

    public static void hastaEkle() {
        System.out.println("Eklemek istediginiz hastanin ADINI giriniz");
        String hastaAdi = scan.nextLine().trim();
        System.out.println("Eklemek istediginiz hastanin SOYADINI giriniz");
        String hastaSoyadi = scan.nextLine().trim();
        int hastaId = hastaListesi.getLast().getHastaID() + 111;
        String  durum;
        boolean aciliyet;

        do {
            System.out.println("Hastanin Durumu:\n\t=> Allerji\n\t=> Bas agrisi\n\t=> Diabet\n\t=> Soguk alginligi\n\t=> Migren\n\t" +
                    "=> Kalp hastaliklari");
            durum = scan.nextLine().toLowerCase().trim();

        } while (hastaDurumuBul(durum).getAktuelDurum().equalsIgnoreCase("Yanlis Durum"));
        aciliyet = hastaDurumuBul(durum).isAciliyet();
        Durum hastaDurum = new Durum(durum, aciliyet);
        Hasta hasta = new Hasta(hastaAdi, hastaSoyadi, hastaId, hastaDurum);
        hastaListesi.add(hasta);
        hastaDurumListesi.add(hastaDurum);
        hastaListele();
    }


    public static void start() throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        //   slowPrint("******* TEAM-DEV2 HOSPİTAL *******\n********** HOŞGELDİNİZ **********\n\n", 60);

        System.out.println("Lütfen giriş yapmak istediğiniz menü kodunu giriniz..\n\n" +
                "1-HASTANE YÖNETİMİ GİRİŞİ\n" +
                "2-DOKTOR GİRİŞİ\n" +
                "3-HASTA GİRİŞİ\n" +
                "4-HASTANE KADROMUZ\n" +
                "5-ÇIKIŞ\n");
        int secim = scan.nextInt();


        switch (secim) {
            case 1:
                HastaneServisi.hastaneServisiMenu();
                break;
            case 2:
                DoktorServisi.doktorGirisiMenu();
                break;
            case 3:
                HastaServisi.hastaGirisiMenu();
                break;
            case 4:
                Islemler.iletisim();
                break;
            case 5:
                Islemler.cikis();
                break;
            default:
                System.out.println("HATALI GIRIS, TEKRAR DENEYINIZ!");
                //


        }

    }

    private static void hastaneServisiMenu() throws IOException, InterruptedException {
        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTOR EKLE\n\t=> 2-DOKTORLARI LISTELE\n\t" +
                    "=> 3-UNVANDAN DOKTOR BULMA\n\t=> 4-DOKTOR SIL\n\t=> 5-HASTA EKLE\n\t=> 6-HASTA BUL\n\t=>7-HASTA LISTELE\n\t=> 8-HASTA SIL\n\t=>0-ANAMENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();//dummy
            } catch (Exception e) {
//                scan.nextLine();//dummy
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    doktorEkle(); //
                    break;
                case 2:
                    doktorlariListele();
                    break;
                case 3:
                    unvandanDoktorBul();
                    break;
                case 4:
                    doktoruSil();
                    //
                    break;
                case 5:
                    hastaEkle();
                    break;
                case 6:
                    System.out.println("BULMAK İSTEDİĞİNİZ HASTANIN DURUMUNU GİRİNİZ...");
                    String durum = scan.nextLine().trim();
                    //System.out.println(hastaBul(durum));
                    durumdanHastalariListele(durum);
                    break;
                case 7:
                    hastaListele();
                    break;
                case 8:
                    hastaSil();
                    break;
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                    start();
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);
    }

    public static void doktorEkle() {
        // Doktor Ekleme Metodu
        System.out.println("Eklemek istediginiz doktor ismini giriniz");
        String doktorAdi = scan.nextLine();
        System.out.println("Eklemek istediginiz doktor soy ismini giriniz");
        String doktorSoyadi = scan.nextLine();
        System.out.println("Eklemek İstediginiz doktor Unvanini Giriniz: \n \t=> Allergist\n\t=> Norolog\n\t=> Genel Cerrah\n\t" +
                "=> Cocuk Doktoru\n\t=> Dahiliye\n\t=> Kardiolog");
        String doktorUnvan = scan.nextLine();
        Doktor doktor = new Doktor(doktorAdi, doktorSoyadi, doktorUnvan);
        doktorList.add(doktor);
        doktorlariListele();
        // Doktor objesini isterseniz bir listeye ekleyebilir veya başka bir şekilde saklayabiliriz

    }
    //hastasil
    public static void hastaSil() {
        hastaListele();
        boolean sildiMi = false;
        System.out.println("Silmek Istediginiz Hastanin Id sini giriniz.");
        int hastaId = 0;
        try {

            hastaId = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("GECERSİZ ID");
            hastaSil();
        }
        for (Hasta w : hastaListesi) {
            if (w.getHastaID() == hastaId) {
                sildiMi = true;
                hastaListesi.remove(w);
                break;
            }
        }
        if (!sildiMi) {
            System.out.println("SİLMEK İSTEDİGİNİZ HASTA LİSTEMİZDE BULUNMAMAKTADIR!");
        }
        hastaListele();
    }

    public static void hastaListele() {

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("----------------------- HASTANEDE BULUNAN HASTALARIMIZ --------------------");
        System.out.printf("%-10s | %-10s | %-15s | %-20s\n", "HASTA ID", "HASTA ISIM", "HASTA SOYISIM", "HASTA DURUM");
        System.out.println("---------------------------------------------------------------------------");
        for (Hasta w : hastaListesi) {
            System.out.printf("%-10s | %-10s | %-15s | %-20s\n", w.getHastaID(), w.getIsim(), w.getSoyisim(), w.getHastaDurumu(), w.getHastaDurumu().isAciliyet());
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    public static void durumdanHastalariListele(String aktuelDurum){
        for (Hasta w : hastaListesi) {
            if(w.getHastaDurumu().getAktuelDurum().equalsIgnoreCase(aktuelDurum)){
                System.out.printf("%-10s | %-10s | %-15s | %-20s\n", w.getHastaID(), w.getIsim(), w.getSoyisim(), w.getHastaDurumu(), w.getHastaDurumu().isAciliyet());
            }
        }
    }

    public static void slowPrint(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}