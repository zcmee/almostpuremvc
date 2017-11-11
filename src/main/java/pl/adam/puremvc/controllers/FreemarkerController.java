package pl.adam.puremvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SkyNET on 2017-11-11.
 */

@Controller
@RequestMapping("freemarker")
public class FreemarkerController {

    @GetMapping("comment/{id}")
    public String getComment(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "comment";
    }

    @GetMapping("muted")
    public String getDuo() {
        return "muted";
    }

}
