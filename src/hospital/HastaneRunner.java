package hospital;

import java.util.Scanner;

public class HastaneRunner {


    public static void main(String[] args) throws InterruptedException {
        // System.out.println(Islemler.doktorBul("Norolog"));

        start();

    }

    public static void start() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        //   slowPrint("******* TEAM-DEV2 HOSPİTAL *******\n********** HOŞGELDİNİZ **********\n\n", 60);

        System.out.println("Lütfen giriş yapmak istediğiniz menü kodunu giriniz..\n\n" +
                "1-DOKTOR MENÜSÜ\n" +
                "2-HASTA MENÜSÜ\n" +
                "3-HASTANE KADROMUZ\n" +
                "4-HASTANEMİZ DOKTORLARINI GÖRÜNTÜLE\n" +
                "5-ÇIKIŞ");
        int secim = scan.nextInt();

        switch (secim) {
            case 1:
                DoktorServisi.menu();
                break;
            case 2:
                HastaServisi.menu();
                break;
            case 3:

                break;
            case 4:
                Islemler.doktorlariListele();
                break;
            case 5:

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