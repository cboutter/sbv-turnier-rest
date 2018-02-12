package sbv.turnier;

import java.time.LocalDate;

public class Turnier {

    private long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate registerEndDate;

    public long getId() {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public Turnier setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Turnier setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public LocalDate getRegisterEndDate() {
        return registerEndDate;
    }

    public Turnier setRegisterEndDate(LocalDate registerEndDate) {
        this.registerEndDate = registerEndDate;
        return this;
    }


}
