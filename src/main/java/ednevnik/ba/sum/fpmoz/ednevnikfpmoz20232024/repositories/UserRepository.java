package ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.repositories;

import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}