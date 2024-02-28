package hospital;

import static hospital.HastaneRunner.slowPrint;
import static hospital.HastaneRunner.start;
import static hospital.HastaneServisi.scan;
import static hospital.Islemler.*;

public class HastaServisi {

    public static void menu() throws InterruptedException {

        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-HASTA EKLE\n\t=> 2-HASTALARI LISTELE\n\t" +
                    "=> 3-HASTA BUL\n\t=> 4-HASTA SIL\n\t=> 5-HASTA DURUMU LISTELE\n\t=> 6-ANA MENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    //add();
                    break;
                case 2:
                    hastalariListele();

                    Thread.sleep(3000);
                    break;
                case 3:
                    System.out.println("BULMAK İSTEDİĞİNİZ HASTANIN DURUMUNU GİRİNİZ...");
                    String durum = scan.next();
                    hastaBul(durum);
                    break;
                case 4:
                    //
                    break;
                case 5:
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
