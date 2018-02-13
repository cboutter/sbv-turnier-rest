package sbv.turnier;

import java.time.Instant;

public class Turnier {

    private Long id;
    private String name;
    private Instant startDate;
    private Instant endDate;
    private Instant registerEndDate;

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
}
