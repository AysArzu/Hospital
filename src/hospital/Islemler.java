package hospital;

public class Islemler {
    private static Hastane hastane = new Hastane();

    public static String doktorUnvan(String aktuelDurum) {
        String unvan = "Yanlis Unvan";
        for (int i = 0; i < hastane.durumlar.length; i++) {
            if (aktuelDurum.equalsIgnoreCase(hastane.durumlar[i])) {
                unvan = hastane.unvanlar[i];

            }
        }
        return unvan;
    }

    public static Doktor doktorBul(String unvan) {
        Doktor doktor = new Doktor();
        for (int i = 0; i < hastane.doctorIsimleri.length; i++) {
            if (unvan.equalsIgnoreCase(hastane.unvanlar[i])) {
                doktor.setIsim(hastane.doctorIsimleri[i]);
                doktor.setSoyisim(hastane.doctorSoyIsimleri[i]);
                doktor.setUnvan(hastane.unvanlar[i]);


            }

        }
        System.out.println(doktor);
        return doktor;
    }

    public static Durum hastaDurumuBul(String aktuelDurum) {
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
        for (int i = 0; i < hastane.hastaIsimleri.length; i++) {
            if (aktuelDurum.equalsIgnoreCase(hastane.durumlar[i])) {

                hasta.setIsim(hastane.hastaIsimleri[i]);
                hasta.setSoyisim(hastane.hastaSoyIsimleri[i]);
                hasta.setHastaID(hastane.hastaIDleri[i]);
                hasta.setHastaDurumu(hastaDurumuBul(aktuelDurum));

            }
        }
        System.out.println(hasta);

        return hasta;
    }

    public static void doktorlariListele() {
        System.out.println("------------------------------------------------------");
        System.out.println("---------- HASTANEDE BULUNAN DOKTORLARIMIZ -----------");
        System.out.printf("%-13s | %-15s | %-15s\n", "DOKTOR İSİM", "DOKTOR SOYİSİM", "DOKTOR UNVAN");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < hastane.doctorIsimleri.length; i++) {
            System.out.printf("%-13s | %-15s | %-15s\n", hastane.doctorIsimleri[i], hastane.doctorSoyIsimleri[i], hastane.unvanlar[i]);
        }
        System.out.println("------------------------------------------------------");
    }

    public static void hastalariListele() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("----------------------- HASTANEDE BULUNAN HASTALARIMIZ --------------------");
        System.out.printf("%-10s | %-10s | %-15s | %-20s\n", "HASTA ID", "HASTA ISIM", "HASTA SOYISIM", "HASTA DURUM");
        System.out.println("---------------------------------------------------------------------------");

        for (int i = 0; i < hastane.hastaIsimleri.length; i++) {
            System.out.printf("%-10s | %-10s | %-15s | %-20s\n", hastane.hastaIDleri[i],hastane.hastaIsimleri[i],hastane.hastaSoyIsimleri[i], hastane.durumlar[i]);

        }
        System.out.println("---------------------------------------------------------------------------");
    }


}
