package nl.hsleiden.eindappstudieplanner.model;

public class Studiepunten {
    private int jaar;
    private int punten;

    public Studiepunten(int jaar, int punten) {
        this.jaar = jaar;
        this.punten = punten;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }
}
