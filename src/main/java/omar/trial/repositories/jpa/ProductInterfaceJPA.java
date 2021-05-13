package omar.trial.repositories.jpa;

import omar.trial.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductInterfaceJPA extends JpaRepository<Products, UUID> {
}
