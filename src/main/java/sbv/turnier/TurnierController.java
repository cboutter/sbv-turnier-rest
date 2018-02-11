package sbv.turnier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TurnierController {

    private static final Logger logger = LogManager.getLogger(TurnierController.class);

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/turnier")
    public List<Turnier> turnier() {
        logger.debug("GET turnier called");
        return Arrays.asList(
                new Turnier().setId(counter.getAndIncrement()).setName("Test1"),
                new Turnier().setId(counter.getAndIncrement()).setName("Test2"));
    }
}
