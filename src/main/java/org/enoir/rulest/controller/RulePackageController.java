package org.enoir.rulest.controller;

import org.enoir.rulest.ruleengine.RulePackage;
import org.enoir.rulest.ruleengine.RulePackageManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by frank on 2015/4/1.
 */
@RestController
public class RulePackageController {

    @RequestMapping(value = "/rulepackage", method = RequestMethod.GET)
    public List<RulePackage> getAllRulePackages() {
        return RulePackageManager.getInstance().getRulePackages();
    }

}
