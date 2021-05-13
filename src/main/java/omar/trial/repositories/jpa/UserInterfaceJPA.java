package omar.trial.repositories.jpa;

import omar.trial.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterfaceJPA extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserName(String userName);
    Users findByPhoneNumber(String phoneNumber);


}
