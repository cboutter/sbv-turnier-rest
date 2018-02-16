package sbv.meldung;

import sbv.spieler.Spieler;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "einzel")
public class EinzelMeldung extends Meldung {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "einzel_spieler_id")
    public Spieler spieler;

    public Spieler getSpieler() {
        return spieler;
    }

    public EinzelMeldung setSpieler(Spieler spieler) {
        this.spieler = spieler;
        return this;
    }

    @Override
    public String toString() {
        return "EinzelMeldung{" +
                "diszipling=" + getDisziplin() +
                "turnier=" + getTurnier().getName() +
                "spieler=" + spieler.getVorname() + " " + spieler.getName() +
                '}';
    }
}
