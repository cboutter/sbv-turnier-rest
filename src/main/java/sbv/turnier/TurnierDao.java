package sbv.turnier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
@Repository
public class TurnierDao {

    private static final Logger logger = LogManager.getLogger(TurnierDao.class);

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
        if (toSave.getId() == null || toSave.getId() < 0) {
            toSave.setId(counter.getAndIncrement());
            logger.debug("setting id of turnier to {}", toSave.getId());
        }
        turnierDb.put(toSave.getId(), toSave);
        logger.debug("Saved {}", toSave);
        return toSave;
    }
}
