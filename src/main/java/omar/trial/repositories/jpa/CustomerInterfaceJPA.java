package omar.trial.repositories.jpa;

import omar.trial.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerInterfaceJPA extends JpaRepository<Customer, UUID> {

}
