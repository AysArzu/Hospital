package hospital;

import java.io.IOException;

import static hospital.DoktorServisi.doktorlariListele;
import static hospital.DoktorServisi.unvandanDoktorBul;
import static hospital.HastaneServisi.*;
import static hospital.Islemler.*;

public class HastaServisi {

    public static void hastaGirisiMenu() throws InterruptedException, IOException {

        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTORLARI LİSTELE\n\t=> 2-DOKTOR BUL\n\t" +
                    "=> 3-HASTA BUL\n\t=> 0-ANA MENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    doktorlariListele();
                    break;
                case 2:
                    unvandanDoktorBul();
                    Thread.sleep(3000);
                    break;
                case 3:
                    System.out.println("DURUMUNUZU ÖĞRENMEK İÇİN HASTALIĞINIZI GİRİNİZ...");
                    String durum = scan.nextLine().trim();
                    System.out.println(hastaDurumuBul(durum));
                    break;
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                    HastaneServisi.start();
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);
    }
    public static void firstList() {
        for (String w : VeriBankasi.durumlar) {
            hastaListesi.add(hastaBul(w));
            hastaDurumListesi.add(hastaDurumuBul(w.toLowerCase()));
        }


    }
}