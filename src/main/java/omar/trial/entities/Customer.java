package omar.trial.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @Id
    private UUID id;

    @Column(name = "NAME")
    private String customerName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

}
