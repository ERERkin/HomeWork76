package kg.ItAcademy.HomeWork76.repos;

import kg.ItAcademy.HomeWork76.enttities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}
