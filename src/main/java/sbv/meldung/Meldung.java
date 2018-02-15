package sbv.meldung;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sbv.Disziplin;
import sbv.turnier.Turnier;

import javax.persistence.*;
import java.time.Instant;

@Entity
@DiscriminatorColumn(name = "MELDUNG_TYPE")
public abstract class Meldung {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "turnier_id")
    private Turnier turnier;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Disziplin disziplin;

    private Integer endPlatzierung;


    private Instant meldeDatum;
    private Instant abmeldeDatum;
    @Enumerated(EnumType.STRING)
    private MeldeStatus status;

    public Turnier getTurnier() {
        return turnier;
    }

    public Meldung setTurnier(Turnier turnier) {
        this.turnier = turnier;
        return this;
    }

    public Disziplin getDisziplin() {
        return disziplin;
    }

    public Meldung setDisziplin(Disziplin disziplin) {
        this.disziplin = disziplin;
        return this;
    }

    public Instant getMeldeDatum() {
        return meldeDatum;
    }

    public Meldung setMeldeDatum(Instant meldeDatum) {
        this.meldeDatum = meldeDatum;
        return this;
    }

    public long getId() {
        return id;
    }

    public Meldung setId(long id) {
        this.id = id;
        return this;
    }

    public Instant getAbmeldeDatum() {
        return abmeldeDatum;
    }

    public Meldung setAbmeldeDatum(Instant abmeldeDatum) {
        this.abmeldeDatum = abmeldeDatum;
        return this;
    }

    public MeldeStatus getStatus() {
        return status;
    }

    public Meldung setStatus(MeldeStatus status) {
        this.status = status;
        return this;
    }

    public Integer getEndPlatzierung() {
        return endPlatzierung;
    }

    public Meldung setEndPlatzierung(Integer endPlatzierung) {
        this.endPlatzierung = endPlatzierung;
        return this;
    }
}
