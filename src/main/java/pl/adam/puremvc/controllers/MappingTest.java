package pl.adam.puremvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@RestController
@RequestMapping("mapping")
public class MappingTest {


    @RequestMapping("/all")
    public String test1() {
        return "/**";
    }

    //ogólna róznica pomiedzy jedna a 2gwiazdkami. Ze jedna to dowolny znak oprócz /
    @RequestMapping("mapping/**")
    public String test2() {
        return "/mapping/**";
    }

    @RequestMapping("mapping/*/mapping")
    public String test3() {
        return "/mapping/*/mapping";
    }

    @RequestMapping("mapping/te*a/mapping")
    public String test4() {
        return "Terka tak naprawde nigdy nie istniał";
    }

    @GetMapping("op/{opa}/{opti}")
    public String op(@PathVariable("opti") Optional<String> name) {
        return name.orElse("Nic nie podałaś gnido");
    }

    @GetMapping("el/{name:[a-z]+}{id:[0-9]+}")
    public String advanceEL(@PathVariable("name") String name, @PathVariable("id") int id) {
        return name + " = " + id;
    }

    //    @TODO
    @GetMapping("ope/{opti}")
    public String optionalWithException(@PathVariable("name") Optional<String> name) {
        return name.orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping("header")
    public String getRequestHeader(@RequestHeader("User-Agent") String agent) {
        return agent;
    }

    //coookie operation
    @GetMapping("cookie")
    public String getCookie(@RequestParam(name = "row-cunt", required = false) Integer rowCount,
                            @CookieValue(name = "cuck", required = false) String cookie,
                            HttpServletResponse response
    ) {

        if(cookie == null) {
            Cookie newCookie = getCookie("cuck", "666");
            response.addCookie(newCookie);
            return "ustawiam wartość domyślną ::: " + newCookie.getValue();
        }

        if (rowCount == null && cookie != null) {
            return  "Aktualny cookies: " + cookie.toString();
        } else {
            Cookie newCookie = getCookie("cuck", rowCount.toString());
            response.addCookie(newCookie);
            return "CookiesMania " + newCookie.getValue();
        }

    }

    private Cookie getCookie(String name, String value) {
        return new Cookie(name, value);
    }

}