package sbv.meldung;

import sbv.spieler.Spieler;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DoppelMeldung extends Meldung {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doppel_spieler1_id")
    public Spieler spieler1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doppel_spieler2_id")
    public Spieler spieler2;

    public Spieler getSpieler1() {
        return spieler1;
    }

    public DoppelMeldung setSpieler1(Spieler spieler) {
        this.spieler1 = spieler;
        return this;
    }

    public Spieler getSpieler2() {
        return spieler2;
    }

    public DoppelMeldung setSpieler2(Spieler spieler2) {
        this.spieler2 = spieler2;
        return this;
    }

    @Override
    public String toString() {
        return "DoppelMeldung{" +
                "diszipling=" + getDisziplin() +
                "turnier=" + getTurnier().getName() +
                "spieler1=" + spieler1.getVorname() + " " + spieler1.getName() +
                "spieler2=" + spieler2.getVorname() + " " + spieler2.getName() +
                '}';
    }
}
