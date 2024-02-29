package hospital;

import java.io.IOException;
import java.util.Scanner;

import static hospital.HastaneRunner.slowPrint;
import static hospital.HastaneRunner.start;
import static hospital.HastaneServisi.scan;
import static hospital.Islemler.*;

public class DoktorServisi {

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
                   // ekle();
                    break;
                case 2:
                    doktorlariListele();
                    break;
                case 3:
                    System.out.println("Unvani giriniz");
                    String unvan = scan.next();
                    doktorBul(unvan);
                    break;
                case 4:
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
}
