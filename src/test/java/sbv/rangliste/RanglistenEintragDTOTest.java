package sbv.rangliste;

import org.junit.Assert;
import org.junit.Test;
import sbv.spieler.Spieler;

public class RanglistenEintragDTOTest {

    @Test
    public void calculatePunkteGesamtWithOnlyPunkte3() throws Exception {
        RanglistenEintragDTO dto = new RanglistenEintragDTO();
        dto.setSpieler(new Spieler().setName("Test"));

        dto.setPlatzierungAndPunkte(3, 1, 0);

        Assert.assertEquals(0, (long) dto.getPunkteGesamt());
    }
}
