package sbv.turnier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TurnierController {

    private static final Logger logger = LogManager.getLogger(TurnierController.class);

    @Autowired
    private TurnierDao turnierDao;

    @Autowired
    private TurnierRepository turnierRepository;

    @RequestMapping(value = "/turnier", method = RequestMethod.GET)
    public List<Turnier> turnier() {
        logger.debug("GET turnier called");
        //return turnierDao.findAll();
        List<Turnier> result = new ArrayList<>();
        turnierRepository.findAll().forEach(result::add);
        return result;
    }

    @RequestMapping("/turnier/{id}")
    public Turnier turnierById(@PathVariable("id") long id) {
        logger.debug("GET turnier with id {} called", id);
        //return turnierDao.findById(id);
        return turnierRepository.findOne(id);
    }

    @RequestMapping(value = "/turnier", method = RequestMethod.POST)
    public Turnier turnier(@RequestBody Turnier toSave) {
        logger.debug("POST turnier called for {}", toSave);
        //return turnierDao.saveOrUpdate(toSave);
        return turnierRepository.save(toSave);
    }
}
