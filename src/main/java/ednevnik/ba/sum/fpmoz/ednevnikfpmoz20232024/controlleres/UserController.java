package ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.controlleres;

import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.models.User;
import ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.repositories.UserRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepositori userRepositori;

    @GetMapping("/")
    public String index() {
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("users", userRepositori.findAll());
        return "user";
    }

    @PostMapping("/user")
    public String addUser(User user) {
        userRepositori.save(user);
        return "redirect:/user";
    }
}
