package nl.hsleiden.eindappstudieplanner.model;

public class Vak {

    private String name;
    private double cijfer;
    private boolean afgerond;
    private boolean verplicht;
    private int studiepunten;
    private String aantekeningen;
    private int jaar;

    public Vak(String name, double cijfer, boolean afgerond, boolean verplicht, int studiepunten, String aantekeningen, int jaar) {
        this.name = name;
        this.cijfer = cijfer;
        this.afgerond = afgerond;
        this.verplicht = verplicht;
        this.studiepunten = studiepunten;
        this.aantekeningen = aantekeningen;
        this.jaar = jaar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCijfer() {
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;
    }

    public boolean isAfgerond() {
        return afgerond;
    }

    public void setAfgerond(boolean afgerond) {
        this.afgerond = afgerond;
    }

    public boolean isVerplicht() {
        return verplicht;
    }

    public void setVerplicht(boolean verplicht) {
        this.verplicht = verplicht;
    }

    public int getStudiepunten() {
        return studiepunten;
    }

    public void setStudiepunten(int studiepunten) {
        this.studiepunten = studiepunten;
    }

    public String getAantekeningen() {
        return aantekeningen;
    }

    public void setAantekeningen(String aantekeningen) {
        this.aantekeningen = aantekeningen;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
}
