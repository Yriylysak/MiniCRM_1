package web.controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Julia on 06.03.2017.
 */
@Controller
@RequestMapping(value = "/")
@SessionAttributes(types = User.class)
public class LogInClientController {
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        model.addAttribute(new User());
        System.out.println("------------> index");
        return "index";
    }
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    private String client(
            /*@RequestParam("login") String login,
            @RequestParam("password") String password*/) {
        return "client";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private String registry(
            /*@RequestParam("login") String login,
            @RequestParam("password") String password*/) {
        return "registry";
    }
}
