package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import web.entity.User;
import web.service.UserService;

/**
 * Created by Julia on 06.03.2017.
 */
@Controller
@RequestMapping(value = "/")
@SessionAttributes(types = User.class)
public class LogInClientController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        model.addAttribute(new User());
        System.out.println("------------> index");
        return "index";
    }
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    private String client(@RequestParam("login") String login,
            @RequestParam("password") String password) {
        if (service.auth(login, password)) {
            return "client";
        }
        return "index";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private String registry(
            /*@RequestParam("login") String login,
            @RequestParam("password") String password*/) {
        return "registry";
    }
    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    private String eee(@RequestParam("login") String login,
                       @RequestParam("password") String password,
                       @RequestParam("name") String name,
                       @RequestParam("surname") String surname,
                       @RequestParam("phone") Integer phone,
                       @RequestParam("email") String email,
                       @RequestParam("address") String address) {
        User user = new User(login, password, name, surname, phone, email, address);
        if (service.isCreatedUser(user)) {
            //такий у базі уже є
            return "index";
        }
        service.add(user);
        return "client";
    }
}
