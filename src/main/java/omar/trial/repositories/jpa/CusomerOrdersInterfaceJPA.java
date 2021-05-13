package omar.trial.repositories.jpa;

import omar.trial.entities.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CusomerOrdersInterfaceJPA extends JpaRepository<CustomerOrders, UUID> {
}
