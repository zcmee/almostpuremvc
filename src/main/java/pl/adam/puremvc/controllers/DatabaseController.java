package pl.adam.puremvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.adam.puremvc.entities.User;
import pl.adam.puremvc.respositories.UserRespository;

import java.util.Collections;
import java.util.List;

/**
 * Created by SkyNET on 2017-11-12.
 */

@RestController
@RequestMapping("databse")
public class DatabaseController {
    private final UserRespository userRespository;

    public DatabaseController(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @GetMapping("adduser")
    public User addUser() {
        User user = new User(12, "Tomasz", "Tercum");
        userRespository.save(user);
        return user;
    }

    @GetMapping("getuser")
    public List<User> getUser() {
        List<User> users = userRespository.findAll();
        return users;
    }

}