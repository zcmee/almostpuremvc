package pl.adam.puremvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.adam.puremvc.pl.adam.puremvc.services.IssueService;

/**
 * Created by SkyNET on 2017-11-01.
 */

@Controller
public class IssueController {
    private IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/**")
    @ResponseBody
    public String test() {
        return issueService.generate();
    }

}
