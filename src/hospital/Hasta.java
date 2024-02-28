package hospital;

public class Hasta {
    private String isim;
    private String soyisim;
    private int hastaID;
    private Durum hastaDurumu;

    public Hasta() {
    }

    public Hasta(String isim, String soyisim, int hastaID, Durum hastaDurumu) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.hastaID = hastaID;
        this.hastaDurumu = hastaDurumu;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getHastaID() {
        return hastaID;
    }

    public void setHastaID(int hastaID) {
        this.hastaID = hastaID;
    }

    public Durum getHastaDurumu() {
        return hastaDurumu;
    }

    public void setHastaDurumu(Durum hastaDurumu) {
        this.hastaDurumu = hastaDurumu;
    }

    @Override
    public String toString() {
        return "Hasta{" +
                "isim='" + isim + '\'' +
                ", soyisim='" + soyisim + '\'' +
                ", hastaID=" + hastaID +
                ", hastaDurumu=" + hastaDurumu +
                '}';
    }

}
