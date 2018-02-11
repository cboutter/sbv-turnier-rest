package sbv.turnier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TurnierController {

    private static final Logger logger = LogManager.getLogger(TurnierController.class);

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/turnier")
    public List<Turnier> turnier() {
        logger.debug("GET turnier called");
        return Arrays.asList(
                new Turnier().setId(counter.getAndIncrement()).setName("Test1"),
                new Turnier().setId(counter.getAndIncrement()).setName("Test2").setEndDate(LocalDate.of(2018, 02, 12)),
                new Turnier().setId(counter.getAndIncrement()).setName("Test3").setEndDate(LocalDate.of(2018, 02, 13)),
                new Turnier().setId(counter.getAndIncrement()).setName("Test4").setEndDate(LocalDate.of(2018, 02, 14)),
                new Turnier().setId(counter.getAndIncrement()).setName("Test5"),
                new Turnier().setId(counter.getAndIncrement()).setName("Test6"));
    }
}
