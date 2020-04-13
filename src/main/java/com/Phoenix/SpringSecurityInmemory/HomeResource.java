package com.Phoenix.SpringSecurityInmemory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public String home()
    {
        return ("<h1> Welcome to home </h1>");
    }

    @GetMapping("/User")
    public String User()
    {
        return ("<h1> Welcome to User </h1>");
    }

    @GetMapping("/Admin")
    public String Admin(){
        return ("<h1> Welcome to Admin </h1>");
    }
}
