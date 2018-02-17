package sbv.meldung;

import sbv.spieler.Spieler;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "doppel")
public class DoppelMeldung extends Meldung {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id", nullable = false)
    public Spieler partner;

    public Spieler getPartner() {
        return partner;
    }

    public DoppelMeldung setPartner(Spieler partner) {
        this.partner = partner;
        return this;
    }

    @Override
    public String toString() {
        return "DoppelMeldung{" +
                "diszipling=" + getDisziplin() +
                "turnier=" + getTurnier().getName() +
                "spieler=" + getSpieler().getVorname() + " " + getSpieler().getName() +
                "partner=" + partner.getVorname() + " " + partner.getName() +
                '}';
    }
}
