package ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.controlleres;

import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.models.User;
import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }


    @GetMapping("/")
    public String index() {
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @PostMapping("/user")
    public String addUser(User user) {
        userRepository.save(user);
        return "redirect:/user";
    }
}
