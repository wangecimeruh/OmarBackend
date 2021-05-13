package omar.trial.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Measurements {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Id
    private UUID id;
    @Column(name = "NAME")
    private String measurementName;

    @Column(name = "SYMBOL")
    private String symbol;





}
