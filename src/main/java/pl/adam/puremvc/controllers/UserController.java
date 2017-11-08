package pl.adam.puremvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkyNET on 2017-11-08.
 */

@RequestMapping("user")
@Controller
public class UserController {

    @GetMapping("add")
    public void setUser(@RequestParam String name, HttpServletRequest request) {
        request.getSession().setAttribute("user", name);
    }

}
