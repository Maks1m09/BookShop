package by.tms.bookshop.controller;

import by.tms.bookshop.entity.Role;
import by.tms.bookshop.entity.User;
import by.tms.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Collections;
import java.util.Map;


@Controller
public class RegistrationUser {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "/registration";
    }

//    @PostMapping("/registration")
//    public String addUser(@RequestParam String name, @RequestParam String login, @RequestParam String password,Model model) {
//      User user = new User(name, login, password);
//      userService.saveUser(user);
//      model.addAttribute("user", user );
//      return "redirect:/login";
//    }

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        return "registration";
//    }
//
    @PostMapping("/registration")
    public String addUser(@RequestParam String name, @RequestParam String login, @RequestParam String password, Model model, Map<String, Object> mod ) {
        User user = new User(name, login, password);
        if (userService.findUserByLogin(user.getName())!=null){
            mod.put("message", "User exists!");
            return "registration";
        }
        userService.saveUser(user);
        user.setRoles(Collections.singleton(Role.USER_ROLE));
        return "redirect:/login";
    }

}
