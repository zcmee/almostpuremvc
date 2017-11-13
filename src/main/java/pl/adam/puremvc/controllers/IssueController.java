package pl.adam.puremvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.adam.puremvc.dto.IssueForm;
import pl.adam.puremvc.dto.RecordRange;
import pl.adam.puremvc.services.IssueService;

import javax.validation.Valid;

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

    @GetMapping("conventer")
    @ResponseBody
    public Integer conventerExample( @RequestParam("range") RecordRange rangeRecord) {
        return rangeRecord.getFrom() + rangeRecord.getTo();
    }

    @PostMapping(value = "validator/example1", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String conventerExample(@Valid IssueForm issueForm, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            System.out.println(bindingResult.toString());
            throw new IllegalArgumentException("Nie prawidłowy format BIATCH!!!");
        }

        return "JEzuss";
    }

}
