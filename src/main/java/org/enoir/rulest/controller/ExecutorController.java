package org.enoir.rulest.controller;

import org.enoir.rulest.model.ExcuteRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frank on 2015/4/1.
 */
@RestController
public class ExecutorController {
    @RequestMapping(value = "/execute",method = RequestMethod.POST)
    public String execute(@RequestBody ExcuteRequest excuteRequest) {
        if(excuteRequest == null){
            return "ERROR";
        }
        return excuteRequest.getPackageName();
    }
}
