package org.example.eduardosimpleservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoeController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Spring!";
    }
}
