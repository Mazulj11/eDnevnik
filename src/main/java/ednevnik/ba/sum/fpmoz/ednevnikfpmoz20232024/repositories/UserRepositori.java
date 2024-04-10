package ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.repositories;

import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositori extends JpaRepository<User, Integer> {
}
