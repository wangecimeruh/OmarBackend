package omar.trial.repositories.jpa;

import omar.trial.entities.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeasurementsInterfaceJPA extends JpaRepository<Measurements, UUID> {
}
