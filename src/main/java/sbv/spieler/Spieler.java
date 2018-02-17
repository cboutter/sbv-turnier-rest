package sbv.spieler;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String spielerid;
    @Column(nullable = false)
    private String name;
    private String vorname;
    private Instant gebdatum;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;
    private String nat;

    private String clubid;
    private String clubname;

    public String getSpielerid() {
        return spielerid;
    }

    public Spieler setSpielerid(String spielerid) {
        this.spielerid = spielerid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Spieler setName(String name) {
        this.name = name;
        return this;
    }

    public String getVorname() {
        return vorname;
    }

    public Spieler setVorname(String vorname) {
        this.vorname = vorname;
        return this;
    }

    public Instant getGebdatum() {
        return gebdatum;
    }

    public Spieler setGebdatum(Instant gebdatum) {
        this.gebdatum = gebdatum;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public Spieler setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public String getNat() {
        return nat;
    }

    public Spieler setNat(String nat) {
        this.nat = nat;
        return this;
    }

    public String getClubid() {
        return clubid;
    }

    public Spieler setClubid(String clubid) {
        this.clubid = clubid;
        return this;
    }

    public String getClubname() {
        return clubname;
    }

    public Spieler setClubname(String clubname) {
        this.clubname = clubname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spieler spieler = (Spieler) o;

        if (id != spieler.id) return false;
        if (!spielerid.equals(spieler.spielerid)) return false;
        if (!name.equals(spieler.name)) return false;
        if (vorname != null ? !vorname.equals(spieler.vorname) : spieler.vorname != null) return false;
        if (gebdatum != null ? !gebdatum.equals(spieler.gebdatum) : spieler.gebdatum != null) return false;
        if (sex != spieler.sex) return false;
        if (nat != null ? !nat.equals(spieler.nat) : spieler.nat != null) return false;
        if (clubid != null ? !clubid.equals(spieler.clubid) : spieler.clubid != null) return false;
        return clubname != null ? clubname.equals(spieler.clubname) : spieler.clubname == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + spielerid.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "spielerid='" + spielerid + '\'' +
                ", name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                ", gebdatum=" + gebdatum +
                ", sex=" + sex +
                '}';
    }
}
