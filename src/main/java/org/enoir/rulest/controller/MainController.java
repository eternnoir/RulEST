package org.enoir.rulest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frank on 2015/4/1.
 */
@RestController
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "Hello RulEST.";
    }
}
