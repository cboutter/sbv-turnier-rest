package sbv.meldung;

import org.springframework.data.repository.CrudRepository;
import sbv.Disziplin;
import sbv.turnier.Turnier;

import java.util.List;

public interface MeldungRepository extends CrudRepository<Meldung, Long> {

    List<Meldung> findByTurnierAndDisziplin(Turnier turnier, Disziplin disziplin);
}
