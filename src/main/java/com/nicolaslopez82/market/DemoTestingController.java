package com.nicolaslopez82.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class DemoTestingController {
    @GetMapping("/say-hi")
    public String greeting(){
        return "Hi buddy!";
    }
}
