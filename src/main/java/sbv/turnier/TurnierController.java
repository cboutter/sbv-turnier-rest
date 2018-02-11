package sbv.turnier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TurnierController {

    private static final Logger logger = LogManager.getLogger(TurnierController.class);

    @Autowired
    private TurnierDao turnierDao;

    @RequestMapping("/turnier")
    public List<Turnier> turnier() {
        logger.debug("GET turnier called");
        return turnierDao.findAll();
    }

    @RequestMapping("/turnier/{id}")
    public Turnier turnierById(@PathVariable("id") long id) {
        logger.debug("GET turnier with id {} called", id);
        return turnierDao.findById(id);
    }
}
