package kg.ItAcademy.HomeWork76.repos;

import kg.ItAcademy.HomeWork76.enttities.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepo extends JpaRepository<Confirmation, Long> {

}
