package hospital;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import static hospital.HastaneRunner.slowPrint;
import static hospital.HastaneRunner.start;
import static hospital.HastaneServisi.scan;
import static hospital.Islemler.*;

public class DoktorServisi {

    static LinkedList<Doktor> doktorList = new LinkedList<>();

    public static void menu() throws InterruptedException, IOException {

        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTOR EKLE\n\t=> 2-DOKTORLARI LISTELE\n\t" +
                    "=> 3-UNVANDAN DOKTOR BULMA\n\t=> 4-DOKTOR SIL\n\t=> 0-ANAMENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();//dummy
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
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                    start();
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);

    }

    private static void unvandanDoktorBul() {

    }

    public static void doktorEkle() {
        // Doktor Ekleme Metodu
        System.out.println("Eklemek istediginiz doktor ismini giriniz");
        String doktorAdi = scan.next();
        System.out.println("Eklemek istediginiz doktor soy ismini giriniz");
        String doktorSoyadi = scan.next();
        System.out.println("Eklemek İstediginiz doktor Unvanini Giriniz: \n \t=> Allergist\n\t=> Norolog\n\t=> Genel Cerrah\n\t" +
                "=> Cocuk Doktoru\n\t=> Dahiliye\n\t=> Kardiolog");
        String doktorUnvan = scan.next();
        Doktor doktor = new Doktor(doktorAdi, doktorSoyadi, doktorUnvan);
        doktorList.add(doktor);
        doktorlariListele();
        // Doktor objesini isterseniz bir listeye ekleyebilir veya başka bir şekilde saklayabiliriz

    }

    public static void doktoruSil() {
        doktorlariListele();
        Scanner scan = new Scanner(System.in);
        System.out.println("Silmek istediginiz doktor ismini giriniz");
        String doktorName = scan.next();
        System.out.println("Silmek istediginiz doktor soyadini giriniz");
        String doktorSurname = scan.next();
        System.out.println(doktorList);

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
}
