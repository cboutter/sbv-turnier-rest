package sbv.meldung;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbv.Disziplin;
import sbv.turnier.Turnier;
import sbv.turnier.TurnierRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MeldungController {

    private static final Logger logger = LogManager.getLogger(MeldungController.class);

    @Autowired
    private TurnierRepository turnierRepository;

    @Autowired
    private MeldungRepository meldungRepository;

    @RequestMapping("/meldung/{disz}/{turnier}")
    public List<Meldung> meldungByTurnierAndDisziplin(@PathVariable("turnier") long turnier_id,
                                                      @PathVariable("disz") String disz) {
        logger.debug("GET meldungen with turnier {} and disziplin {} called", turnier_id, disz);
        Turnier turnier = turnierRepository.findOne(turnier_id);

        Disziplin disziplin = Disziplin.valueOf(disz);

        return meldungRepository.findByTurnierAndDisziplin(turnier, disziplin);
    }
}
