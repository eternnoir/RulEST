package org.enoir.rulest.ruleengine.Exception;

import org.enoir.rulest.model.Rule;

/**
 * Created by frank on 2015/4/20.
 */
public class RulePackageNotFoundException extends BaseException {
    private String rulePackageName;
    public RulePackageNotFoundException(String rulePackageName,String message){
        super("01",message);
    }
}
