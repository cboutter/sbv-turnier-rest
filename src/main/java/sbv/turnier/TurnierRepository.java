package sbv.turnier;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TurnierRepository extends CrudRepository<Turnier, Long> {

    List<Turnier> findFirst3ByOrderByEndDateDesc();
}
