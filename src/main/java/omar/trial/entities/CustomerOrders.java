package omar.trial.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class CustomerOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private  String description;
    private int totalPayment;
    private  int balance;
    private int deposit;
    private Date dayOfCollection;
    @ManyToOne
    private Customer customer;
    @OneToOne
    @JoinColumn
    Products products;

}
