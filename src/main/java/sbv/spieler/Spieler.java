package sbv.spieler;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Spieler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String spielerid;
    @Column(nullable = false)
    private String name;
    private String vorname;
    private Instant gebdatum;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;
    private String nat;

    private String clubid;
    private String clubname;
}
