package pl.adam.puremvc.controllers;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.adam.puremvc.api.Response;
import pl.adam.puremvc.dto.IssueForm;
import pl.adam.puremvc.dto.RecordRange;
import pl.adam.puremvc.services.IssueService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Produces;

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


    @GetMapping("satantest")
    @ResponseBody
    public Integer satanTest() {
        return 666;
    }

    @GetMapping("error404")
    @ResponseBody
    public ResponseEntity<HttpStatus> get404Exception() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("conventer")
    @ResponseBody
    @Produces("application/json")
    public Response conventerExample(@RequestParam("range") RecordRange rangeRecord) {
        Integer result = rangeRecord.getFrom() + rangeRecord.getTo();
        return new Response(result);
    }

    @PostMapping(value = "validator/example1", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String conventerExample(@Valid IssueForm issueForm, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            System.out.println(bindingResult.toString());
            throw new IllegalArgumentException("Nie prawidłowy format BIATCH!!!");
        }

        return "Jezuu";
    }

    @GetMapping("currentuser")
    @ResponseBody
    public String showCurrentlyLoggedUser(HttpServletRequest request) {
        return "Użytkownik : " + request.getRemoteUser() + " zalogowany jest jako " + request.getUserPrincipal().getName() + "/";
    }

}
