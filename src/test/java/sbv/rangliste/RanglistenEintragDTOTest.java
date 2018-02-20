package sbv.rangliste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sbv.spieler.Spieler;

public class RanglistenEintragDTOTest {

    private RanglistenEintragDTO dto;

    @Before
    public void setup() {
        dto = new RanglistenEintragDTO();
        dto.setSpieler(new Spieler().setName("Test"));
    }

    @Test
    public void calculatePunkteGesamtWithOnlyPunkte3() throws Exception {
        dto.setPlatzierungAndPunkte(3, 1, 1200);
        Assert.assertEquals(1200, (long) dto.getPunkteGesamt());
    }

    @Test
    public void calculatePunkteGesamtWithAll3Punkte() throws Exception {
        dto.setPlatzierungAndPunkte(3, 1, 1200);
        Assert.assertEquals(1200, (long) dto.getPunkteGesamt());

        dto.setPlatzierungAndPunkte(2, 1, 1000);
        Assert.assertEquals(2200, (long) dto.getPunkteGesamt());

        dto.setPlatzierungAndPunkte(1, 1, 1100);
        Assert.assertEquals(2300, (long) dto.getPunkteGesamt());
    }
}
