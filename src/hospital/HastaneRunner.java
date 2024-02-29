package hospital;

import java.io.IOException;
import java.util.Scanner;

public class HastaneRunner {


    public static void main(String[] args) throws InterruptedException, IOException {
        // System.out.println(Islemler.doktorBul("Norolog"));

        start();

    }

    public static void start() throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);
        //   slowPrint("******* TEAM-DEV2 HOSPİTAL *******\n********** HOŞGELDİNİZ **********\n\n", 60);

        System.out.println("Lütfen giriş yapmak istediğiniz menü kodunu giriniz..\n\n" +
                "1-HASTANE YÖNETİMİ\n" +
                "2-DOKTOR MENÜSÜ\n" +
                "3-HASTA MENÜSÜ\n" +
                "4-HASTANE KADROMUZ\n" +
                "5-ÇIKIŞ");
        int secim = scan.nextInt();

        switch (secim) {
            case 1:
                HastaneServisi.ekle();
                break;
            case 2:
                DoktorServisi.menu();
                break;
            case 3:
                HastaServisi.menu();
                break;
            case 4:
                Islemler.iletisim();
                break;
            case 5:
                Islemler.cikis();
                break;

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