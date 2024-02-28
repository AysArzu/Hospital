package hospital;

public class Hastane extends VeriBankasi {
    Doktor doktor = new Doktor();
    Hasta hasta= new Hasta();
    public Hastane() {
    }

    public Hastane(Doktor doktor, Hasta hasta) {
        this.doktor = doktor;
        this.hasta = hasta;
    }
    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }



}
