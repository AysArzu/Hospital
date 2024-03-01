package hospital;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static hospital.HastaneServisi.scan;
import static hospital.HastaneServisi.start;

public class Islemler {
    private static Hastane hastane = new Hastane();

    public static String doktorUnvan(String aktuelDurum) {
        String unvan = "Yanlis Unvan";

        for (int i = 0; i < VeriBankasi.durumlar.size(); i++) {
            if (aktuelDurum.equalsIgnoreCase(VeriBankasi.durumlar.get(i))) {
                unvan = VeriBankasi.unvanlar.get(i);

            }
        }
        return unvan;
    }

    public static Doktor doktorBul(String unvan) {
        Doktor doktor = new Doktor();

        for (int i = 0; i < VeriBankasi.doctorIsimleri.size(); i++) {
            if (unvan.equalsIgnoreCase(VeriBankasi.unvanlar.get(i))) {
                doktor.setIsim(VeriBankasi.doctorIsimleri.get(i));
                doktor.setSoyisim(VeriBankasi.doctorSoyIsimleri.get(i));
                doktor.setUnvan(VeriBankasi.unvanlar.get(i));
            }
        }
        System.out.println(doktor);
        return doktor;
    }

    public static Durum hastaDurumuBul (String aktuelDurum){
        Durum hastaDurumu = new Durum("Yanlis Durum", false);
        switch (aktuelDurum.toLowerCase()) {
            case "allerji":
            case "bas agrisi":
            case "diabet":
            case "soguk alginligi":
                hastaDurumu.setAciliyet(false);
                hastaDurumu.setAktuelDurum(aktuelDurum);
                break;
            case "migren":
            case "kalp hastaliklari":
                hastaDurumu.setAciliyet(true);
                hastaDurumu.setAktuelDurum(aktuelDurum);

                break;
            default:
                System.out.println("Gecerli bir durum degil");

        }

        return hastaDurumu;
    }

    public static Hasta hastaBul(String aktuelDurum) {
        Hasta hasta = new Hasta();
        for (int i = 0; i < VeriBankasi.hastaIsimleri.size(); i++) {

            if (aktuelDurum.equalsIgnoreCase(VeriBankasi.durumlar.get(i))) {

                hasta.setIsim(VeriBankasi.hastaIsimleri.get(i));
                hasta.setSoyisim(VeriBankasi.hastaSoyIsimleri.get(i));
                hasta.setHastaID(VeriBankasi.hastaIDleri.get(i));
                hasta.setHastaDurumu(hastaDurumuBul(aktuelDurum));
            }
        }
        return hasta;
    }



    public static void hastalariListele () {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("----------------------- HASTANEDE BULUNAN HASTALARIMIZ --------------------");
        System.out.printf("%-10s | %-10s | %-15s | %-20s\n", "HASTA ID", "HASTA ISIM", "HASTA SOYISIM", "HASTA DURUM");
        System.out.println("---------------------------------------------------------------------------");

        for (int i = 0; i < hastane.hastaIsimleri.size(); i++) {
            System.out.printf("%-10s | %-10s | %-15s | %-20s\n", hastane.hastaIDleri.get(i),hastane.hastaIsimleri.get(i),
                    hastane.hastaSoyIsimleri.get(i), hastane.durumlar.get(i));

        }
        System.out.println("---------------------------------------------------------------------------");
    }    public static void iletisim() throws IOException, InterruptedException {
        Files.lines(Paths.get("src/hospital/Yonetim.txt")).forEach(System.out::println);

        start();
    }
    public static void cikis() {
        System.out.println("Hastanemizi tercih ettiğiniz için teşekkürler. \n\t"+"*".repeat(10)+" SAĞLICAKLA KALIN "+"*".repeat(10));

    }
}