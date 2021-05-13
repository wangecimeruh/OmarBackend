package omar.trial.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Products {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @ManyToMany
    List<Measurements> measurementsList;

    @OneToOne(mappedBy = "products")
    private CustomerOrders customerOrders;
}
