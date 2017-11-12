package pl.adam.puremvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.adam.puremvc.dto.Issue;
import pl.adam.puremvc.dto.RecordRange;
import pl.adam.puremvc.services.CrudIssue;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//import pl.adam.puremvc.services.IssueFreemarkerService;


/**
 * Created by SkyNET on 2017-11-11.
 */

@Controller
@RequestMapping("freemarker")
public class FreemarkerController {
    private CrudIssue crudIssue;

    @Autowired
    public FreemarkerController(CrudIssue crudIssue) {
        this.crudIssue = crudIssue;
    }

    @GetMapping("comment/{id}")
    public String getComment(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "comment";
    }

    @GetMapping("muted")
    public String getDuo() {
        return "muted";
    }

    @GetMapping("issue/all")
    public String getIssue(Model model) {
        model.addAttribute("issues", crudIssue.findAll());
        return "issueList";
    }

    @GetMapping("conventer")
    @ResponseBody
    public Issue conventerExample(@RequestParam("id") Integer id) {
          return crudIssue.findAll()
                .stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                  .orElseThrow( () -> new IllegalArgumentException("Nie prawidłowe ID kurwo babilońska") );
    }

}
