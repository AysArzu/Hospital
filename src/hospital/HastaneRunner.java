package hospital;

import java.io.IOException;


import static hospital.HastaneServisi.start;

public class HastaneRunner {


    public static void main(String[] args) throws InterruptedException, IOException {
        // System.out.println(Islemler.doktorBul("Norolog"));
        DoktorServisi.firstList();
        HastaServisi.firstList();
        start();
    }


}