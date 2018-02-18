package sbv.rangliste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbv.Disziplin;
import sbv.meldung.Meldung;
import sbv.meldung.MeldungRepository;
import sbv.spieler.Spieler;
import sbv.turnier.Turnier;
import sbv.turnier.TurnierRepository;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RanglistenController {

    @Autowired
    private TurnierRepository turnierRepository;

    @Autowired
    private MeldungRepository meldungRepository;

    private final RLComparator comparator = new RLComparator(RLComparator.SortOrder.DESCENDING);

    @RequestMapping("/rangliste/{disz}")
    public List<RanglistenEintragDTO> ranglisteByDisziplin(@PathVariable("disz") Disziplin disziplin) {
        List<Turnier> turniers = turnierRepository.findFirst3ByOrderByEndDateDesc();

        List<Meldung> meldungs = meldungRepository.findByDisziplinAndTurnierIn(disziplin, turniers);

        Map<Spieler, RanglistenEintragDTO> resultMap = new HashMap<>(meldungs.size());

        for (Meldung meldung : meldungs) {
            final RanglistenEintragDTO rlEintrag;
            if (resultMap.containsKey(meldung.getSpieler())) {
                rlEintrag = resultMap.get(meldung.getSpieler());
            } else {
                rlEintrag = new RanglistenEintragDTO().setSpieler(meldung.getSpieler());
                resultMap.put(meldung.getSpieler(), rlEintrag);
            }

            rlEintrag.setPlatzierungAndPunkte(getTurnierNr(meldung.getTurnier(), turniers),
                    meldung.getEndPlatzierung(),
                    getPunkteForPlatzierung(meldung.getEndPlatzierung(), meldung.getTurnier().isSM()));
        }

        List<RanglistenEintragDTO> result = new ArrayList<>(resultMap.values());
        result.sort(comparator);
        return result;
    }

    private int getPunkteForPlatzierung(Integer platzierung, boolean sm) {
        // TODO muss noch ausimplementiert werden. Sehen wie die Punkte hinterlegt werden. Resources?
        return 0;
    }

    private int getTurnierNr(Turnier turnier, List<Turnier> turniers) {
        return 3 - turniers.indexOf(turnier);
    }

    private static class RLComparator implements Comparator<RanglistenEintragDTO> {

        public enum SortOrder {ASCENDING, DESCENDING}

        private SortOrder sortOrder;

        public RLComparator(SortOrder sortOrder) {
            this.sortOrder = sortOrder;
        }

        private Comparator<Integer> nullSafeIntegerComparator = Comparator.nullsFirst(Integer::compareTo);

        @Override
        public int compare(RanglistenEintragDTO o1, RanglistenEintragDTO o2) {
            final int result;
            int gesamtComp = nullSafeIntegerComparator.compare(o1.getPunkteGesamt(), o2.getPunkteGesamt());
            if (gesamtComp == 0) {
                int punkte3Comp = nullSafeIntegerComparator.compare(o1.getPunkte3(), o2.getPunkte3());
                if (punkte3Comp == 0) {
                    int punkte2Comp = nullSafeIntegerComparator.compare(o1.getPunkte2(), o2.getPunkte2());
                    if (punkte2Comp == 0) {
                        result = nullSafeIntegerComparator.compare(o1.getPunkte1(), o2.getPunkte1());
                    } else {
                        result = punkte2Comp;
                    }
                } else {
                    result = punkte3Comp;
                }
            } else {
                result = gesamtComp;
            }

            return (sortOrder == SortOrder.DESCENDING) ? result * (-1) : result;
        }
    }


}
