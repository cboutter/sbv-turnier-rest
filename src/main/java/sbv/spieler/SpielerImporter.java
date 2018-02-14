package sbv.spieler;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpielerImporter {

    private static final Logger logger = LogManager.getLogger(SpielerImporter.class);

    @Autowired
    private SpielerRepository spielerRepository;

    public void importSpieler() {
        Reader in = null;
        try {
            in = new InputStreamReader(this.getClass().getResourceAsStream("/players_20180213.csv"), Charset.forName("utf-8"));

            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            List<Spieler> imported = new ArrayList<>();
            for (CSVRecord record : records) {

                String spielerid = record.get("spielerid");
                if (spielerid != null && spielerid.startsWith("U-")) {
                    continue;
                }
                Spieler recordSpieler = new Spieler()
                        .setSpielerid(spielerid)
                        .setName(record.get("name"))
                        .setVorname(record.get("vorname"))
                        .setSex(Sex.valueOf(record.get("sex")))
                        .setNat(record.get("nat"))
                        .setClubid(record.get("clubid"))
                        .setClubname(record.get("clubname"));

                try {
                    recordSpieler.setGebdatum(new SimpleDateFormat("dd.MM.yyyy").parse(record.get("gebdatum")).toInstant());
                } catch (ParseException e) {
                    logger.error("Could not parse date of birth for {} ", record.get("vorname") + record.get("name"), e);
                }

                logger.debug("Imported Spieler {}", recordSpieler);

                imported.add(recordSpieler);
            }

            //spielerRepository.deleteAll();
            //spielerRepository.save(imported);

        } catch (IOException e) {
            logger.error(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
    }

}
