package pl.adam.puremvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by SkyNET on 2017-11-01.
 */

@Controller
public class IssueController {

    @GetMapping("/**")
    @ResponseBody
    public String test() {
        return "Ty jebana Polska KURWOOOO !!!!!";
    }

}
