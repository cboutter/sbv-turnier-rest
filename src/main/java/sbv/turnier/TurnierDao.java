package sbv.turnier;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TurnierDao {

    private final AtomicLong counter = new AtomicLong();

    private Map<Long, Turnier> turnierDb = new HashMap<>();

    public TurnierDao() {
        turnierDb.put(counter.get(), new Turnier().setId(counter.getAndIncrement()).setName("Test1"));
        turnierDb.put(counter.get(), new Turnier().setId(counter.getAndIncrement()).setName("Test2")
                .setEndDate(LocalDate.parse("2018-02-12").atStartOfDay().toInstant(ZoneOffset.UTC)));
        turnierDb.put(counter.get(), new Turnier().setId(counter.getAndIncrement()).setName("Test3")
                .setStartDate(LocalDate.parse("2018-02-13").atStartOfDay().toInstant(ZoneOffset.UTC))
                .setEndDate(LocalDate.parse("2018-02-13").atStartOfDay().toInstant(ZoneOffset.UTC))
                .setRegisterEndDate(LocalDate.parse("2018-02-12").atStartOfDay().toInstant(ZoneOffset.UTC)));
        turnierDb.put(counter.get(), new Turnier().setId(counter.getAndIncrement()).setName("Test4")
                .setEndDate(LocalDate.parse("2018-02-14").atStartOfDay().toInstant(ZoneOffset.UTC)));
        turnierDb.put(counter.get(), new Turnier().setId(counter.getAndIncrement()).setName("Test5"));
        turnierDb.put(counter.get(), new Turnier().setId(counter.getAndIncrement()).setName("Test6"));
    }

    public List<Turnier> findAll() {
        return new ArrayList<>(turnierDb.values());
    }

    public Turnier findById(long id) {
        return turnierDb.get(id);
    }

    public Turnier saveOrUpdate(Turnier toSave) {
        if (toSave.getId() == null) {
            toSave.setId(counter.getAndIncrement());
        }
        turnierDb.put(toSave.getId(), toSave);
        return toSave;
    }
}
