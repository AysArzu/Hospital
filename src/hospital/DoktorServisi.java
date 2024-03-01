package hospital;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import static hospital.HastaneServisi.*;
import static hospital.Islemler.hastaBul;
import static hospital.Islemler.hastalariListele;


public class DoktorServisi {
    static LinkedList<Doktor> doktorList = new LinkedList<>();

    public static void doktorGirisiMenu() throws InterruptedException, IOException {

        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTORLARI LISTELE\n\t" +
                    "=> 2-UNVANDAN DOKTOR BULMA\n\t=> 3-HASTA BULMA\n\t=> 4-HASTALARI LISTELE \n\t=>0-ANAMENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();//dummy
            } catch (Exception e) {

                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    doktorlariListele(); //
                    break;
                case 2:
                    unvandanDoktorBul();
                    break;
                case 3:
                    System.out.println("BULMAK İSTEDİĞİNİZ HASTANIN DURUMUNU GİRİNİZ...");
                    String durum = scan.nextLine().trim();
                    //System.out.println(hastaBul(durum));
                    durumdanHastalariListele(durum);
                    break;
                case 4:
                    hastalariListele();
                    //
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



    public static void doktoruSil() {
        doktorlariListele();
        Scanner scan = new Scanner(System.in);
        System.out.println("Silmek istediginiz doktor ismini giriniz");
        String doktorName = scan.nextLine().trim();
        System.out.println("Silmek istediginiz doktor soyadini giriniz");
        String doktorSurname = scan.nextLine().trim();
        //System.out.println(doktorList);

        boolean isDeleted = false;
        for (Doktor w : doktorList) {
            if (w.getIsim().equalsIgnoreCase(doktorName) && w.getSoyisim().equalsIgnoreCase(doktorSurname)) {
                doktorList.remove(w);
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("SİLMEK İSTEDİGİNİZ DOKTOR LİSTEMİZDE BULUNMAMAKTADIR");
        }
        doktorlariListele();
    }

    public static void unvandanDoktorBul() {
        System.out.println("Bulmak Istediginiz Doktorun Unvanini Giriniz:\n\t=> Allergist\n\t=> Norolog\n\t" +
                "=> Genel Cerrah\n\t=> Cocuk Doktoru\n\t=> Dahiliye Uzmanı\n\t=> Kardiolog");
        //scan.nextLine();
        String unvan = scan.nextLine();

        System.out.println("------------------------------------------------------");
        System.out.println("---------- HASTANEDE BULUNAN DOKTORLARİMİZ -----------");
        System.out.printf("%-13s | %-15s | %-15s\n", "DOKTOR İSİM", "DOKTOR SOYİSİM", "DOKTOR UNVAN");
        System.out.println("------------------------------------------------------");
        boolean varMi = false;

        for (Doktor w : doktorList) {
            if (w.getUnvan().equalsIgnoreCase(unvan)) {
                System.out.printf("%-13s | %-15s | %-15s\n", w.getIsim(), w.getSoyisim(), w.getUnvan());
                varMi = true;
            }
        }
        if (!varMi) {
            System.out.println("BU UNVANA AİT DOKTOR BULUNMAMAKTADIR");
            slowPrint("\033[39mANAMENU'YE YONLENDIRILIYORSUNUZ...\033[0m\n", 20);
        }
        System.out.println("------------------------------------------------------");

    }

    public static void doktorlariListele () {
        System.out.println("------------------------------------------------------");
        System.out.println("---------- HASTANEDE BULUNAN DOKTORLARİMİZ -----------");
        System.out.printf("%-13s | %-15s | %-15s\n", "DOKTOR İSİM", "DOKTOR SOYİSİM", "DOKTOR UNVAN");
        System.out.println("------------------------------------------------------");
        for (Doktor w : doktorList) {
            System.out.printf("%-13s | %-15s | %-15s\n", w.getIsim(), w.getSoyisim(), w.getUnvan());
        }
    }

    public static Doktor doktorBul(String unvan){
        Doktor doktor = new Doktor();
        for (int i = 0; i < VeriBankasi.unvanlar.size(); i++) {
            if (VeriBankasi.unvanlar.get(i).equals(unvan)) {
                doktor.setIsim(VeriBankasi.doctorIsimleri.get(i));
                doktor.setSoyisim(VeriBankasi.doctorSoyIsimleri.get(i));
                doktor.setUnvan(VeriBankasi.unvanlar.get(i));
                break;
            }
        }
        return doktor;
    }

    //Bu classta olusturdugumuz bos listeyi doldurmaya yariyor.
    public static void firstList () {
        for (String w : VeriBankasi.unvanlar) {
            doktorList.add(doktorBul(w));
        }
    }


}