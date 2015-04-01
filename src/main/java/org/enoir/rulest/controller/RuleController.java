package org.enoir.rulest.controller;

import org.enoir.rulest.model.Rule;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by frank on 2015/4/1.
 */
@RestController
public class RuleController {

    @RequestMapping(value = "/rule",method = RequestMethod.GET)
    public List<Rule> getAllRules(){
        return null;
    }

}
