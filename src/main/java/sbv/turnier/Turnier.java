package sbv.turnier;

import sbv.meldung.Meldung;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turnier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Instant startDate;
    private Instant endDate;
    private Instant registerEndDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "turnier")
    public List<Meldung> meldungen;
    private boolean sm = false;

    public Long getId() {
        return id;
    }

    public Turnier setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Turnier setName(String name) {
        this.name = name;
        return this;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Turnier setStartDate(Instant startDate) {
        this.startDate = startDate;
        return this;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Turnier setEndDate(Instant endDate) {
        this.endDate = endDate;
        return this;
    }

    public Instant getRegisterEndDate() {
        return registerEndDate;
    }

    public Turnier setRegisterEndDate(Instant registerEndDate) {
        this.registerEndDate = registerEndDate;
        return this;
    }

    public List<Meldung> getMeldungen() {
        return meldungen;
    }

    public Turnier setMeldungen(List<Meldung> meldungen) {
        this.meldungen = meldungen;
        return this;
    }

    public void addMeldung(Meldung meldung) {
        if (meldungen == null) {
            meldungen = new ArrayList<>();
        }
        meldungen.add(meldung);
        meldung.setTurnier(this);
    }

    @Override
    public String toString() {
        return "Turnier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", registerEndDate=" + registerEndDate +
                '}';
    }

    public boolean isSM() {
        return sm;
    }

    public boolean isSm() {
        return sm;
    }

    public void setSm(boolean sm) {
        this.sm = sm;
    }
}
