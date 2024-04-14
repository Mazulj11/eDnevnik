package ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.services;

import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.models.User;
import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.models.UserDetails;
import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetails(user);
    }
}
