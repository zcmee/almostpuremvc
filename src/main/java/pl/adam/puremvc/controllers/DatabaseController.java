package pl.adam.puremvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.adam.puremvc.entities.User;
import pl.adam.puremvc.respositories.UserRespository;

import java.util.List;

/**
 * Created by SkyNET on 2017-11-12.
 */

@RestController
@RequestMapping("databse")
public class DatabaseController {

    private static final Logger log = LoggerFactory.getLogger(DatabaseController.class);

    private final UserRespository userRespository;

    public DatabaseController(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @GetMapping("adduser")
    public User addUser() {
        log.info("elo");
        User user = new User(12, "Tomasz", "Tercum");
        userRespository.save(user);
        return user;
    }

    @GetMapping("getuser")
    public List<User> getUser() {
        List<User> users = userRespository.findAll();
        return users;
    }

    @GetMapping("sortedbyfirstname")
    public List<User> getsortedByUserByFirstName() {
        List<User> users = userRespository.findAll(new Sort(Sort.Direction.ASC, "firstName"));
        return users;
    }

    @GetMapping("sortedbylastname")
    public List<User> getsortedUserByLastName() {
        List<User> users = userRespository.findAll(new Sort(Sort.Direction.ASC, "lastName"));
        return users;
    }

    @GetMapping("sortedbyfirstnameandlastname")
    public List<User> getsortedBUserByLastName() {
        List<User> users = userRespository.findAll(new Sort(
                                                        new Sort.Order(Sort.Direction.ASC, "firstName"),
                                                        new Sort.Order(Sort.Direction.ASC, "lastName")
                                                    ));
        return users;
    }

    @GetMapping("sortedpagination/{page}")
    public List<User> sortedpagination(@PathVariable Integer page) {
        Page<User> pageOfUsers = userRespository.findAll(new PageRequest(page, 2));
        return pageOfUsers.getContent();
    }

}