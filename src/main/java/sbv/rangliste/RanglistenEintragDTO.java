package sbv.rangliste;

import sbv.spieler.Spieler;

public class RanglistenEintragDTO {

    private Spieler spieler;
    private Integer platzierung1;
    private Integer platzierung2;
    private Integer platzierung3;

    private Integer punkte1;
    private Integer punkte2;
    private Integer punkte3;
    private Integer punkteGesamt;

    public Spieler getSpieler() {
        return spieler;
    }

    public RanglistenEintragDTO setSpieler(Spieler spieler) {
        this.spieler = spieler;
        return this;
    }

    public Integer getPlatzierung1() {
        return platzierung1;
    }

    public RanglistenEintragDTO setPlatzierung1(Integer platzierung1) {
        this.platzierung1 = platzierung1;
        return this;
    }

    public Integer getPlatzierung2() {
        return platzierung2;
    }

    public RanglistenEintragDTO setPlatzierung2(Integer platzierung2) {
        this.platzierung2 = platzierung2;
        return this;
    }

    public Integer getPlatzierung3() {
        return platzierung3;
    }

    public RanglistenEintragDTO setPlatzierung3(Integer platzierung3) {
        this.platzierung3 = platzierung3;
        return this;
    }

    public RanglistenEintragDTO setPlatzierungAndPunkte(int turnierNr, int platzierung, int punkte) {
        switch (turnierNr) {
            case 1:
                platzierung1 = platzierung;
                punkte1 = punkte;
                break;
            case 2:
                platzierung2 = platzierung;
                punkte2 = punkte;
                break;
            case 3:
                platzierung3 = platzierung;
                punkte3 = punkte;
                break;
            default:
                throw new IllegalArgumentException("Illegal tournament nr");
        }
        calculatePunkteGesamt();
        return this;
    }

    private void calculatePunkteGesamt() {
        punkteGesamt = punkte1;
        punkteGesamt = punkteGesamt == null ? punkte2 : (punkte2 == null ? punkteGesamt : new Integer(punkteGesamt.intValue() + punkte2)); //punkteGesamt + punkte2);
        punkteGesamt = punkteGesamt == null ? punkte3 : (punkte3 == null ? punkteGesamt : new Integer(punkteGesamt.intValue() + punkte3));
    }

    public Integer getPunkte1() {
        return punkte1;
    }

    public RanglistenEintragDTO setPunkte1(Integer punkte1) {
        this.punkte1 = punkte1;
        calculatePunkteGesamt();
        return this;
    }

    public Integer getPunkte2() {
        return punkte2;
    }

    public RanglistenEintragDTO setPunkte2(Integer punkte2) {
        this.punkte2 = punkte2;
        calculatePunkteGesamt();
        return this;
    }

    public Integer getPunkte3() {
        return punkte3;
    }

    public RanglistenEintragDTO setPunkte3(Integer punkte3) {
        this.punkte3 = punkte3;
        calculatePunkteGesamt();
        return this;
    }

    public Integer getPunkteGesamt() {
        return punkteGesamt;
    }

    @Override
    public String toString() {
        return "RanglistenEintragDTO{" +
                "spieler=" + spieler.getVorname() + " " + spieler.getName() +
                ", punkte1=" + punkte1 +
                ", punkte2=" + punkte2 +
                ", punkte3=" + punkte3 +
                ", punkteGesamt=" + punkteGesamt +
                '}';
    }
}
